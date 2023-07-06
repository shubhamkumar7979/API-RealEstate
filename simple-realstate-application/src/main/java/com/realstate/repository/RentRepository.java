package com.realstate.repository;

import com.realstate.entity.Rent;
import com.realstate.entity.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Integer> {
}
