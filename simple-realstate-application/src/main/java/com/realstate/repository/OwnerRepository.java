package com.realstate.repository;

import com.realstate.entity.Owner;
import com.realstate.entity.PropertyForRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
