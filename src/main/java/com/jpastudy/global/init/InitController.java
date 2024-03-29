package com.jpastudy.global.init;

import com.jpastudy.account.entity.Account;
import com.jpastudy.account.enums.Role;
import com.jpastudy.account.repository.AccountRepository;
import com.jpastudy.account.request.SaveAccountRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
@Profile(value = {"local"})
public class InitController {

    private final InitService initService;

    private static final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @PostConstruct
    public void init(){
        initService.createdAccount();
    }

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    static class InitService {

        private final AccountRepository accountRepository;

        @Transactional
        public void createdAccount(){
            if(accountRepository.count() == 0){
                SaveAccountRequest newAccount = new SaveAccountRequest("최고관리자", "admin", "1234!@#$", Role.ADMIN);
                newAccount.encodePassword(passwordEncoder.encode(newAccount.getPassword()));

                Account account = new Account(newAccount);
                account.activeAccount();

                accountRepository.save(account);
            }
        }
    }
}
