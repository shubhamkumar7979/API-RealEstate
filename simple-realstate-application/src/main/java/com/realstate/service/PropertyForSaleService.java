package com.realstate.service;

import com.realstate.payload.PropertyForRentDto;
import com.realstate.payload.PropertyForSaleDto;

import java.util.List;

public interface PropertyForSaleService {

    PropertyForSaleDto createPropertySale(PropertyForSaleDto saleDto);
    List< PropertyForSaleDto> findAllSaleProperty();
}
