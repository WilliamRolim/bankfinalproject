package it.williamrolim.bankfinalproject.responseDTO;

import java.util.List;

import it.williamrolim.bankfinalproject.model.Card;

public class TypeCardResponseDTO {

	private Integer id;
	private String name;
	private List<Card> card;
	
	public TypeCardResponseDTO() {
	}
	public TypeCardResponseDTO(Integer id, String name, List<Card> card) {
		this.id = id;
		this.name = name;
		this.card = card;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	
	
	
	
}
