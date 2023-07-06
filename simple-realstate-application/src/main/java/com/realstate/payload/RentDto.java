package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private int clientId;
    private int agentId;
    private int propertyId;
    private int rentalAgreementId;
    private String rentStartDate;
    private String rentEndDate;
    private int rentPrice;



}
