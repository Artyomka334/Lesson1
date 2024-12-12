package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.repository.AccountRepository;

public class GetUserIdUseCase {

    private AccountRepository accountRepository;

    public GetUserIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String execute() {
        return accountRepository.getUserId();
    }

}
