package com.hbm.jpaexamples.db.repo.insurance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbm.jpaexamples.db.entities.insurance.InsurancePlan;

public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Long>
{

}
