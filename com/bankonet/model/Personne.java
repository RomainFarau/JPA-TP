package com.bankonet.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR")
public abstract class Personne {

	@Id
	@GeneratedValue
	private int id;
	private String nom;

	public Personne(){
		
	}
	
	public Personne(String pNom){
		this.setNom(pNom);
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
