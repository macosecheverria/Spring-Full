package com.paymentchain.customer.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentchain.customer.customer.dto.CreateCustomerDto;
import com.paymentchain.customer.customer.dto.UpdateCustomerDto;
import com.paymentchain.customer.customer.entities.CustomerEntity;
import com.paymentchain.customer.customer.interfaces.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/consumers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> create(@RequestBody CreateCustomerDto createCustomerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.customerService.create(createCustomerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> findAll() {
        return ResponseEntity.ok(this.customerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.findById(id));
    }

    @PatchMapping("{id}")
    public ResponseEntity<CustomerEntity> update(@PathVariable Long id,
            @Valid @RequestBody UpdateCustomerDto updateCustomerDto) {
        return ResponseEntity.ok(this.customerService.update(id, updateCustomerDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CustomerEntity> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.remove(id));
    }

}
