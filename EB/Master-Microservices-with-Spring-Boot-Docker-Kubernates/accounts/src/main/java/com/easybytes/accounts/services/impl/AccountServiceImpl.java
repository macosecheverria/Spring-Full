package com.easybytes.accounts.services.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.easybytes.accounts.constants.AccountsConstants;
import com.easybytes.accounts.dtos.AccountDto;
import com.easybytes.accounts.dtos.CustomerDto;
import com.easybytes.accounts.entities.AccountEntity;
import com.easybytes.accounts.entities.CustomerEntity;
import com.easybytes.accounts.exceptions.CustomerAlreadyExistException;
import com.easybytes.accounts.exceptions.ResourceNotFoundException;
import com.easybytes.accounts.mappers.AccountMapper;
import com.easybytes.accounts.mappers.CustomerMapper;
import com.easybytes.accounts.repositories.AccountRepository;
import com.easybytes.accounts.repositories.CustomerRepository;
import com.easybytes.accounts.services.IAccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        CustomerEntity customer = CustomerMapper.mapToCustomerEntity(customerDto, new CustomerEntity());
        Optional<CustomerEntity> optionalCustomer = this.customerRepository
                .findByMobileNumber(customer.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException(
                    "Customer already registered with given mobile number" + customerDto.getMobileNumber());
        }

        CustomerEntity savedCustomer = this.customerRepository.save(customer);
        this.accountRepository.save(this.createNewAccount(savedCustomer));
    }

    private AccountEntity createNewAccount(CustomerEntity customerEntity) {
        AccountEntity newAccount = new AccountEntity();
        newAccount.setCustomertId(customerEntity.getCustomerId());

        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);

        return newAccount;

    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        CustomerEntity customer = this.customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        AccountEntity account = this.accountRepository.findByCustomertId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId",
                        customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccountDto();

        if (accountDto != null) {
            AccountEntity accounts = this.accountRepository.findById(
                    accountDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
                            accountDto.getAccountNumber().toString()));

            AccountMapper.mapToAccountEntity(accountDto, accounts);
            accounts = this.accountRepository.save(accounts);
            

            Long customerId = accounts.getCustomertId();
            CustomerEntity customer = this.customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));

            CustomerMapper.mapToCustomerEntity(customerDto, customer);
            this.customerRepository.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

}
