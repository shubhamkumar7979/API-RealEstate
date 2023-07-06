package com.realstate.repository;

import com.realstate.entity.Feature;
import com.realstate.entity.PropertyForSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature,Integer> {
}
