package com.realstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="owners",uniqueConstraints = @UniqueConstraint(columnNames = {"property_id"}))
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    @Column(unique = true)
    private String ownerName;

    private String ownerPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="property_id",unique = true)
    private Property property;
}
