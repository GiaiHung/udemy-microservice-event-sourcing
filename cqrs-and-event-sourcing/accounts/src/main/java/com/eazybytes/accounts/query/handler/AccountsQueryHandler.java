/*
 * Ant Group
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package com.eazybytes.accounts.query.handler;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.query.FindAccountQuery;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

/**
 * @author mark.hungtruong
 * @version AccountsQueryHandler.java, v 0.1 2026年02月19日 2:36 PM mark.hungtruong
 */
@Component
@RequiredArgsConstructor
public class AccountsQueryHandler {

    private final IAccountsService iAccountsService;

    @QueryHandler
    public AccountsDto findAccount(FindAccountQuery query) {
        return iAccountsService.fetchAccount(query.getMobileNumber());
    }

}