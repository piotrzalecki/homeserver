package com.piotrzalecki.homeserver.repositories;

import com.piotrzalecki.homeserver.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Account, Long> {
}
