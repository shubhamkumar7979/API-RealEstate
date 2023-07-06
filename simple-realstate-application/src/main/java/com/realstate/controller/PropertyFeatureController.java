package com.realstate.controller;

import com.realstate.payload.OwnerDto;
import com.realstate.payload.PropertyFeatureDto;
import com.realstate.service.OwnerService;
import com.realstate.service.PropertyFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyFeatureController {


    //http://localhost:8080/api/property/{propertyId}/feature/{featureCode}/propertyFeature
    @Autowired
    private PropertyFeatureService propertyFeatureService;

    @PostMapping("/property/{propertyId}/feature/{featureCode}/propertyFeature")
    public ResponseEntity<PropertyFeatureDto> createPropertyFeature(@RequestBody PropertyFeatureDto propertyFeatureDto, @PathVariable("propertyId") int propertyId,  @PathVariable("featureCode") int featureCode) {
        PropertyFeatureDto dto = propertyFeatureService.createPropertyFeature(propertyFeatureDto, propertyId, featureCode);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/propertyFeatures")
    public List<PropertyFeatureDto> findAllPropertyFeatures() {
        List<PropertyFeatureDto> list = propertyFeatureService.findAllPropertyFeatures();
        return list;

    }


}
