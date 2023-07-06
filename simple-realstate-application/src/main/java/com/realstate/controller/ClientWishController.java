package com.realstate.controller;


import com.realstate.payload.ClientWishDto;

import com.realstate.service.ClientWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ClientWishController {


    //http://localhost:8080/api/clientReg/{clientId}/feature/{featureCode}/clientWish

    @Autowired
    private ClientWishService clientWishService;
//http://localhost:8080/api/clientReg/1/feature/110/clientWish
    @PostMapping("/clientReg/{clientId}/feature/{featureCode}/clientWish")
    public ResponseEntity<ClientWishDto> createClientWish(@RequestBody ClientWishDto clientWishDto,@PathVariable("clientId") int clientId, @PathVariable("featureCode") int featureCode){
        ClientWishDto dto = clientWishService.createClientWish(clientWishDto,clientId,featureCode);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/clientWish")
    public List<ClientWishDto> findAllClientWishes(){
        List<ClientWishDto> wish = clientWishService.findAllClientWish();
        return wish;

    }
}
