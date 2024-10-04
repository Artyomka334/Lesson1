package ru.mirea.kachalov.mushroomfinder.data.repository;

import ru.mirea.kachalov.mushroomfinder.domain.repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public boolean logIn(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }

    @Override
    public boolean register(String username, String password) {
        return true;
    }

    @Override
    public boolean checkLoginToken(String token) {
        return "valid_token".equals(token);
    }

    @Override
    public void logOut() {
    }

    @Override
    public void changeUserInfo(String newInfo) {
    }
}
