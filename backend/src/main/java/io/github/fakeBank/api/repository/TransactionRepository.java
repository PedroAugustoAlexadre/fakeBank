package io.github.fakeBank.api.repository;

import io.github.fakeBank.api.model.Account;
import io.github.fakeBank.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findBySender(Account sender);
    List<Transaction> findByReceiver(Account receiver);
}
