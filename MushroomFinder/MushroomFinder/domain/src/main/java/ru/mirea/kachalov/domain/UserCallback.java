package ru.mirea.kachalov.domain;

import ru.mirea.kachalov.domain.models.Account;

public interface UserCallback {

    void onSuccess(Account account);
    void onFailure();

}
