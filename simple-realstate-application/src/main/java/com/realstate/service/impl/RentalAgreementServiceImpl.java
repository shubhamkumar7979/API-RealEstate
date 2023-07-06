package com.realstate.service.impl;

import com.realstate.entity.RentalAgreement;
import com.realstate.payload.RentalAgreementDto;
import com.realstate.repository.RentalAgreementRepository;
import com.realstate.service.RentalAgreementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalAgreementServiceImpl implements RentalAgreementService {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;
    @Override
    public RentalAgreementDto createRentalAgreement(RentalAgreementDto rentalAgreementDto) {
        RentalAgreement rentalAgreement = mapToEntity(rentalAgreementDto);
        RentalAgreement rentalAgreement1 = rentalAgreementRepository.save(rentalAgreement);
        return mapToDto(rentalAgreement1);
    }

    @Override
    public List<RentalAgreementDto> findAllRentalAgreements() {
        List<RentalAgreement> all = rentalAgreementRepository.findAll();
        return  all.stream().map(rentalAgreement->mapToDto(rentalAgreement)).collect(Collectors.toList());
    }


    RentalAgreement mapToEntity(RentalAgreementDto rentalAgreementDto){
        return mapper.map(rentalAgreementDto,RentalAgreement.class);
    }

    RentalAgreementDto mapToDto(RentalAgreement rentalAgreement){
        return mapper.map(rentalAgreement,RentalAgreementDto.class);
    }
}
