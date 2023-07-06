package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FeatureDto {

    private int featureCode;

    @NotEmpty(message="description should be atleast 5 characters!")
    private String featureDescription;

}
