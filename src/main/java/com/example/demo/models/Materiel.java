package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Materiel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String ref;
	
	//relation avec la salle
	@ManyToOne
	@JoinColumn(name = "salle_id")
	@JsonBackReference
	private Salle Msalle;
	
	@JsonIgnore
	public Salle getMsalle() {
		return Msalle;
	}

	@JsonIgnore
	public void setMsalle(Salle msalle) {
		Msalle = msalle;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}
	

	@JsonIgnore
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	//relation avec la reservation 
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	@JsonBackReference
	private Reservation reservation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
