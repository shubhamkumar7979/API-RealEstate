package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyForSaleDto {
    private int propertySaleId;
    private int suggestedPrice;
    private String available;

}
