package com.paymentchain.customer.customer.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCustomerDto {
    
    @NotBlank()
    public String name; 

    @NotBlank()
    public String phone;
}
