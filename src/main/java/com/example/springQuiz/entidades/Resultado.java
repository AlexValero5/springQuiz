package com.example.springQuiz.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESULTADO")
public class Resultado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID_RESULTADO")
	private Long idResultado;
	
	@Column(name="CASA_FINAL")
	private String casa;
	
	
	@Column(name="NOMBRE")
	private String nombreUser;
	
	public Resultado() {};

	public Resultado(String nombreUser,String casa) {
		super();
		this.casa=casa;
		
		this.nombreUser=nombreUser;
	}
	
	

	public String getNombreUser() {
		return nombreUser;
	}



	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}



	public Long getIdResultado() {
		return idResultado;
	}



	public void setIdResultado(Long idResultado) {
		this.idResultado = idResultado;
	}



	public String getCasa() {
		return casa;
	}



	public void setCasa(String casa) {
		this.casa = casa;
	}
	



	


}
	
	
	


