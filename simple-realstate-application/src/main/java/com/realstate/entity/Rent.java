package com.realstate.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="rents")
public class Rent {
    @Id
    private int clientId;
    @Column(unique = true)
    private int agentId;
    @Column(unique = true)
    private int propertyId;
    @Column(unique = true)
    private int rentalAgreementId;
    private String rentStartDate;
    private String rentEndDate;
    private int rentPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_reg_id")
    private ClientReg clientReg;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="property_for_rent_id_id")
    private PropertyForRent propertyForRent;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rental_Agreement_id_id")
    private RentalAgreement rentalAgreement;

    @OneToOne(mappedBy = "rent",cascade = CascadeType.ALL)
    private Agent agent;

}
