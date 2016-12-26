package ru.sbrf.course.services;

import ru.sbrf.course.domain.Account;

public interface AccountService {
    Iterable<Account> listAllAccounts();

    Account getAccountById(Long accountId);

    Account getAccountByLogin(String login);

    Account getAccountByUserDataId(Long id);

    Account saveAccount(Account account);

    void deleteAccount(Long accountId);
}
