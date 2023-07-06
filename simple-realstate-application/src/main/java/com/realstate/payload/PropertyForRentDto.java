package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyForRentDto {

    private int propertyRentId;
    private int price;
    private String available;


}
