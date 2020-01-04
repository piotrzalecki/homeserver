package com.piotrzalecki.homeserver.repositories;

import com.piotrzalecki.homeserver.domain.AccountStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AccountStatusRepository extends CrudRepository<AccountStatus, Long> {

    AccountStatus findFirstByAccountIdOrderByUpdatedDesc(Long id);
    Set<AccountStatus> findTopByOrderByUpdatedDesc();
}
