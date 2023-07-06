package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegDto {
    private int clientId;
    private String clientName;
    private String clientAddress;
    private long phoneNum;
    private String email;
    private String gender;
    private String username;
    private String password;



}
