package com.paymentchain.customer.customer;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paymentchain.customer.customer.dto.CreateCustomerDto;
import com.paymentchain.customer.customer.dto.UpdateCustomerDto;
import com.paymentchain.customer.customer.entities.CustomerEntity;
import com.paymentchain.customer.customer.exceptions.NotFoundException;
import com.paymentchain.customer.customer.interfaces.CustomerService;
import com.paymentchain.customer.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public CustomerEntity create(CreateCustomerDto createCustomerDto) {

        CustomerEntity customer = CustomerEntity.builder()
                .name(createCustomerDto.name)
                .phone(createCustomerDto.phone)
                .build();

        this.customerRepository.save(customer);

        return customer;
    }

    @Override
    public List<CustomerEntity> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public CustomerEntity findById(Long id) {
        CustomerEntity customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with id" + id + " not found"));

        return customer;
    }

    @Override
    public CustomerEntity update(Long id, UpdateCustomerDto updateCustomerDto) {
        CustomerEntity customer = this.findById(id);

        customer.setName(updateCustomerDto.name);
        customer.setPhone(updateCustomerDto.phone);

        this.customerRepository.save(customer);

        return customer;
    }

    @Override
    public CustomerEntity remove(Long id) {
        CustomerEntity customer = this.findById(id);

        this.customerRepository.delete(customer);

        return customer;
    }

}
