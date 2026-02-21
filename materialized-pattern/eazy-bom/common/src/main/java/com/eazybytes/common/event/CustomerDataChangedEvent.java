/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.common.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version CustomerDataChangedEvent.java, v 0.1 2026年02月21日 7:17 PM mark.hungtruong
 */
@Data
public class CustomerDataChangedEvent {

    private String name;

    private String mobileNumber;

    private boolean activeSw;
}