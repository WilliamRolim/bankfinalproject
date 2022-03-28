package it.williamrolim.bankfinalproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.williamrolim.bankfinalproject.exceptions.ErroPadrao;
import it.williamrolim.bankfinalproject.exceptions.ErrorConstraint;
import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.TypeCardRequestDTO;
import it.williamrolim.bankfinalproject.service.TypeCardService;

@RestController
@RequestMapping("/typecard")
public class TypeCardController {

	
	@Autowired
	TypeCardService typecardService;

	   @ApiOperation(value= "Persistindo novo type card", notes = "Endpoint destinado a persistir novo type card")
	   @ApiResponses(value = {
			   @ApiResponse(code = 201, message = "Sucess"),
			   @ApiResponse(code = 400, message = "Bad Request", response = ErrorConstraint.class),
			   @ApiResponse(code = 404, message = "Not Found" , response = ErroPadrao.class),
			   @ApiResponse(code = 404, message = "Failure",response = ErroPadrao.class)
			   
	   })
    @PostMapping
    public ResponseEntity<TypeCard> insertAccount(@RequestBody final TypeCardRequestDTO typecardRequestDTO) {
    	TypeCard typeCard = typecardService.insertTypeCard(typecardRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(typeCard.getType_card_id())
                .toUri();
        return ResponseEntity.created(location).build();    }
    
	    @ApiOperation(value= "Buscando tipo do cartão pelo ID", notes = "Endpoint destinado a buscar todo Typo do cartão pelo ID", response = TypeCard.class)
    @GetMapping("/{typecardId}")
    public ResponseEntity<TypeCard> getTypeCardId(@PathVariable final Integer typecardId) {
    	TypeCard typeCard = typecardService.getTypeCardId(typecardId);
        return new ResponseEntity<>(typeCard, HttpStatus.OK);
    }
    @ApiOperation(value= "Visualizando todo tipo do cartão pelo ID", notes = "Endpoint destinado a deletar o Typo do cartão pelo ID", response = TypeCard.class)
    @GetMapping("/getAll")
    public ResponseEntity<List<TypeCard>> getAllTypeCards() {
        List<TypeCard> typecard = typecardService.getAllTypeCards();
        return new ResponseEntity<>(typecard, HttpStatus.OK);
    }

    @ApiOperation(value= "Deletando o tipo do cartão pelo ID", notes = "Endpoint destinado a deletar o Tipo do cartão pelo ID")
    @DeleteMapping("/delete/{typecardId}")
    public void deleteTypeCard(@PathVariable final Integer typecardId) {
    	typecardService.deleteTypeCard(typecardId);
             
    }
    @ApiOperation(value= "Atualizando o tipo do cartão pelo ID", notes = "Endpoint destinado a deletar o Tipo do cartão pelo ID")
    @PutMapping("/update/{typecardId}")
    public ResponseEntity<TypeCard> updateTypeCard(@RequestBody final TypeCardRequestDTO  typecardRequestDTO,
                                               @PathVariable final Integer typecardId) {
    	TypeCard typeCard = typecardService.updateTypeCard(typecardId, typecardRequestDTO);
        return new ResponseEntity<>(typeCard, HttpStatus.OK);
    }
}
