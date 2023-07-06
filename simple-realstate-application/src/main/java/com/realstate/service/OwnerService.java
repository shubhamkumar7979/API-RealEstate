package com.realstate.service;

import com.realstate.payload.FeatureDto;
import com.realstate.payload.OwnerDto;

import java.util.List;

public interface OwnerService {

    OwnerDto createOwner(OwnerDto ownerDto,int propertyId);
    List<OwnerDto> findAllOwners();
}
