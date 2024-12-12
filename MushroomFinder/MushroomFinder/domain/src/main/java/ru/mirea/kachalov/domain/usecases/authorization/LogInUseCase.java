package ru.mirea.kachalov.domain.usecases.authorization;

import ru.mirea.kachalov.domain.AuthorizationCallback;
import ru.mirea.kachalov.domain.repository.AccountRepository;

public class LogInUseCase {
    private final AccountRepository accountRepository;

    public LogInUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String email, String password, AuthorizationCallback authCallback) {
        accountRepository.logIn(email, password, authCallback);
    }
}