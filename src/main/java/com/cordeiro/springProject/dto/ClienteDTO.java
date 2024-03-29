package com.cordeiro.springProject.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.cordeiro.springProject.domain.Cliente;
import com.cordeiro.springProject.services.validation.ClienteUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
	
	@ClienteUpdate
	public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento Obrigatorio ")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres") 
	private String name;
	@NotEmpty(message="Preenchimento Obrigatorio ")
	@Email(message="E-mail Invalido")
	private String email;
	
	public ClienteDTO() {
}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		name= obj.getName();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
