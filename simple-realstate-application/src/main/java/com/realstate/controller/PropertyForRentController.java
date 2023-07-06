package com.realstate.controller;


import com.realstate.entity.PropertyForRent;
import com.realstate.payload.PropertyForRentDto;
import com.realstate.service.PropertyForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyForRentController {

    //http://localhost:8080/api/propertyForRent
    @Autowired
   private PropertyForRentService rentService;

    @PostMapping("/propertyForRent")
    public ResponseEntity<PropertyForRentDto> createPropertyRent(@RequestBody PropertyForRentDto rentDto){
        PropertyForRentDto dto = rentService.createPropertyRent(rentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/propertyForRent")
    public List<PropertyForRentDto> findALlPropertyRent(){
        List<PropertyForRentDto> property = rentService.findAllRentProperty();
        return property;

    }
}
