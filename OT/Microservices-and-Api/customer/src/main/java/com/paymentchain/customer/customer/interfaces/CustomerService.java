package com.paymentchain.customer.customer.interfaces;

import java.util.List;

import com.paymentchain.customer.customer.dto.CreateCustomerDto;
import com.paymentchain.customer.customer.dto.UpdateCustomerDto;
import com.paymentchain.customer.customer.entities.CustomerEntity;

public interface CustomerService {

    CustomerEntity create(CreateCustomerDto createCustomerDto);

    List<CustomerEntity> findAll();

    CustomerEntity findById(Long id);

    CustomerEntity update(Long id, UpdateCustomerDto updateCustomerDto);

    CustomerEntity remove(Long id);
}
