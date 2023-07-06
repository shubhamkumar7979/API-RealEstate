package com.realstate.controller;

import com.realstate.payload.AddressDto;
import com.realstate.payload.RentalAgreementDto;
import com.realstate.service.AddressService;
import com.realstate.service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RentalAgreementController {



    //http://localhost:8080/api/rentalAgreementService

    @Autowired
    private RentalAgreementService rentalAgreementService;

    @PostMapping("/rentalAgreementService")
    public ResponseEntity<RentalAgreementDto> createRentalAgreement(@RequestBody RentalAgreementDto rentalAgreementDto){
        RentalAgreementDto dto = rentalAgreementService.createRentalAgreement(rentalAgreementDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/rentalAgreementService")
    public List<RentalAgreementDto> findAllrentalAgreementServices(){
        List<RentalAgreementDto> allRentalAgreements = rentalAgreementService.findAllRentalAgreements();
        return allRentalAgreements;

    }

}
