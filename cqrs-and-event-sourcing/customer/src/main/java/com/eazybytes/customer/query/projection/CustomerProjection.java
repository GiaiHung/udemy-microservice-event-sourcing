/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.query.projection;

import com.eazybytes.customer.command.event.CustomerCreatedEvent;
import com.eazybytes.customer.command.event.CustomerDeletedEvent;
import com.eazybytes.customer.command.event.CustomerUpdatedEvent;
import com.eazybytes.customer.entity.Customer;
import com.eazybytes.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author mark.hungtruong
 * @version CustomerProjection.java, v 0.1 2026年02月17日 10:09 PM mark.hungtruong
 */
@Component
@RequiredArgsConstructor
// This will make the event publish and event handler all handled in the same thread
// (only works if write and read side only run in the same JVM)
@ProcessingGroup("customer-group")
public class CustomerProjection {

    private final ICustomerService customerService;

    @EventHandler
    public void on(CustomerCreatedEvent customerCreatedEvent) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerCreatedEvent, customer);
        customerService.createCustomer(customer);
    }

    @EventHandler
    public void on(CustomerUpdatedEvent customerUpdatedEvent) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerUpdatedEvent, customer);
        customerService.updateCustomer(customer);
        // throw new RuntimeException("Can't create new user");
    }

    @EventHandler
    public void on(CustomerDeletedEvent customerDeletedEvent) {
        customerService.deleteCustomer(customerDeletedEvent.getCustomerId());
    }
}