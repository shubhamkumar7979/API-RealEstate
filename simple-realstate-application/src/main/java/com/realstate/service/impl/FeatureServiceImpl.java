package com.realstate.service.impl;

import com.realstate.entity.Address;
import com.realstate.entity.Feature;
import com.realstate.payload.AddressDto;
import com.realstate.payload.FeatureDto;
import com.realstate.repository.AddressRepository;
import com.realstate.repository.FeatureRepository;
import com.realstate.service.FeatureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private FeatureRepository featureRepo;
    @Override
    public FeatureDto createFeature(FeatureDto featureDto) {

        Feature feature = mapToEntity(featureDto);
        Feature feature1 = featureRepo.save(feature);
        return mapToDto(feature1);


    }

    @Override
    public List<FeatureDto> findAllFeatures() {
        List<Feature> all = featureRepo.findAll();
        return  all.stream().map(feature->mapToDto(feature)).collect(Collectors.toList());


    }

  Feature mapToEntity(FeatureDto featureDto){
        return mapper.map(featureDto, Feature.class);
    }

    FeatureDto  mapToDto(Feature feature){
        return mapper.map(feature,FeatureDto.class);
    }
}
