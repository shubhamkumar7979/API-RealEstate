package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="property_features")
public class PropertyFeature {

    @Id
    private int propertyId;
    private int featureCode;

@OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="property_id_id",unique = true)
    private Property properties;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="feature_code_code",unique = true)
    private Feature features;

}
