package com.hbm.jpaexamples.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbm.jpaexamples.db.entities.Country;

public interface CountryJpaRepo extends JpaRepository<Country, Long> {

}
