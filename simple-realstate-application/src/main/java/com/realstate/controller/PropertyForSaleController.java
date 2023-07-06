package com.realstate.controller;


import com.realstate.payload.PropertyForRentDto;
import com.realstate.payload.PropertyForSaleDto;
import com.realstate.service.PropertyForRentService;
import com.realstate.service.PropertyForSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyForSaleController {



    //http://localhost:8080/api/propertyForSale
    @Autowired
    private PropertyForSaleService saleService;

    @PostMapping("/propertyForSale")
    public ResponseEntity<PropertyForSaleDto> createPropertySale(@RequestBody PropertyForSaleDto saleDto){
        PropertyForSaleDto dto = saleService.createPropertySale(saleDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @GetMapping("/propertyForSale")
    public List<PropertyForSaleDto> findALlPropertySale(){
        List<PropertyForSaleDto> property = saleService.findAllSaleProperty();
        return property;

    }
}
