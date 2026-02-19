/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.command.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version CustomerUpdatedEvent.java, v 0.1 2026年02月17日 4:33 PM mark.hungtruong
 */
@Data
public class CustomerUpdatedEvent {

    private String customerId;

    private String name;

    private String email;

    private String mobileNumber;

    private boolean activeSw;

}
