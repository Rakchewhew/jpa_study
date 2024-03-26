package com.jpastudy.account.repository;

import com.jpastudy.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByLoginId(String loginId);
}
