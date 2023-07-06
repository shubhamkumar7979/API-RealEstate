package com.realstate.service.impl;

import com.realstate.entity.*;
import com.realstate.payload.AddressDto;
import com.realstate.payload.PropertyDto;
import com.realstate.repository.*;
import com.realstate.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PropertyForSaleRepository saleRepo;

    @Autowired
    private PropertyForRentRepository rentRepo;

    @Autowired
    private PropertyRepository propertyRepository;


    @Override

    public PropertyDto createProperty(PropertyDto propertyDto,int addressId,int propertyRentId, int propertySaleId) {
        Address address = addressRepository.findById(addressId).get();
        PropertyForRent propertyForRent = rentRepo.findById(propertyRentId).get();
        PropertyForSale propertyForSale = saleRepo.findById(propertySaleId).get();

        Property property = mapToEntity(propertyDto);
        property.setPropertyDateAdd(new Date());
        property.setAddress(address);
        property.setPropertyForRent(propertyForRent);
        property.setPropertyForSale(propertyForSale);

        Property property1 = propertyRepository.save(property);
      return  mapToDto(property1);

    }

    @Override
    public List<PropertyDto> findAllProperties() {
        List<Property> all = propertyRepository.findAll();
        return  all.stream().map(property->mapToDto(property)).collect(Collectors.toList());
    }


    Property mapToEntity(PropertyDto propertyDto){
        return mapper.map(propertyDto,Property.class);
    }

    PropertyDto  mapToDto(Property property){
        return mapper.map(property,PropertyDto.class);
    }
}
