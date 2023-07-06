package com.realstate.controller;


import com.realstate.payload.AddressDto;
import com.realstate.payload.FeatureDto;
import com.realstate.service.AddressService;
import com.realstate.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class FeatureController {

    //http://localhost:8080/api/feature

    @Autowired
    private FeatureService featureService;

    @PostMapping("/feature")
    public ResponseEntity<?> createFeature(@Valid @RequestBody FeatureDto featureDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        FeatureDto dto = featureService.createFeature(featureDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }


    @GetMapping("/feature")
    public List<FeatureDto> findAllFeatures(){
        List<FeatureDto> allFeatures = featureService.findAllFeatures();
        return allFeatures;

    }
}
