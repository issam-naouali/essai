package com.esprit.essaii.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String nom;
	
   // @DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date datedenaissance;
	
	@Enumerated(EnumType.STRING)
	Poste poste;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Employee(Long id, String nom, Date datedenaissance, Poste poste) {
		super();
		this.id = id;
		this.nom = nom;
		this.datedenaissance = datedenaissance;
		this.poste = poste;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nom=" + nom + ", datedenaissance=" + datedenaissance + ", poste=" + poste
				+ "]";
	}

	
}
