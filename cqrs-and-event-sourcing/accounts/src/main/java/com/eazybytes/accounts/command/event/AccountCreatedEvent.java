/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.command.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version AccountCreatedEvent.java, v 0.1 2026年02月19日 1:40 PM mark.hungtruong
 */
@Data
public class AccountCreatedEvent {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;

    private String mobileNumber;

    private boolean activeSw;
}