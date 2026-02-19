/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.command.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version CustomerDeletedEvent.java, v 0.1 2026年02月17日 4:34 PM mark.hungtruong
 */
@Data
public class CustomerDeletedEvent {

    private String customerId;

    private boolean activeSw;

}