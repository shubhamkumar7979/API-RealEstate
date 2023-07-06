package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity

@Table(name="client_wish",uniqueConstraints =@UniqueConstraint(columnNames = {"feature_code"}))

public class ClientWish{

    @Id
   @Column(name = "client_id")
    private int clientId;


    @Column(name="feature_code",unique = true)
    private int featureCode;


@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name="client_reg_id", unique = true)
    private ClientReg clientReg;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="feature_code_id", unique = true)
    private Feature feature;


}
