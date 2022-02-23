package com.marketplace.MarketPlaceProject.service;

import com.marketplace.MarketPlaceProject.entity.Account;

public interface AccountService {
    public Account saveAccount(Account account);

    public Account fetchAccountByEmail(String email);

    public void deleteAccount(String email);

    public Account updateAccount(Long accountId, Account account);
}
