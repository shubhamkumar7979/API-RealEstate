package com.realstate.controller;


import com.realstate.payload.ClientRegDto;

import com.realstate.service.ClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class clientRegController {

    //http://localhost:8080/api/clientReg

    @Autowired
    private ClientRegService clientRegService;

    @PostMapping("/clientReg")
    public ResponseEntity<ClientRegDto> createAddress(@RequestBody ClientRegDto clientRegDto){
        ClientRegDto dto = clientRegService.createClientReg(clientRegDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/clientReg")
    public List<ClientRegDto> findAllClientReg(){
        List<ClientRegDto> list = clientRegService.findAllClientReg();
        return list;

    }

}
