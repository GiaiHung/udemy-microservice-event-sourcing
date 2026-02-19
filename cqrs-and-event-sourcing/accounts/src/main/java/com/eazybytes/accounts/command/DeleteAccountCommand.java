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
 * @version DeleteAccountCommand.java, v 0.1 2026年02月19日 1:45 PM mark.hungtruong
 */
@Builder
@Data
public class DeleteAccountCommand {

    @TargetAggregateIdentifier
    private final Long accountNumber;
    private final boolean activeSw;

}