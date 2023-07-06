package com.realstate.service.impl;

import com.realstate.entity.Address;
import com.realstate.entity.PropertyForRent;
import com.realstate.payload.AddressDto;
import com.realstate.payload.PropertyForRentDto;
import com.realstate.repository.AddressRepository;
import com.realstate.repository.PropertyForRentRepository;
import com.realstate.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = mapToEntity(addressDto);
        Address address1 = addressRepository.save(address);
        return mapToDto(address1);
    }

    @Override
    public List<AddressDto> findAllAddresses() {
        List<Address> all = addressRepository.findAll();
        return  all.stream().map(address->mapToDto(address)).collect(Collectors.toList());
    }

   Address mapToEntity(AddressDto addressDto){
        return mapper.map(addressDto,Address.class);
    }

    AddressDto  mapToDto(Address address){
        return mapper.map(address,AddressDto.class);
    }
}
