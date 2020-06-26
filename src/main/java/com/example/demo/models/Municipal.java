package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table
@DiscriminatorValue("M")
public class Municipal extends Employe {

	

	private String matricule;
	
	//Relation avec le materiel
		@OneToMany(mappedBy = "municipal")
		@JsonManagedReference
		private List<Reservation> reservation = new ArrayList<>();

		@JsonIgnore
	public List<Reservation> getReservation() {
			return reservation;
		}

		@JsonIgnore
		public void setReservation(List<Reservation> reservation) {
			this.reservation = reservation;
		}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
}
