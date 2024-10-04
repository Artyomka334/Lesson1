package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.AccountRepository;

public class LogInUseCase {
    private final AccountRepository accountRepository;

    public LogInUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean execute(String username, String password) {
        return accountRepository.logIn(username, password);
    }
}