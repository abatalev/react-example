package com.batal.demo.springandreact.dto;

public class UserDTO {

	private String id;
	private String label;

	public UserDTO(String id, String label) {
        this.setId(id);
        this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}  
}
