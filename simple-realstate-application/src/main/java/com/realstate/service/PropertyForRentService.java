package com.realstate.service;

import com.realstate.payload.PropertyForRentDto;

import java.util.List;

public interface PropertyForRentService {

    PropertyForRentDto  createPropertyRent(PropertyForRentDto rentDto);
    List< PropertyForRentDto> findAllRentProperty();
}
