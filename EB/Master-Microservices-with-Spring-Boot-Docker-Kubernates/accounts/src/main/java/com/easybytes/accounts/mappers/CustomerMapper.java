package com.easybytes.accounts.mappers;

import com.easybytes.accounts.dtos.CustomerDto;
import com.easybytes.accounts.entities.CustomerEntity;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(CustomerEntity customerEntity, CustomerDto customerDto) {
        customerDto.setName(customerEntity.getName());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setMobileNumber(customerEntity.getMobileNumber());

        return customerDto;
    }

    public static CustomerEntity mapToCustomerEntity(CustomerDto customerDto, CustomerEntity customerEntity) {
        customerEntity.setName(customerDto.getName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setMobileNumber(customerDto.getMobileNumber());

        return customerEntity;
    }

}
