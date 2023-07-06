package com.realstate.repository;

import com.realstate.entity.Property;
import com.realstate.entity.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalAgreementRepository extends JpaRepository<RentalAgreement,Integer> {
}
