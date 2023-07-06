package com.realstate.service;

import com.realstate.payload.AddressDto;
import com.realstate.payload.PropertyDto;

import java.util.List;

public interface PropertyService {

    PropertyDto createProperty(PropertyDto propertyDto,int addressId,int propertyRentId, int propertySaleId);
    List<PropertyDto> findAllProperties();
}
