package backend.service;

import entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();

    List<Account> timKiemAccountTheoId(int accountId);

    boolean xoaTheoAccountId(int accountId);

    boolean suaAccountTheoId(int accountId, String userName);

    boolean themAccount(Account account);

}
