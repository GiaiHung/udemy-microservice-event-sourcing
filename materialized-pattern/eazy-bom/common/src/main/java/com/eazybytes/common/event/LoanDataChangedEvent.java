/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.common.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version LoanDataChangedEvent.java, v 0.1 2026年02月21日 7:18 PM mark.hungtruong
 */
@Data
public class LoanDataChangedEvent {

    private String mobileNumber;

    private Long loanNumber;

}
