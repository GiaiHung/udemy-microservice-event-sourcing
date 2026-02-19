/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.customer.command.controller;

import com.eazybytes.customer.command.CreateCustomerCommand;
import com.eazybytes.customer.command.DeleteCustomerCommand;
import com.eazybytes.customer.command.UpdateCustomerCommand;
import com.eazybytes.customer.constants.CustomerConstants;
import com.eazybytes.customer.dto.CustomerDto;
import com.eazybytes.customer.dto.ResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author mark.hungtruong
 * @version CustomerCommandController.java, v 0.1 2026年02月17日 4:34 PM mark.hungtruong
 */
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@RequiredArgsConstructor
public class CustomerCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {

        CreateCustomerCommand command = CreateCustomerCommand.builder()
                .customerId(UUID.randomUUID().toString())
                .email(customerDto.getEmail())
                .name(customerDto.getName())
                .mobileNumber(customerDto.getMobileNumber())
                .activeSw(CustomerConstants.ACTIVE_SW)
                .build();

        commandGateway.sendAndWait(command);

        return ResponseEntity
                .status(org.springframework.http.HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_201, CustomerConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomerDetails(@Valid @RequestBody CustomerDto customerDto) {
        UpdateCustomerCommand updateCustomerCommand = UpdateCustomerCommand.builder()
                .customerId(customerDto.getCustomerId()).email(customerDto.getEmail())
                .name(customerDto.getName()).mobileNumber(customerDto.getMobileNumber())
                .activeSw(CustomerConstants.ACTIVE_SW).build();
        commandGateway.sendAndWait(updateCustomerCommand);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam("customerId")
                                                      @Pattern(regexp = "(^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$)",
                                                              message = "CustomerId is invalid") String customerId) {
        DeleteCustomerCommand deleteCustomerCommand = DeleteCustomerCommand.builder()
                .customerId(customerId).activeSw(CustomerConstants.IN_ACTIVE_SW).build();
        commandGateway.sendAndWait(deleteCustomerCommand);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }

}