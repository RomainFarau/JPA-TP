package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Projet {
	
@Id
@GeneratedValue
  private int id;
  private String nom;
  @ManyToMany(mappedBy="projets")
  private Collection<Employe> employes=new ArrayList<Employe>();
  @OneToMany(cascade=CascadeType.PERSIST,mappedBy="projet")
  private Collection<Participation> participations=new ArrayList<Participation>(); 
	
 
	public Projet(){
	  
  }
  
  public Projet(String pNom){
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
  
  public Collection<Employe> getEmployes() {
		return employes;
	}
	
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
	public void addEmploye(Employe pE){
		for (Employe employe : employes) {
			if(employe.equals(pE)){
				return ;
			}
		}
		getEmployes().add(pE);
	}
	
	
	void ajouterParticipation(Participation pPartcipation){
		this.getParticipations().add(pPartcipation);
	}

	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(Collection<Participation> participations) {
		this.participations = participations;
	}
}
