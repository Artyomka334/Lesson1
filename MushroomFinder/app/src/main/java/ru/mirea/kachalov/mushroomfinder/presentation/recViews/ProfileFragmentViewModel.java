package ru.mirea.kachalov.mushroomfinder.presentation.recViews;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.kachalov.data.firebase.AuthController;
import ru.mirea.kachalov.data.firebase.FirebaseAuthController;
import ru.mirea.kachalov.data.repository.AccountRepositoryImpl;
import ru.mirea.kachalov.domain.UserCallback;
import ru.mirea.kachalov.domain.models.Account;
import ru.mirea.kachalov.domain.usecases.GetUserIdUseCase;
import ru.mirea.kachalov.domain.usecases.GetUserInfoUseCase;

public class ProfileFragmentViewModel extends ViewModel {

    private MutableLiveData<Account> mutableLiveData = new MutableLiveData<>();

    private GetUserInfoUseCase getUserInfoUseCase;
    private GetUserIdUseCase getUserIdUseCase;

    public MutableLiveData<Account> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(Account account) {
        mutableLiveData.setValue(account);
    }

    public ProfileFragmentViewModel() {
        AuthController authController = new FirebaseAuthController();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(authController);

        getUserInfoUseCase = new GetUserInfoUseCase(accountRepository);
        getUserIdUseCase = new GetUserIdUseCase(accountRepository);
    }

    public void getUserInfo(UserCallback userCallback) {
        getUserInfoUseCase.execute(getUserIdUseCase.execute(), userCallback);
    }
}
