package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.*;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.CardsFeignClient;
import com.eazybytes.accounts.service.ICustomerService;
import com.eazybytes.accounts.service.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto getCustomerDetails(String mobile) {
        Customer customer = customerRepository.findByMobile(mobile).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobile", mobile));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<List<LoansDto>> loans = loansFeignClient.getAllLoans(mobile);
        ResponseEntity<List<CardsDto>> cards = cardsFeignClient.getAllCards(mobile);

        if(null != loans) {
            customerDetailsDto.setLoansDto(loans.getBody());
        }
        if(null != cards) {
            customerDetailsDto.setCardsDto(cards.getBody());
        }
        return customerDetailsDto;
    }
}
