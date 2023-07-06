package com.realstate.service;

import com.realstate.payload.ClientRegDto;
import com.realstate.payload.ClientWishDto;

import java.util.List;

public interface ClientWishService {

    ClientWishDto createClientWish(ClientWishDto clientWishDto,int clientId,int featureCode);
    List<ClientWishDto> findAllClientWish();
}
