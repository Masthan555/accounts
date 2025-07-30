package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "loans")
public interface LoansFeignClient {
    @GetMapping(value = "/api/loans", consumes = "application/json")
    public ResponseEntity<List<LoansDto>> getAllLoans(@RequestParam  String mobile);
}
