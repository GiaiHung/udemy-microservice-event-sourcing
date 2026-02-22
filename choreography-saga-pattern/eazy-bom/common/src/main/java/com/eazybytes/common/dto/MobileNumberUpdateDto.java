/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.common.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author mark.hungtruong
 * @version MobileNumberUpdateDto.java, v 0.1 2026年02月22日 1:24 PM mark.hungtruong
 */
@Data
public class MobileNumberUpdateDto {

    @NotEmpty(message = "Current mobile number can not be empty")
    @Pattern(regexp = "(^$|[0-9](10))", message = "Mobile number must be 10 digits")
    private String currentMobileNumber;

    @NotEmpty(message = "New mobile number can not be empty")
    @Pattern(regexp = "(^$|[0-9](10))", message = "Mobile number must be 10 digits")
    private String newMobileNumber;
}