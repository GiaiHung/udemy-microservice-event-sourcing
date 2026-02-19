/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author mark.hungtruong
 * @version CreateAccountCommand.java, v 0.1 2026年02月19日 12:59 PM mark.hungtruong
 */
@Data
@Builder
public class CreateAccountCommand {

    @TargetAggregateIdentifier
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private String mobileNumber;
    private boolean activeSw;
}