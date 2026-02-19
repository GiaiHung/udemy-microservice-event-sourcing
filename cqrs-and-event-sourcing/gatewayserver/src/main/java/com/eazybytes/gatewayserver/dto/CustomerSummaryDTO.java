/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.gatewayserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mark.hungtruong
 * @version CustomerSummaryDTO.java, v 0.1 2026年02月13日 5:00 PM mark.hungtruong
 */
@Data
@AllArgsConstructor
public class CustomerSummaryDTO {

    private CustomerDTO customer;

    private AccountDTO account;

    private LoanDTO loan;

    private CardDTO card;

}