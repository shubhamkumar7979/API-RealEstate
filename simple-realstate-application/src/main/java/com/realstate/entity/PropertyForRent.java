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
@Table(name="property_for_rent",uniqueConstraints = @UniqueConstraint(columnNames={"price"}))
public class PropertyForRent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyRentId;


    @Column(name="price")
    private int price;


    @Column(name="available")
    private String available;

    @OneToMany(mappedBy = "propertyForRent",cascade=CascadeType.ALL)
    private Set<Property> properties;



    @OneToOne(mappedBy = "propertyForRent",cascade = CascadeType.ALL)
    private Rent rent;
}
