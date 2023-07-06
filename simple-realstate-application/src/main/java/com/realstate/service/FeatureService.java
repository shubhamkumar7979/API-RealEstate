package com.realstate.service;

import com.realstate.payload.FeatureDto;
import com.realstate.payload.PropertyForSaleDto;

import java.util.List;

public interface FeatureService {

   FeatureDto createFeature(FeatureDto featureDto);
    List<FeatureDto> findAllFeatures();
}
