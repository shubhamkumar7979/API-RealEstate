package com.realstate.repository;


import com.realstate.entity.ClientWish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientWishRepository extends JpaRepository<ClientWish, Integer> {
}
