package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private int property_id;
    private Date propertyDateAdd;
    private String propertyAddress;
    private int propertyNumOfRooms;
    private int propertyNumOfBedrooms;
    private int propertyNumOfBathrooms;
    private int propertyNumOfGarage;
    private String description;

    private  AddressDto address;
    private PropertyForRentDto propertyForRent;
    private  PropertyForSaleDto propertyForSale;
}
