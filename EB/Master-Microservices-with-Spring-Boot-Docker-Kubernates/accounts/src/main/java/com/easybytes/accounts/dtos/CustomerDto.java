package com.easybytes.accounts.dtos;

import lombok.Data;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountDto accountDto;
}
