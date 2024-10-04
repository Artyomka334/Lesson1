package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.AccountRepository;

public class ChangeUserInfoUseCase {
    private final AccountRepository accountRepository;

    public ChangeUserInfoUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String newInfo) {
        accountRepository.changeUserInfo(newInfo);
    }
}