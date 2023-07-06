package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int property_id;


    private Date propertyDateAdd;
    private String propertyAddress;

    private int propertyNumOfRooms;
    private int propertyNumOfBedrooms;
    private int propertyNumOfBathrooms;

    private int propertyNumOfGarage;
    private String description;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="property_rent_id")
    private PropertyForRent propertyForRent;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="property_sale_id")
    private PropertyForSale propertyForSale;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id")
    private Address address;

    @OneToOne(mappedBy = "property",cascade = CascadeType.ALL)
    private Owner owner;

@OneToOne(mappedBy = "properties", cascade=CascadeType.ALL)
    private PropertyFeature propertyFeature;


}
