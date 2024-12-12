package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.UserCallback;
import ru.mirea.kachalov.domain.repository.AccountRepository;

public class GetUserInfoUseCase {

    private AccountRepository accountRepository;

    public GetUserInfoUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String userId, UserCallback userCallback) {
        accountRepository.getUserInfo(userId, userCallback);
    }

}
