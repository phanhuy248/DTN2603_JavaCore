package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.service.IAccountService;
import entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountRepository repository;

    public AccountServiceImpl() {
        repository = new AccountRepositoryImpl();
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = repository.getAllAccounts();
        return accounts;
    }

    @Override
    public List<Account> timKiemAccountTheoId(int id) {
        List<Account> accounts = repository.timKiemAccountTheoId(id);
        return accounts;
    }

    @Override
    public boolean xoaTheoAccountId(int accountId) {
        return repository.xoaTheoAccountId(accountId);
    }

    @Override
    public boolean suaAccountTheoId(int accountId, String userName) {
        return repository.suaAccountTheoId(accountId, userName);
    }

    @Override
    public boolean themAccount(Account account) {
        return repository.themAccount(account);
    }

    @Override
    public boolean checkExist(String email) {
        return repository.checkExist(email);
    }
}
