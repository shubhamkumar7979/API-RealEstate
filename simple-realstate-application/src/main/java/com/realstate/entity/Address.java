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
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "address_street")
    private String addressStreet;


    private int zipcode;


    @Column(name = "country_name")
    private String countryName;


    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    private Set<Property> properties;


}
