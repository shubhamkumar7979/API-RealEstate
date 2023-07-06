package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int addressId;
    private String addressStreet;
    private int zipcode;
    private String countryName;
    private String cityName;
}
