package com.realstate.controller;

import com.realstate.payload.OwnerDto;
import com.realstate.payload.PropertyDto;
import com.realstate.service.OwnerService;
import com.realstate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class OwnerController {

    //http://localhost:8080/api/property/{propertyId}/owners
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/property/{propertyId}/owners")
    public ResponseEntity<?> createOwner(@Valid  @RequestBody OwnerDto ownerDto, BindingResult bindingResult, @PathVariable("propertyId") int propertyId) {

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        OwnerDto owner = ownerService.createOwner(ownerDto, propertyId);
        return new ResponseEntity<>(owner, HttpStatus.CREATED);

    }

    @GetMapping("/owners")
    public List<OwnerDto> findAllOwners() {
        List<OwnerDto> allOwners = ownerService.findAllOwners();
        return allOwners;

    }
}
