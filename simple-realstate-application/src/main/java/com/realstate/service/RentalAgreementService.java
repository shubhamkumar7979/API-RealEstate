package com.realstate.service;

import com.realstate.payload.PropertyDto;
import com.realstate.payload.RentalAgreementDto;

import java.util.List;

public interface RentalAgreementService {

    RentalAgreementDto createRentalAgreement(RentalAgreementDto rentalAgreementDto);
    List<RentalAgreementDto> findAllRentalAgreements();
}
