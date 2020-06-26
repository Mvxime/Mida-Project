package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String adresse,name,sfce;
	private int cpmin,cpmax;
	
	//relation avec la reservation
	@OneToOne
	@JoinColumn(name = "reservation_id")
	@JsonBackReference
	private Reservation reservation;
	

	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	@JsonIgnore
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@JsonIgnore
	public Gardien getGarde() {
		return garde;
	}

	@JsonIgnore
	public void setGarde(Gardien garde) {
		this.garde = garde;
	}

	@JsonIgnore
	public List<Materiel> getMateriels() {
		return materiels;
	}

	@JsonIgnore
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

		//relation avec le gardien
		@OneToOne
		@JoinColumn(name = "gardien_id")
		@JsonBackReference
		private Gardien garde;
	
	//Relation avec le materiel
		@OneToMany(mappedBy = "Msalle")
		@JsonManagedReference
		private List<Materiel> materiels = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse = adresse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpmin() {
		return cpmin;
	}

	public void setCpmin(int cpmin) {
		this.cpmin = cpmin;
	}

	public int getCpmax() {
		return cpmax;
	}

	public void setCpmax(int cpmax) {
		this.cpmax = cpmax;
	}

	public String getSfce() {
		return sfce;
	}

	public void setSfce(String sfce) {
		this.sfce = sfce;
	}
		
	
}
