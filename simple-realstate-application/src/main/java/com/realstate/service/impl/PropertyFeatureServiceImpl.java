package com.realstate.service.impl;
import com.realstate.entity.*;
import com.realstate.payload.PropertyDto;
import com.realstate.payload.PropertyFeatureDto;
import com.realstate.repository.FeatureRepository;
import com.realstate.repository.PropertyFeatureRepository;
import com.realstate.repository.PropertyRepository;
import com.realstate.service.PropertyFeatureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyFeatureServiceImpl implements PropertyFeatureService {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private FeatureRepository featureRepo;

    @Autowired
    private PropertyFeatureRepository propertyFeatureRepository;
    @Override
    public PropertyFeatureDto createPropertyFeature(PropertyFeatureDto propertyFeatureDto, int propertyId, int featureCode) {

        Property property = propertyRepository.findById(propertyId).get();
        Feature feature = featureRepo.findById(featureCode).get();

        PropertyFeature propertyFeature = mapToEntity(propertyFeatureDto);
        propertyFeature.setProperties(property);
        propertyFeature.setFeatures(feature);


        PropertyFeature propertyFeature1 = propertyFeatureRepository.save(propertyFeature);
        return  mapToDto(propertyFeature1);

    }

    @Override
    public List<PropertyFeatureDto> findAllPropertyFeatures() {

        List<PropertyFeature> all = propertyFeatureRepository.findAll();
        return  all.stream().map(propertyFeature->mapToDto(propertyFeature)).collect(Collectors.toList());


    }


    PropertyFeature mapToEntity(PropertyFeatureDto propertyFeatureDto){
        return mapper.map(propertyFeatureDto,PropertyFeature.class);
    }

    PropertyFeatureDto  mapToDto(PropertyFeature propertyFeature){
        return mapper.map(propertyFeature,PropertyFeatureDto.class);
    }
}
