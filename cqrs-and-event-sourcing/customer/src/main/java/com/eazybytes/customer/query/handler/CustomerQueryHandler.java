/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.query.handler;

import com.eazybytes.customer.dto.CustomerDto;
import com.eazybytes.customer.query.FindCustomerQuery;
import com.eazybytes.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

/**
 * @author mark.hungtruong
 * @version CustomerQueryHandler.java, v 0.1 2026年02月18日 7:59 AM mark.hungtruong
 */
@Component
@RequiredArgsConstructor
public class CustomerQueryHandler {

    private final ICustomerService iCustomerService;

    @QueryHandler
    public CustomerDto findCustomer(FindCustomerQuery findCustomerQuery) {
        return iCustomerService.fetchCustomer(findCustomerQuery.getMobileNumber());
    }
}