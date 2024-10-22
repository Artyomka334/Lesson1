package ru.mirea.kachalov.domain.repository;

import ru.mirea.kachalov.domain.AuthorizationCallback;

public interface AccountRepository {
    void logIn(String email, String password, AuthorizationCallback authCallback);

    void register(String email, String password, AuthorizationCallback authCallback);

    void logOut();

    public boolean hasUserLogged();

    void changeUserInfo(String newInfo);
}