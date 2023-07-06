package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="client_reg")
public class ClientReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private int clientId;

    @Column(unique = true)
    private String clientName;
    private String clientAddress;

    @Column(unique = true)
    private long phoneNum;
    @Column(unique = true)
    private String email;
    private String gender;
    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne(mappedBy = "clientReg",cascade = CascadeType.ALL)
    private ClientWish clientWish;
    @OneToOne(mappedBy = "clientReg",cascade = CascadeType.ALL)
    private Rent rent;



}
