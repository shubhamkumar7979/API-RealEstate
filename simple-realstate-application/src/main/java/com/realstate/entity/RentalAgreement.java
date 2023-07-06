package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="rental_agreements")
public class RentalAgreement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalAgreementId;
    private String rentalAgreementContent;


    @OneToOne(mappedBy = "rentalAgreement",cascade = CascadeType.ALL)
    private Rent rent;
}
