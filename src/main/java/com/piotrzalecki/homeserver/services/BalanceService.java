package com.piotrzalecki.homeserver.services;

import com.piotrzalecki.homeserver.domain.AccountStatus;

import java.util.Map;
import java.util.Set;

public interface BalanceService {

    Double getTotalBalance();
    Set<AccountStatus> getRecentBalances();
    Set<AccountStatus> getAllBalances();
    AccountStatus getBalance(Long id);
    boolean updateBalance (Long accountStatusId, Double quote);

}
