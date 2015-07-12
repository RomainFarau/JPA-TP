package com.bankonet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/** 
 * Un employé de l'entreprise.
 */
@Entity
@DiscriminatorValue("E")
@NamedQuery(name="findEmployes",
query="Select e from Employe as e where upper(e.departement.nom) = :nomDept")
public class Employe extends Personne {
	
	
	private BigDecimal salaire;
	@ManyToOne
	private Employe superieur;
	@ManyToOne
	private Departement departement;
	
	@ManyToMany
	@JoinTable(
			name="EMP_PROJ",
			joinColumns={@JoinColumn(name="EMP_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="PROJ_ID", referencedColumnName="ID")})
	private Collection<Projet> projets= new ArrayList<Projet>();
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="employe")
	private Collection<Participation> participations=new ArrayList<Participation>(); 

	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(Collection<Participation> participations) {
		this.participations = participations;
	}

	public Employe(){
		super();
	}
	
	public Employe(String pNom){
		super(pNom);
	}
	
	public Employe(String pNom, Departement pDepartement, Employe pSuperieur){
		super(pNom);
		this.setDepartement(pDepartement);
		this.getDepartement().addEmploye(this);
		this.setSuperieur(pSuperieur);
		
	}
	
	
	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public Employe getSuperieur() {
		return superieur;
	}

	public void setSuperieur(Employe employe) {
		this.superieur = employe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Collection<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}
	
	public void ajouterProjet(Projet pProjet){
		Collection<Employe> employesBis=pProjet.getEmployes();
		if(employesBis!=null){
			for (Employe employe : employesBis) {
				if(employe.equals(this)){
					retirerProjet(pProjet);
				}
			}
		}
		pProjet.addEmploye(this);
		this.getProjets().add(pProjet);
		
	}
	
	public void retirerProjet(Projet pProjet){
		pProjet.getEmployes().remove(this);
		this.projets.remove(pProjet);
	}
	
	public void ajouterParticipant(Projet pProjet, String fonction){
		Participation participation=new Participation(fonction);
		participation.setEmploye(this);
		participation.setProjet(pProjet);
		this.getParticipations().add(participation);
		pProjet.ajouterParticipation(participation);
		
	}
	
}
