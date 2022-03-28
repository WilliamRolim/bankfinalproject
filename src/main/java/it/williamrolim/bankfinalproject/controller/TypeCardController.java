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

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.AccountRequestDTO;
import it.williamrolim.bankfinalproject.model.requestDTO.TypeCardRequestDTO;
import it.williamrolim.bankfinalproject.service.TypeCardService;

@RestController
@RequestMapping("/typecard")
public class TypeCardController {

	
	@Autowired
	TypeCardService typecardService;
	
    @PostMapping
    public ResponseEntity<TypeCard> insertAccount(@RequestBody final TypeCardRequestDTO typecardRequestDTO) {
    	TypeCard typeCard = typecardService.insertTypeCard(typecardRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(typeCard.getType_card_id())
                .toUri();
        return ResponseEntity.created(location).build();    }
    
    @GetMapping("/{typecardId}")
    public ResponseEntity<TypeCard> getTypeCardId(@PathVariable final Integer typecardId) {
    	TypeCard typeCard = typecardService.getTypeCardId(typecardId);
        return new ResponseEntity<>(typeCard, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TypeCard>> getAllTypeCards() {
        List<TypeCard> typecard = typecardService.getAllTypeCards();
        return new ResponseEntity<>(typecard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{typecardId}")
    public void deleteTypeCard(@PathVariable final Integer typecardId) {
    	typecardService.deleteTypeCard(typecardId);
             
    }

    @PutMapping("/update/{typecardId}")
    public ResponseEntity<TypeCard> updateTypeCard(@RequestBody final TypeCardRequestDTO  typecardRequestDTO,
                                               @PathVariable final Integer typecardId) {
    	TypeCard typeCard = typecardService.updateTypeCard(typecardId, typecardRequestDTO);
        return new ResponseEntity<>(typeCard, HttpStatus.OK);
    }
}
