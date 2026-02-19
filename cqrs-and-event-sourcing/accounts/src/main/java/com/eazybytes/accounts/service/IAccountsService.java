package com.eazybytes.accounts.service;

import com.eazybytes.accounts.command.event.AccountUpdatedEvent;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;

public interface IAccountsService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     */
    void createAccount(Accounts accounts);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    AccountsDto fetchAccount(String mobileNumber);

    /**
     *
     * @param accountsDto - AccountsDto Object
     */
    void updateAccount(AccountUpdatedEvent accountUpdatedEvent);

    /**
     * @param accountNumber - Input Account Number
     */
    void deleteAccount(Long accountNumber);


}
