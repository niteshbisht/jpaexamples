package com.hbm.jpaexamples.db.entities.insurance;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class InsurancePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String planName;
	private String status;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="credit_card_id", referencedColumnName="id")
	private CreditCardInfo creditCardInfo;
}
