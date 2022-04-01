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
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.requestDTO.CardRequestDTO;
import it.williamrolim.bankfinalproject.service.AccountService;
import it.williamrolim.bankfinalproject.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

		@Autowired
		CardService cardService;
		
		@Autowired
		AccountService accountService;
		
		@ApiOperation(value= "Persistindo novo cartão", notes = "Endpoint destinado a  persistir no cartão")
		   @ApiResponses(value = {
				   @ApiResponse(code = 201, message = "Sucess"),
				   @ApiResponse(code = 400, message = "Bad Request", response = ErrorConstraint.class),
				   @ApiResponse(code = 404, message = "Not Found" , response = ErroPadrao.class),
				   @ApiResponse(code = 404, message = "Failure",response = ErroPadrao.class)
				   
		   })
	    @PostMapping("/{accountId}/insert/{typecardId}")
	    public ResponseEntity<Card> insertCard(@RequestBody final CardRequestDTO cardRequestDTO,
	    		@PathVariable Integer accountId, @PathVariable Integer typecardId) {
	    	Card card = cardService.insertCard(cardRequestDTO, accountId, typecardId);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(card.getId())
	                .toUri();
	        return ResponseEntity.created(location).build();
	    }
	    
	    @ApiOperation(value= "Pesquisando card pelo ID", notes = "Endpoint destinado a buscar novo card pelo id", response = Card.class)
	    @GetMapping("/{cardId}")
	    public ResponseEntity<Card> getCard(@PathVariable final Integer cardId) {
	    	Card card = cardService.getCardID(cardId);
	        return new ResponseEntity<>(card, HttpStatus.OK);
	    }
	    @ApiOperation(value= "Pesquisando todos os cartões associados", notes = "Endpoint destinado a buscar todos os cartões", response = Card.class)
	    @GetMapping("/getAll")
	    public ResponseEntity<List<Card>> getAllCards() {
	        List<Card> card = cardService.getAllCards();
	        return new ResponseEntity<>(card, HttpStatus.OK);
	    }
	    
	    @ApiOperation(value= "Atualizando o cartão  pelo ID", notes = "Endpoint destinado a atualizar o cartao pelo ID")
	    @PutMapping("/update/{cardId}")
	    public ResponseEntity<Card> updateAccount(@RequestBody final CardRequestDTO cardRequestDTO,
	                                               @PathVariable final Integer cardId) {
	    	Card card = cardService.updateCard(cardId, cardRequestDTO);
			return ResponseEntity.ok().body(card);
	    }
	    
	    @ApiOperation(value= "Deletando conta pelo ID", notes = "Endpoint destinado a deletar a conta pelo ID")
	    @DeleteMapping("/delete/{cardId}")
	    public ResponseEntity<Void> deleteCard(@PathVariable Integer cardId) {	   
	    	 cardService.deleteCard(cardId);     
	    	 return ResponseEntity.ok().build();
	    }


}
