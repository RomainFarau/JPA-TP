package com.bankonet.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class Adresse {

  private int numero;
  private String rue;
  private String ville;

  
  public Adresse(){
	  
  }
  
  public Adresse(int pNumero, String pRue, String pVille){
	  this.setNumero(pNumero);
	  this.setRue(pRue);
	  this.setVille(pVille);
  }
  
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

}
