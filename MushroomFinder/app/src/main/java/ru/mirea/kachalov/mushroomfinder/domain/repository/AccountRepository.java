package ru.mirea.kachalov.mushroomfinder.domain.repository;

public interface AccountRepository {
    boolean logIn(String username, String password);

    boolean register(String username, String password);

    void logOut();

    void changeUserInfo(String newInfo);

    boolean checkLoginToken(String token);
}