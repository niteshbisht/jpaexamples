package com.hbm.jpaexamples.db.repo.insurance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbm.jpaexamples.db.entities.insurance.CreditCardInfo;

public interface CreditCardInfoRepository extends JpaRepository<CreditCardInfo, Long>
{

}
