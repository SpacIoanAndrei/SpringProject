package com.marketplace.MarketPlaceProject.service;

import com.marketplace.MarketPlaceProject.entity.Account;
import com.marketplace.MarketPlaceProject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account fetchAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public void deleteAccount(String email) {
        accountRepository.deleteByEmail(email);
    }

    @Override
    public Account updateAccount(Long accountId, Account account) {
        Account accountFromDb = accountRepository.getById(accountId);
        if (Objects.nonNull(account.getEmail()) && !"".equals(account.getEmail())){
            accountFromDb.setEmail(account.getEmail());
        }
        if (Objects.nonNull(account.getPassword()) && !"".equals(account.getPassword())){
            accountFromDb.setPassword(account.getPassword());
        }
        if (Objects.nonNull(account.getFavorites()) && !"".equals(account.getFavorites())){
            accountFromDb.setFavorites(account.getFavorites());
        }
        if (Objects.nonNull(account.getPostedAdds()) && !"".equals(account.getPostedAdds())){
            accountFromDb.setPostedAdds(account.getPostedAdds());
        }
        return accountRepository.save(accountFromDb);
    }


}
