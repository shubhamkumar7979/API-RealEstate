package com.realstate.service.impl;

import com.realstate.entity.PropertyForRent;
import com.realstate.payload.PropertyForRentDto;
import com.realstate.repository.PropertyForRentRepository;
import com.realstate.service.PropertyForRentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PropertyForRentServiceImpl implements PropertyForRentService {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PropertyForRentRepository rentRepo;
    @Override
    public PropertyForRentDto createPropertyRent(PropertyForRentDto rentDto) {
        PropertyForRent rent = mapToEntity(rentDto);
        PropertyForRent forRent = rentRepo.save(rent);
     return mapToDto(forRent);
    }


    @Override
    public List<PropertyForRentDto> findAllRentProperty() {
        List<PropertyForRent> all = rentRepo.findAll();
       return  all.stream().map(rent->mapToDto(rent)).collect(Collectors.toList());
    }

    PropertyForRent mapToEntity(PropertyForRentDto rentDto){
return mapper.map(rentDto,PropertyForRent.class);
    }

    PropertyForRentDto  mapToDto(PropertyForRent propertyForRent){
        return mapper.map(propertyForRent,PropertyForRentDto.class);
    }
}
