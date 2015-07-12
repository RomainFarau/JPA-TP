package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne {
	
	
  @OneToOne
  @Embedded
  private Adresse adresse;
  
  public Client(){
	  super();
  }
  
  public Client(String pNom, Adresse pAdresse){
	  super(pNom);
	  this.setAdresse(pAdresse);
  }
  
  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

}
