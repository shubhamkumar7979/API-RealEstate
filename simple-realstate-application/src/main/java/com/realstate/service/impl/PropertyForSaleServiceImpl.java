package com.realstate.service.impl;

import com.realstate.entity.PropertyForRent;
import com.realstate.entity.PropertyForSale;
import com.realstate.payload.PropertyForRentDto;
import com.realstate.payload.PropertyForSaleDto;
import com.realstate.repository.PropertyForRentRepository;
import com.realstate.repository.PropertyForSaleRepository;
import com.realstate.service.PropertyForRentService;
import com.realstate.service.PropertyForSaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyForSaleServiceImpl implements PropertyForSaleService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PropertyForSaleRepository saleRepo;
    @Override
    public PropertyForSaleDto createPropertySale(PropertyForSaleDto saleDto) {
        PropertyForSale sale = mapToEntity(saleDto);
        PropertyForSale forSale = saleRepo.save(sale);
        return mapToDto(forSale);
    }

    @Override
    public List<PropertyForSaleDto> findAllSaleProperty() {

        List<PropertyForSale> all = saleRepo.findAll();
        return  all.stream().map(sale->mapToDto(sale)).collect(Collectors.toList());
    }


    PropertyForSale mapToEntity(PropertyForSaleDto saleDto) {
        return mapper.map(saleDto,PropertyForSale.class);
    }

    PropertyForSaleDto mapToDto(PropertyForSale propertyForSale){
        return mapper.map(propertyForSale,PropertyForSaleDto.class);
    }
}
