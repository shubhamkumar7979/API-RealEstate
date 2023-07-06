package com.realstate.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="property_for_sale")
public class PropertyForSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertySaleId;


    @Column(name="suggested_price")
    private int suggestedPrice;


    @Column(name="available")
    private String available;


    @OneToMany(mappedBy = "propertyForSale",cascade=CascadeType.ALL)
    private Set<Property> properties;


;
}
