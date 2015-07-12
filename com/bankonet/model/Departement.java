package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement {

	@Id
	@GeneratedValue
  private int id;
	@Basic(fetch = FetchType.LAZY, optional = false)
	@Column(length=25)
  private String nom;
  private String lieu;
  @OneToMany(mappedBy="departement")
 private Collection<Employe> employes = new ArrayList<Employe>();

  public Departement(){
	  
  }
  
  public Departement(String pNom, String pLieu){
	  this.setNom(pNom);
	  this.setLieu(pLieu);
  }
  /**
   * Retourne l'identificateur géré par le SGBD. Identifie une ligne
   * de la base.
   */
  
  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public Collection<Employe> getEmployes() {
    return employes;
  }

  /**
   * Méthode utilitaire souvent employée pour les associations
   * bidirectionnelles pour éviter d'oublier de mettre à jour
   * un des bouts de l'assocation.
   * @param employe
   */
  public void addEmploye(Employe employe) {
    // Si l'employé est déjà dans un département, il faut l'enlever de
    // ce département dans la liste des employés de ce département
    Departement ancienDept;
    if ((ancienDept = employe.getDepartement()) != null) {
      ancienDept.employes.remove(employe);
    }
    employes.add(employe);
    employe.setDepartement(this);
  }

}
