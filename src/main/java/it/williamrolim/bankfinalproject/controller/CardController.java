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
import it.williamrolim.bankfinalproject.model.requestDTO.AccountRequestDTO;
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
		
		
	    @PostMapping("/{accountId}/insert/{typecardId}")
	    public ResponseEntity<Card> insertAccount(@RequestBody final CardRequestDTO cardRequestDTO,
	    		@PathVariable Integer accountId, @PathVariable Integer typecardId) {
	    	Card card = cardService.insertCard(cardRequestDTO, accountId, typecardId);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(card.getId())
	                .toUri();
	        return ResponseEntity.created(location).build();
	    }
	    
	    
	    @GetMapping("/{cardId}")
	    public ResponseEntity<Card> getCard(@PathVariable final Integer cardId) {
	    	Card card = cardService.getCardID(cardId);
	        return new ResponseEntity<>(card, HttpStatus.OK);
	    }
	    
	    @GetMapping("/getAll")
	    public ResponseEntity<List<Card>> getAllCards() {
	        List<Card> card = cardService.getAllCards();
	        return new ResponseEntity<>(card, HttpStatus.OK);
	    }
	    
	    @PutMapping("/update/{cardId}")
	    public ResponseEntity<Card> updateAccount(@RequestBody final CardRequestDTO cardRequestDTO,
	                                               @PathVariable final Integer cardId) {
	    	Card card = cardService.updateCard(cardId, cardRequestDTO);
			return ResponseEntity.ok().body(card);
	    }
	    
	    
	    @DeleteMapping("/delete/{cardId}")
	    public ResponseEntity<Card> deleteCard(@PathVariable final Integer cardId) {	   
	    	 Card card = cardService.deleteCard(cardId);
	        return new ResponseEntity<>(card, HttpStatus.OK);
	    }


}
