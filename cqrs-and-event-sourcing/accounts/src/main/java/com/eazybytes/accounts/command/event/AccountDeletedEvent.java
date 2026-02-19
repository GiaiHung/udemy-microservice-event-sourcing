/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.command.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version AccountDeletedEvent.java, v 0.1 2026年02月19日 1:46 PM mark.hungtruong
 */
@Data
public class AccountDeletedEvent {

    private Long accountNumber;
    private boolean activeSw;

}