package com.marketplace.MarketPlaceProject.Controller;

import com.marketplace.MarketPlaceProject.entity.Account;
import com.marketplace.MarketPlaceProject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public Account saveAccount (@Valid @RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @GetMapping("/account/email/{email}")
    public Account fetchAccountByEmail(@PathVariable("id") String email){
        return accountService.fetchAccountByEmail(email);
    }

    @DeleteMapping("/account/email/{email}")
    public String deleteAccount(@PathVariable("email") String email){
        accountService.deleteAccount(email);
        return "Account deleted succesfully!";
    }
    @PutMapping("/account/id/{id}")
    public Account updateAccount (@PathVariable("id") Long accountId, @RequestBody Account account){
        return accountService.updateAccount(accountId, account);

    }
}
