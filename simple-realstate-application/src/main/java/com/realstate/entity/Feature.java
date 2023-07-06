package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="features")
public class Feature {

    @Id
    @Column(name="feature_code")
    private int featureCode;

    @Column(name = "feature_description")
    private String featureDescription;

    @OneToOne(mappedBy = "feature",cascade = CascadeType.ALL)
    private ClientWish clientWish;

    @OneToOne(mappedBy = "features", cascade=CascadeType.ALL)
    private PropertyFeature propertyFeature;
}
