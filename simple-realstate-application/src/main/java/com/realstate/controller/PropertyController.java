package com.realstate.controller;

import com.realstate.payload.FeatureDto;
import com.realstate.payload.PropertyDto;
import com.realstate.service.FeatureService;
import com.realstate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyController {

//http://localhost:8080/api/address/1/propertyForRent/1/propertyForSale/1/property
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/address/{addressId}/propertyForRent/{propertyRentId}/propertyForSale/{propertySaleId}/property")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto, @PathVariable("addressId") int addressId, @PathVariable("propertyRentId") int propertyRentId, @PathVariable("propertySaleId") int propertySaleId) {
        PropertyDto dto = propertyService.createProperty(propertyDto, addressId, propertyRentId, propertySaleId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/properties")
    public List<PropertyDto> findAllProperties() {
        List<PropertyDto> allProperties = propertyService.findAllProperties();
        return allProperties;

    }
}
