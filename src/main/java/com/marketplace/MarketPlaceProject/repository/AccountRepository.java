package com.marketplace.MarketPlaceProject.repository;

import com.marketplace.MarketPlaceProject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByEmail(String email);

    public void deleteByEmail(String email);
}
