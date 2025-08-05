package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CardsDto;
import com.eazybytes.accounts.service.impl.CardsFallback;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cards", fallback = CardsFallback.class)
public interface CardsFeignClient {
    @GetMapping(value = "/api/cards", consumes = "application/json")
    public ResponseEntity<List<CardsDto>> getAllCards(@RequestParam String mobile);
}
