package com.realstate.controller;


import com.realstate.payload.AddressDto;
import com.realstate.payload.PropertyForRentDto;
import com.realstate.service.AddressService;
import com.realstate.service.PropertyForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AddressController {


    //http://localhost:8080/api/address

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto){
        AddressDto address = addressService.createAddress(addressDto);
        return new ResponseEntity<>(address, HttpStatus.CREATED);

    }

    @GetMapping("/address")
    public List<AddressDto> findAllAddresses(){
        List<AddressDto> allAddresses = addressService.findAllAddresses();
        return allAddresses;

    }
}
