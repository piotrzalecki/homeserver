package com.piotrzalecki.homeserver.services;

import com.piotrzalecki.homeserver.domain.Account;
import com.piotrzalecki.homeserver.domain.AccountStatus;
import com.piotrzalecki.homeserver.repositories.AccountStatusRepository;
import com.piotrzalecki.homeserver.repositories.AccountsRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BalanceServiceImpl implements BalanceService {

   private final AccountStatusRepository accountStatusRepository;
   private final AccountsRepository accountsRepository;

    public BalanceServiceImpl(AccountStatusRepository accountStatusRepository, AccountsRepository accountsRepository) {

        this.accountStatusRepository = accountStatusRepository;
        this.accountsRepository = accountsRepository;

    }

    @Override
    public Double getTotalBalance() {
        Double balance = 0.0;
        Set<Account> accounts = new HashSet<>();
        accountsRepository.findAll().forEach(accounts::add);
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                balance += accountStatusRepository.findFirstByAccountIdOrderByUpdatedDesc(account.getId()).getBalance();
            }
        }
        return balance;
    }

    @Override
    public Set<AccountStatus> getAllBalances() {
        Set<AccountStatus> accountStatuses = new LinkedHashSet<>();
        accountStatusRepository.findAll().forEach(accountStatuses::add);
        return accountStatuses;
    }

    @Override
    public Set<AccountStatus> getRecentBalances() {
        Set<AccountStatus> accountStatuses = new LinkedHashSet<>();
        Set<Account> accounts = new HashSet<>();
        accountsRepository.findAll().forEach(accounts::add);
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                accountStatuses.add(accountStatusRepository.findFirstByAccountIdOrderByUpdatedDesc(account.getId()));
            }
        }
        return accountStatuses;
    }

    @Override
    public AccountStatus getBalance(Long id) {

        Optional<AccountStatus> accountStatus = accountStatusRepository.findById(id);
        return accountStatus.get();
    }

    @Override
    public boolean updateBalance(Long accountId, Double quote) {
        Optional<AccountStatus> accountStatus = accountStatusRepository.findById(accountId);

        if(accountStatus.isPresent()){
            Account account = accountStatus.get().getAccount();
            AccountStatus newAccountStatus = new AccountStatus(account,quote);
            accountStatusRepository.save(newAccountStatus);
             return true;
        }

        return false;
    }
}
