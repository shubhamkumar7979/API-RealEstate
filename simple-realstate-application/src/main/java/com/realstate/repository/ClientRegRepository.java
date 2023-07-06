package com.realstate.repository;

import com.realstate.entity.Address;
import com.realstate.entity.ClientReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRegRepository extends JpaRepository<ClientReg,Integer> {
}
