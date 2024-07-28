package com.hbm.jpaexamples.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private long id;
	private String 	iso;
	private String 	name;
	private String 	nicename;
	private String 	iso3;
	private String 	numcode;
	private String 	phonecode;
}
