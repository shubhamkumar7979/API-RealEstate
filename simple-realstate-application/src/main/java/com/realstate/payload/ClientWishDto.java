package com.realstate.payload;

import com.realstate.entity.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientWishDto {
    private int clientId;

    private int featureCode;

private ClientRegDto clientReg;
private FeatureDto feature;
}
