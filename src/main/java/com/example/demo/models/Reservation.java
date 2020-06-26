package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String numSalle,manifestation,Visiteur,mailVisiteur,statutVisiteur,etat;
	private Date debut,fin;
	private double prix;
	
	//relation avec la salle
	@OneToOne(mappedBy = "reservation")
	@JsonManagedReference
	private Salle salle;
	
	@JsonIgnore
	public List<Materiel> getMateriels() {
		return materiels;
	}

	@JsonIgnore
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	@JsonIgnore
	public Municipal getMunicipal() {
		return municipal;
	}

	@JsonIgnore
	public void setMunicipal(Municipal municipal) {
		this.municipal = municipal;
	}

	//Relation avec le materiel
	@OneToMany(mappedBy = "reservation")
	@JsonManagedReference
	private List<Materiel> materiels = new ArrayList<>();
	
	//relation avec le municipal
	@ManyToOne
	@JoinColumn(name = "municipal_id")
	@JsonBackReference
	private Municipal municipal;
	

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}

	public String getManifestation() {
		return manifestation;
	}

	public void setManifestation(String manifestation) {
		this.manifestation = manifestation;
	}

	public String getVisiteur() {
		return Visiteur;
	}

	public void setVisiteur(String visiteur) {
		Visiteur = visiteur;
	}

	public String getMailVisiteur() {
		return mailVisiteur;
	}

	public void setMailVisiteur(String mailVisiteur) {
		this.mailVisiteur = mailVisiteur;
	}

	public String getStatutVisiteur() {
		return statutVisiteur;
	}

	public void setStatutVisiteur(String statutVisiteur) {
		this.statutVisiteur = statutVisiteur;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	
}
