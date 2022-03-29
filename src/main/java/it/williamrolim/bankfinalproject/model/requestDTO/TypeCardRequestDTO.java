package it.williamrolim.bankfinalproject.model.requestDTO;

public class TypeCardRequestDTO {
	private Integer id;
	private String name;
	
	public TypeCardRequestDTO() {
	}
	
	
	

	public TypeCardRequestDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}




	public TypeCardRequestDTO(String name) {
		this.name = name;
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

	
	
}
