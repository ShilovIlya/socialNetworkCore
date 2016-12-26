package ru.sbrf.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.domain.Account;
import ru.sbrf.course.repositories.AccountRepository;

import java.util.Iterator;

@Service
public class AccountServiceImpl implements AccountService {

        private AccountRepository accountRepository;

        @Autowired
        public void setAccountRepository(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }

        @Override
        public Iterable<Account> listAllAccounts() {
            return accountRepository.findAll();
        }

        @Override
        public Account getAccountById(Long accountId) {
            return accountRepository.findOne(accountId);
        }

        @Override
        public Account getAccountByLogin(String login) {
                Iterator iter = listAllAccounts().iterator();
                Account account;
                while (iter.hasNext()) {
                        account = (Account) iter.next();
                        if (account.getLogin().equals(login))
                                return account;
                }
                return null;
        }

        @Override
        public Account getAccountByUserDataId(Long id) {
                Iterator iter = listAllAccounts().iterator();
                Account account;
                while (iter.hasNext()) {
                        account = (Account) iter.next();
                        if (account.getUserDataId().equals(id))
                                return account;
                }
                return null;
        }

        @Override
        public Account saveAccount(Account account) {
            return accountRepository.save(account);
        }

        @Override
        public void deleteAccount(Long accountId) {
        accountRepository.delete(accountId);
        }
}
