/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.gatewayserver.service.client;

import com.eazybytes.gatewayserver.dto.AccountDTO;
import com.eazybytes.gatewayserver.dto.CardDTO;
import com.eazybytes.gatewayserver.dto.CustomerDTO;
import com.eazybytes.gatewayserver.dto.LoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * @author mark.hungtruong
 * @version CustomerSummaryClient.java, v 0.1 2026年02月13日 5:02 PM mark.hungtruong
 */
public interface CustomerSummaryClient {

    @GetExchange(value = "/eazybank/customer/api/fetch", accept = "application/json")
    Mono<ResponseEntity<CustomerDTO>> fetchCustomerDetail(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value= "/eazybank/accounts/api/fetch", accept = "application/json")
    Mono<ResponseEntity<AccountDTO>> fetchAccountDetail(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value= "/eazybank/loans/api/fetch", accept = "application/json")
    Mono<ResponseEntity<LoanDTO>> fetchLoanDetail(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value= "/eazybank/cards/api/fetch", accept = "application/json")
    Mono<ResponseEntity<CardDTO>> fetchCardDetail(@RequestParam("mobileNumber") String mobileNumber);
}