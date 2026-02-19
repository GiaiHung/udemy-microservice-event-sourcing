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
 * @version UpdateAccountCommand.java, v 0.1 2026年02月19日 1:45 PM mark.hungtruong
 */
@Builder
@Data
public class UpdateAccountCommand {

    @TargetAggregateIdentifier
    private final Long accountNumber;
    private final String mobileNumber;
    private final String accountType;
    private final String branchAddress;
    private final boolean activeSw;

}
