/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.common.event;

import lombok.Data;

/**
 * @author mark.hungtruong
 * @version CardDataChangedEvent.java, v 0.1 2026年02月21日 7:19 PM mark.hungtruong
 */
@Data
public class CardDataChangedEvent {

    private String mobileNumber;

    private Long cardNumber;

}
