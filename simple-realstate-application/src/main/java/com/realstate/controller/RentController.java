package com.realstate.controller;

import com.realstate.payload.PropertyDto;
import com.realstate.payload.RentDto;
import com.realstate.service.PropertyService;
import com.realstate.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RentController {

    //http://localhost:8080/api/clientReg/{clientId}/propertyForRent/{propertyRentId}/rentalAgreement/{rentalAgreementId}/rent
    @Autowired
    private RentService rentService;



    @PostMapping("/clientReg/{clientId}/propertyForRent/{propertyRentId}/rentalAgreement/{rentalAgreementId}/rent")
    public ResponseEntity<RentDto> createProperty(@RequestBody RentDto rentDto, @PathVariable("clientId") int clientId, @PathVariable("propertyRentId") int propertyRentId, @PathVariable("rentalAgreementId") int rentalAgreementId) {
        RentDto dto = rentService.createRent(rentDto, clientId, propertyRentId, rentalAgreementId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/rents")
    public List<RentDto> findAllRents() {
        List<RentDto> allRents = rentService.findAllRents();
        return allRents;

    }
}
