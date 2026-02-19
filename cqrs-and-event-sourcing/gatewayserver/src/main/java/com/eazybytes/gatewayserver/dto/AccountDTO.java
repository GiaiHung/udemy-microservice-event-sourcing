/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.gatewayserver.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author mark.hungtruong
 * @version AccountDTO.java, v 0.1 2026年02月13日 4:59 PM mark.hungtruong
 */
@Data
public class AccountDTO {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    private String branchAddress;

    private boolean activeSw;
}