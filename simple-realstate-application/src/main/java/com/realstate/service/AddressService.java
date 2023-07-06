package com.realstate.service;

import com.realstate.payload.AddressDto;
import com.realstate.payload.PropertyForRentDto;

import java.util.List;

public interface AddressService {

    AddressDto createAddress(AddressDto addressDto);
    List<AddressDto> findAllAddresses();
}
