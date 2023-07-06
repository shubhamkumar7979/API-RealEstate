package com.realstate.service.impl;

import com.realstate.entity.ClientReg;
import com.realstate.entity.ClientWish;
import com.realstate.entity.Feature;
import com.realstate.entity.PropertyForRent;
import com.realstate.payload.ClientRegDto;
import com.realstate.payload.ClientWishDto;
import com.realstate.payload.FeatureDto;
import com.realstate.repository.ClientRegRepository;
import com.realstate.repository.ClientWishRepository;
import com.realstate.repository.FeatureRepository;
import com.realstate.service.ClientWishService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientWishServiceImpl implements ClientWishService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientWishRepository clientWishRepository;

    @Autowired
    private ClientRegRepository clientRegRepository;

    @Autowired
    private FeatureRepository featureRepo;
    @Override
    public ClientWishDto createClientWish(ClientWishDto clientWishDto,int clientId,int featureCode) {
        ClientReg clientReg = clientRegRepository.findById(clientId).get();
        Feature feature = featureRepo.findById(featureCode).get();
        ClientWish clientWish = mapToEntity(clientWishDto);
        clientWish.setClientReg(clientReg);
        clientWish.setFeature(feature);
        ClientWish wish = clientWishRepository.save(clientWish);
        return mapToDto(wish);
    }



    @Override
    public List<ClientWishDto> findAllClientWish() {
        List<ClientWish> all = clientWishRepository.findAll();
        return  all.stream().map(clientWish->mapToDto(clientWish)).collect(Collectors.toList());
    }

    ClientWish mapToEntity(ClientWishDto clientWishDto){
        return mapper.map(clientWishDto, ClientWish.class);
    }

    ClientWishDto  mapToDto(ClientWish clientWish){
        return mapper.map(clientWish,ClientWishDto.class);
    }
}
