/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.gatewayserver.handler;

import com.eazybytes.gatewayserver.dto.AccountDTO;
import com.eazybytes.gatewayserver.dto.CardDTO;
import com.eazybytes.gatewayserver.dto.CustomerDTO;
import com.eazybytes.gatewayserver.dto.CustomerSummaryDTO;
import com.eazybytes.gatewayserver.dto.LoanDTO;
import com.eazybytes.gatewayserver.service.client.CustomerSummaryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author mark.hungtruong
 * @version CustomerCompositeHandler.java, v 0.1 2026年02月13日 5:20 PM mark.hungtruong
 */
@Component
@RequiredArgsConstructor
public class CustomerCompositeHandler {

    private final CustomerSummaryClient customerSummaryClient;

    public Mono<ServerResponse> fetchCustomerSummary(ServerRequest serverRequest) {
        String mobileNumber = "";

        if (serverRequest.queryParam("mobileNumber").isPresent()) {
            mobileNumber = serverRequest.queryParam("mobileNumber").get();
        }

        // Non-blocking request
        Mono<ResponseEntity<CustomerDTO>> customerDetail = customerSummaryClient.fetchCustomerDetail(mobileNumber);
        Mono<ResponseEntity<CardDTO>> cardDetail = customerSummaryClient.fetchCardDetail(mobileNumber);
        Mono<ResponseEntity<LoanDTO>> loanDetail = customerSummaryClient.fetchLoanDetail(mobileNumber);
        Mono<ResponseEntity<AccountDTO>> accountDetail = customerSummaryClient.fetchAccountDetail(mobileNumber);

        return Mono.zip(customerDetail, cardDetail, loanDetail, accountDetail)
                .flatMap(tuple -> {
                    CustomerDTO customerDTO = tuple.getT1().getBody();
                    CardDTO cardDTO = tuple.getT2().getBody();
                    LoanDTO loanDTO = tuple.getT3().getBody();
                    AccountDTO accountDTO = tuple.getT4().getBody();

                    CustomerSummaryDTO customerSummaryDTO = new CustomerSummaryDTO(customerDTO, accountDTO, loanDTO, cardDTO);
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(customerSummaryDTO));
                });
    }
}