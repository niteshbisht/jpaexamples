package com.hbm.jpaexamples.db.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hbm.jpaexamples.db.entities.Country;

public interface CountryPagingRepository extends PagingAndSortingRepository<Country, Long> {
}
