package it.williamrolim.bankfinalproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name = "type_card")
public class TypeCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer type_card_id;

	@NotNull
	private String name;	//	@JsonProperty(namespace = "typeCard")
//	@OneToOne(mappedBy = "typeCard",cascade = { CascadeType.ALL })
//	@JoinColumn(name = "type_card_id")
	
	@OneToMany(mappedBy = "typeCard", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Card> card;

	public TypeCard() {
	}
	
	
	public TypeCard(Integer type_card_id, String name, List<Card> card) {
		this.type_card_id = type_card_id;
		this.name = name;
		this.card = card;
	}


	public Integer getType_card_id() {
		return type_card_id;
	}


	public void setType_card_id(Integer type_card_id) {
		this.type_card_id = type_card_id;
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