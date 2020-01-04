package com.piotrzalecki.homeserver.bootstrap;

import com.piotrzalecki.homeserver.domain.Account;
import com.piotrzalecki.homeserver.domain.AccountStatus;
import com.piotrzalecki.homeserver.repositories.AccountStatusRepository;
import com.piotrzalecki.homeserver.repositories.AccountsRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class bootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private final AccountsRepository accountsRepository;
    private final AccountStatusRepository accountStatusRepository;

    public bootstrapData(AccountsRepository accountsRepository, AccountStatusRepository accountStatusRepository) {
        this.accountsRepository = accountsRepository;
        this.accountStatusRepository = accountStatusRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Account account1 = new Account(1L, "konto Piotrek");
        Account account2 = new Account(2L, "konto Magda");
        Account account3 = new Account(3L, "karta Kredytowa");
        accountsRepository.save(account1);
        accountsRepository.save(account2);
        accountsRepository.save(account3);

        AccountStatus accountStatus1 = new AccountStatus(1L, account1, 1000.00);
        AccountStatus accountStatus2 = new AccountStatus(2L, account2, 200.00);
        AccountStatus accountStatus3 = new AccountStatus(3L, account3, -40.00);

        accountStatusRepository.save(accountStatus1);
        accountStatusRepository.save(accountStatus2);
        accountStatusRepository.save(accountStatus3);



    }
}
