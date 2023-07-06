package com.realstate.repository;

import com.realstate.entity.PropertyForRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyForRentRepository extends JpaRepository<PropertyForRent,Integer> {
}
