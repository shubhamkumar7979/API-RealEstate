package com.realstate.service;
import com.realstate.payload.PropertyFeatureDto;

import java.util.List;

public interface PropertyFeatureService {

    PropertyFeatureDto createPropertyFeature(PropertyFeatureDto propertyFeatureDto, int propertyId, int featureCode);
    List<PropertyFeatureDto> findAllPropertyFeatures();
}
