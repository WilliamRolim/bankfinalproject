package it.williamrolim.bankfinalproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(name = "name")
	private String name;
	
//	@OneToMany(mappedBy = "typeCard", fetch = FetchType.LAZY) 
//	@JsonIgnore
//	private List<Card> card;

	public TypeCard() {
	}
	
	
	
	public TypeCard(Integer type_card_id, String name) {
		this.type_card_id = type_card_id;
		this.name = name;
	}



	public TypeCard(String name) {
		this.name = name;
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
	
}