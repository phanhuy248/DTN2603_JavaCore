package backend.controller;

import backend.service.IAccountService;
import backend.service.impl.AccountServiceImpl;
import entity.Account;

import java.util.List;

public class AccountController {
    private IAccountService IAccountService;

    public AccountController() {
        this.IAccountService = new AccountServiceImpl() {
        };
    }

    public List<Account> getAllAccounts() {
        return this.IAccountService.getAllAccounts();
    }

    public List<Account> timKiemAccountTheoId(int accountId) {
        return this.IAccountService.timKiemAccountTheoId(accountId);
    }

    public boolean xoaTheoAccountId(int accountId) {
        return this.IAccountService.xoaTheoAccountId(accountId);
    }

    public boolean suaAccountTheoId(int id, String userName) {
        return this.IAccountService.suaAccountTheoId(id, userName);
    }

    public boolean themAccount(Account account) {
        return this.IAccountService.themAccount(account);
    }
}