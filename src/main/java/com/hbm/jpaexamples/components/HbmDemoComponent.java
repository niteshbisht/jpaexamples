package com.hbm.jpaexamples.components;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.stereotype.Component;

import com.hbm.jpaexamples.db.entities.Country;
import com.hbm.jpaexamples.db.repo.CountryJpaRepo;
import com.hbm.jpaexamples.db.repo.CountryListPagingRepo;
import com.hbm.jpaexamples.db.repo.CountryPagingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class HbmDemoComponent implements CommandLineRunner {
	
	private final CountryPagingRepository countryPagingRepository;
	private final CountryListPagingRepo countryListPagingRepo;
	private final CountryJpaRepo countryJpaRepo;

	public void fetchCountries() {
		Pageable pageOfSize = Pageable.ofSize(10);
		Page<Country> firstPageData = countryPagingRepository.findAll(pageOfSize.first());
		displayPageData(firstPageData);
//		Page<Country> secondPage = countryPagingRepository.findAll(pageOfSize.next());
//		displayPageData(secondPage);
	}
	
	public void listPagingDemo() {
		TypedSort<Country> countrySort = Sort.sort(Country.class);
		Sort descending = countrySort.by(Country::getName).descending();
		List<Country> sortedBynameDesc = countryJpaRepo.findAll(descending);
		displayListData(sortedBynameDesc);
	}
	
	private void displayListData(List<Country> pageData) {
		pageData.forEach(item -> {
			log.info("ID={} CountryName={}", item.getCid() ,item.getName());
		});
	}
	
	private void displayPageData(Page<Country> pageData) {
		pageData.forEach(item -> {
			log.info("ID={} CountryName={}", item.getCid() ,item.getName());
		});
		List<Country> content = pageData.getContent();
		Country country = content.get(0);
		country.setName("test");		
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		fetchCountries();
		//listPagingDemo();
	}
}
