package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@DiscriminatorValue("G")
@Table
public class Gardien extends Employe {

	
	//relation avec la salle
	@OneToOne(mappedBy = "garde")
	@JsonManagedReference
	private Salle salle;
	

	@JsonIgnore
	public Salle getSalle() {
		return salle;
	}

	@JsonIgnore
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
}
