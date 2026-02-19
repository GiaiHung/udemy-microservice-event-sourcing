/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.command.controller;

import com.eazybytes.accounts.command.CreateAccountCommand;
import com.eazybytes.accounts.command.DeleteAccountCommand;
import com.eazybytes.accounts.command.UpdateAccountCommand;
import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.ResponseDto;
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

import java.util.Random;

/**
 * @author mark.hungtruong
 * @version AccountCommandController.java, v 0.1 2026年02月19日 12:58 PM mark.hungtruong
 */
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@RequiredArgsConstructor
public class AccountCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestParam("mobileNumber")
                                                     @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {

        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        CreateAccountCommand createAccountCommand = CreateAccountCommand.builder()
                .accountNumber(randomAccNumber)
                .mobileNumber(mobileNumber)
                .branchAddress(AccountsConstants.ADDRESS)
                .accountType(AccountsConstants.SAVINGS)
                .activeSw(AccountsConstants.ACTIVE_SW)
                .build();

        commandGateway.sendAndWait(createAccountCommand);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody AccountsDto accountsDto) {
        UpdateAccountCommand updateAccountCommand = UpdateAccountCommand.builder()
                .accountNumber(accountsDto.getAccountNumber()).mobileNumber(accountsDto.getMobileNumber())
                .accountType(accountsDto.getAccountType()).branchAddress(accountsDto.getBranchAddress())
                .activeSw(AccountsConstants.ACTIVE_SW)
                .build();

        commandGateway.sendAndWait(updateAccountCommand);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam("accountNumber") Long accountNumber) {
        DeleteAccountCommand deleteCommand = DeleteAccountCommand.builder()
                .accountNumber(accountNumber).activeSw(AccountsConstants.IN_ACTIVE_SW).build();
        commandGateway.sendAndWait(deleteCommand);
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }
}