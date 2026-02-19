/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author mark.hungtruong
 * @version CreateCustomerCommand.java, v 0.1 2026年02月17日 4:21 PM mark.hungtruong
 */
@Data
@Builder
public class CreateCustomerCommand {

    @TargetAggregateIdentifier
    private final String customerId;
    private final String name;
    private final String email;
    private final String mobileNumber;
    private final boolean activeSw;

}