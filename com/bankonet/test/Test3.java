package com.bankonet.test;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankonet.model.Employe;



public class Test3 {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Employes");
		EntityManager em = emf.createEntityManager();
		
		
		String textQuery1="Select e from Employe as e where upper(e.departement.nom) = :nomDept";
		Query query1=em.createQuery(textQuery1);
		query1.setParameter("nomDept","Direction");
		
		List<Employe> listeEmployes =(List<Employe>)query1.getResultList();
		
		for (Employe employe : listeEmployes) {
			System.out.println("Employés du département Direction = "+employe.getNom());
		}
		
		String textQuery2="Select e.nom, e.salaire from Employe as e where upper(e.departement.nom) = :nomDept";
		
		Query query2=em.createQuery(textQuery2);
		query2.setParameter("nomDept","Direction");
		
		List<Object[]> employes2=(List<Object[]>)query2.getResultList();
		for (Object[] employe : employes2) {
			System.out.println("Employés du département Direction = "+employe[0] +" salaire "+employe[1]);
		}
		
		Query query3=em.createNamedQuery("findEmployes");
		query3.setParameter("nomDept","Direction");
		
		List<Employe> listeEmployes3 =(List<Employe>)query3.getResultList();
		
		for (Employe employe : listeEmployes3) {
			System.out.println(" les employes sont "+employe.getNom());
		}
		
		String textQuery4="Update employe emp Set emp.salaire=emp.salaire*1.05";
		
		Query query4=em.createQuery(textQuery4);
		
		
		
		
		em.close();
		emf.close();
	}
}
