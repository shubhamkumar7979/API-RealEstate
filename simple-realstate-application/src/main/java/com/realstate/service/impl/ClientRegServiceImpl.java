package com.realstate.service.impl;

import com.realstate.entity.ClientReg;

import com.realstate.payload.ClientRegDto;

import com.realstate.repository.ClientRegRepository;

import com.realstate.service.ClientRegService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientRegRepository clientRegRepository;
    @Override
    public ClientRegDto createClientReg(ClientRegDto clientRegDto) {

        ClientReg clientReg = mapToEntity(clientRegDto);
        clientReg.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));
        ClientReg reg = clientRegRepository.save(clientReg);
        return mapToDto(reg);

    }

    @Override
    public List<ClientRegDto> findAllClientReg() {

        List<ClientReg> all = clientRegRepository.findAll();
        return  all.stream().map(clientReg->mapToDto(clientReg)).collect(Collectors.toList());
    }



   ClientReg mapToEntity(ClientRegDto clientRegDto){
        return mapper.map(clientRegDto, ClientReg.class);
    }

    ClientRegDto  mapToDto(ClientReg clientReg){
        return mapper.map(clientReg,ClientRegDto.class);
    }
}
