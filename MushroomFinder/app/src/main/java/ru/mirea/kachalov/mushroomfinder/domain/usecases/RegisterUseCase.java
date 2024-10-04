package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.AccountRepository;

public class RegisterUseCase {
    private final AccountRepository accountRepository;

    public RegisterUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean execute(String username, String password) {
        return accountRepository.register(username, password);
    }
}
