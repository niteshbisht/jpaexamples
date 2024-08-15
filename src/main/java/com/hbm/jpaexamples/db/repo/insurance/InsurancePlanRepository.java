package com.hbm.jpaexamples.db.repo.insurance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.hbm.jpaexamples.db.entities.insurance.InsurancePlan;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;



public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Long>
{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(@QueryHint(name="org.hibernate.fetchSize", value="10"))
    @Query(value="from InsurancePlan i where i.status = ?1")
    List<InsurancePlan> findByStatus(String status);
}
