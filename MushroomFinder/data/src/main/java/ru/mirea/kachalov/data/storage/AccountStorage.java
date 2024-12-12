package ru.mirea.kachalov.data.storage;

import ru.mirea.kachalov.data.storage.models.Account;

public interface AccountStorage {

    public Account getAccount();
    public boolean saveAccount(Account account);

}
