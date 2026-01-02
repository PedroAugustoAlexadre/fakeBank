package io.github.fakeBank.api.repository;

import io.github.fakeBank.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    List<Account> findByBranch(String branch);

    Optional<Account> findByAccountCode(String accountCode);

}
