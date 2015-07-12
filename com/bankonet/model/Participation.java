package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String fonction;
	@ManyToOne
	@JoinColumn(name="IDE")
	private Employe employe;
	@ManyToOne
	@JoinColumn(name="IDP")
	private Projet projet;
	
	public Participation(){
		
	}
	
	public Participation(String pFonction){
		this.setFonction(pFonction);
		
	}


	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
}
