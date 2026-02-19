/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.query.projection;

import com.eazybytes.accounts.command.event.AccountCreatedEvent;
import com.eazybytes.accounts.command.event.AccountDeletedEvent;
import com.eazybytes.accounts.command.event.AccountUpdatedEvent;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author mark.hungtruong
 * @version AccountProjection.java, v 0.1 2026年02月19日 2:00 PM mark.hungtruong
 */
@Component
@RequiredArgsConstructor
public class AccountProjection {

    private final IAccountsService accountsService;

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        Accounts accounts = new Accounts();
        BeanUtils.copyProperties(accountCreatedEvent, accounts);
        accountsService.createAccount(accounts);
    }

    @EventHandler
    public void on(AccountUpdatedEvent accountUpdatedEvent) {
        accountsService.updateAccount(accountUpdatedEvent);
    }

    @EventHandler
    public void on(AccountDeletedEvent accountDeletedEvent) {
        accountsService.deleteAccount(accountDeletedEvent.getAccountNumber());
    }
}