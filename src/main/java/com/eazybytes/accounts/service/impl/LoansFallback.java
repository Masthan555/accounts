package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.LoansDto;
import com.eazybytes.accounts.service.LoansFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoansFallback implements LoansFeignClient {

    @Override
    public ResponseEntity<List<LoansDto>> getAllLoans(String mobile) {
        return null;
    }
}
