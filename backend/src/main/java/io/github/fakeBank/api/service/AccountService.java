package io.github.fakeBank.api.service;

import io.github.fakeBank.api.model.Account;
import io.github.fakeBank.api.model.User;
import io.github.fakeBank.api.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {

    private  final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(User user) {

        Account account = new Account();


        account.setBranch("001");

        account.setAccountCode(generateAccountCode());

        account.setBalance(BigDecimal.ZERO);

        account.setUser(user);

        return accountRepository.save(account);
    }

    private String generateAccountCode() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);
    }

}
