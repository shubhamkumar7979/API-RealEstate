package com.realstate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private int ownerId;


    @NotEmpty(message="name is mandatory!")
    @Size(min=5,message="name should be atleast 5 characters!")
    private String ownerName;


    @Pattern(regexp = "\\d{10}", message = "Invalid phone number. It should be a 10-digit number.")
    private String ownerPhone;


}
