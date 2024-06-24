package com.easybytes.accounts.services;

import com.easybytes.accounts.dtos.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
    
    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
}
