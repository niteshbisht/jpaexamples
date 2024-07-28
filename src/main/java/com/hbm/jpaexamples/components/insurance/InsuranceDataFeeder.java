package com.hbm.jpaexamples.components.insurance;

import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hbm.jpaexamples.db.entities.insurance.CreditCardInfo;
import com.hbm.jpaexamples.db.entities.insurance.InsurancePlan;
import com.hbm.jpaexamples.db.repo.insurance.CreditCardInfoRepository;
import com.hbm.jpaexamples.db.repo.insurance.InsurancePlanRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class InsuranceDataFeeder {

	private final InsurancePlanRepository insurancePlanRepository;
	private final CreditCardInfoRepository creditCardInfoRepository;

	@Scheduled(fixedDelay=20000)
	public void feedData() {
		for (int i = 0; i < 10; i++) {
			 var cardInfo = new CreditCardInfo();
			final var randomUUID = UUID.randomUUID().toString().replace("-", "");
			cardInfo.setCardNumber(randomUUID.substring(0, randomUUID.length()/2));
			cardInfo = saveCardData(cardInfo);
			saveInsurancePlan(cardInfo);
			var size = insurancePlanRepository.count();
			log.info("insrance plan size={}", size);
		}
	}

	@Transactional
	public CreditCardInfo saveCardData(CreditCardInfo cardInfo) {
		cardInfo = creditCardInfoRepository.saveAndFlush(cardInfo);
		log.info("Saved card={} ", cardInfo.getId());
		return cardInfo;
	}

	@Transactional
	public void saveInsurancePlan(CreditCardInfo cardInfo) {
		var insurancePlan = new InsurancePlan();
		insurancePlan.setStatus("DORMANT");
		final var randomUUIDPlan = UUID.randomUUID().toString().replace("-", "");
		insurancePlan.setPlanName(randomUUIDPlan.substring(0, randomUUIDPlan.length()/2));
		insurancePlan=insurancePlanRepository.saveAndFlush(insurancePlan);
		cardInfo.setInsurancePlan(insurancePlan);
		insurancePlan.setCreditCardInfo(cardInfo);
		insurancePlan=insurancePlanRepository.saveAndFlush(insurancePlan);
		log.info("Saved insurancePlan={} ", insurancePlan.getId());
	}

}
