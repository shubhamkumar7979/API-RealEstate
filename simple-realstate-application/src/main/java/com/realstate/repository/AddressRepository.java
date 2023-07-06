package com.realstate.repository;

import com.realstate.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address,Integer> {
}
