package ru.mirea.kachalov.domain.usecases.authorization;

import ru.mirea.kachalov.domain.repository.AccountRepository;

public class LogOutUseCase {
    private final AccountRepository accountRepository;

    public LogOutUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute() {
        accountRepository.logOut();
    }
}