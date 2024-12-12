package ru.mirea.kachalov.domain.usecases.authorization;

import ru.mirea.kachalov.domain.repository.AccountRepository;

public class HasUserLoggedUseCase {

    private AccountRepository accountRepository;

    public HasUserLoggedUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean execute() {
        return accountRepository.hasUserLogged();
    }

}
