package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.AccountRepository;

public class LogOutUseCase {
    private final AccountRepository accountRepository;

    public LogOutUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute() {
        accountRepository.logOut();
    }
}