package com.realstate.service.impl;

import com.realstate.entity.Owner;
import com.realstate.entity.Property;
import com.realstate.entity.PropertyForRent;
import com.realstate.exception.ResourceNotFoundException;
import com.realstate.payload.OwnerDto;
import com.realstate.payload.PropertyDto;
import com.realstate.repository.*;
import com.realstate.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public OwnerDto createOwner(OwnerDto ownerDto,int propertyId) {
        Property property = propertyRepository.findById(propertyId).orElseThrow(()->new ResourceNotFoundException("property", "propertyId", propertyId));

        Owner owner = mapToEntity(ownerDto);
      owner.setProperty(property);


        Owner owner1 = ownerRepository.save(owner);
        return  mapToDto(owner1);


    }

    @Override
    public List<OwnerDto> findAllOwners() {
        List<Owner> all = ownerRepository.findAll();
        return  all.stream().map(owner->mapToDto(owner)).collect(Collectors.toList());
    }


  Owner  mapToEntity(OwnerDto ownerDto){
        return mapper.map(ownerDto, Owner.class);
    }

    OwnerDto  mapToDto(Owner owner){
        return mapper.map(owner,OwnerDto.class);
    }
}
