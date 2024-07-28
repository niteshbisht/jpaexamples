package com.hbm.jpaexamples.db.repo;

import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.hbm.jpaexamples.db.entities.Country;

public interface CountryListPagingRepo extends ListPagingAndSortingRepository<Country, Long> {

}
