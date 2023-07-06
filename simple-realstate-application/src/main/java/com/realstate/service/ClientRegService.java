package com.realstate.service;

import com.realstate.payload.ClientRegDto;
import com.realstate.payload.FeatureDto;

import java.util.List;

public interface ClientRegService {

    ClientRegDto createClientReg(ClientRegDto clientRegDto);
    List<ClientRegDto> findAllClientReg();
}
