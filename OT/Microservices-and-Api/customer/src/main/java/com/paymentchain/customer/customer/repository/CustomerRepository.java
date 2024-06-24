package com.paymentchain.customer.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentchain.customer.customer.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
