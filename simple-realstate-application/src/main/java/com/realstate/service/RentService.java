package com.realstate.service;

import com.realstate.payload.RentDto;
import com.realstate.payload.RentalAgreementDto;

import java.util.List;

public interface RentService {

    RentDto createRent(RentDto rentDto,int clientId, int propertyRentId,int rentalAgreementId);
    List<RentDto> findAllRents();
}
