package com.realstate.service.impl;

import com.realstate.entity.*;

import com.realstate.payload.RentDto;
import com.realstate.repository.ClientRegRepository;
import com.realstate.repository.PropertyForRentRepository;
import com.realstate.repository.RentRepository;
import com.realstate.repository.RentalAgreementRepository;
import com.realstate.service.RentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;

    @Autowired
    private PropertyForRentRepository rentRepo;

    @Autowired
    private ClientRegRepository clientRegRepository;

    @Autowired
    private RentRepository rentRepository;
    @Override
    public RentDto createRent(RentDto rentDto, int clientId, int propertyRentId, int rentalAgreementId) {
        ClientReg clientReg = clientRegRepository.findById(clientId).get();
        PropertyForRent propertyForRent = rentRepo.findById(propertyRentId).get();
        RentalAgreement rentalAgreement = rentalAgreementRepository.findById(rentalAgreementId).get();

        Rent rent = mapToEntity(rentDto);

       rent.setClientReg(clientReg);

        rent.setPropertyForRent(propertyForRent);
        rent.setRentalAgreement(rentalAgreement);
        Rent rent1 = rentRepository.save(rent);
        return  mapToDto(rent1);

    }

    @Override
    public List<RentDto> findAllRents() {

        List<Rent> all = rentRepository.findAll();
        return  all.stream().map(rent->mapToDto(rent)).collect(Collectors.toList());


    }

    Rent mapToEntity(RentDto rentDto){
        return mapper.map(rentDto, Rent.class);
    }

    RentDto mapToDto(Rent rent){
        return mapper.map(rent,RentDto.class);
    }
}
