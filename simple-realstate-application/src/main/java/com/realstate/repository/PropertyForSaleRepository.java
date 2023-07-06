package com.realstate.repository;

import com.realstate.entity.PropertyForRent;
import com.realstate.entity.PropertyForSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyForSaleRepository  extends JpaRepository<PropertyForSale,Integer> {
}
