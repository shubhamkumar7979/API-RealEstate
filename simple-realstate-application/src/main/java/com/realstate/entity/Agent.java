package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agenetId;

    private String office;
    private String agentName;
    private long phoneNum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rent_client_id",unique = false)
    private Rent rent;

}
