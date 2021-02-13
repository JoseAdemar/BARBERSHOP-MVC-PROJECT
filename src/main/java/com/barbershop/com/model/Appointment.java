package com.barbershop.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "Appointment")
public class Appointment {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EqualsAndHashCode.Include
	 private Long id;
	
	 private String haircut_style;
	 
	 private String hair_cut;
	 
	 private String beard;
	 
	 private String date;
	 
	 private String  time;
}
