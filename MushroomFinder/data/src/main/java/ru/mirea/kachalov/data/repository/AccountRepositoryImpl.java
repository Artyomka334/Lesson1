package ru.mirea.kachalov.data.repository;

import ru.mirea.kachalov.data.firebase.AuthController;
import ru.mirea.kachalov.data.firebase.FirebaseCallback;
import ru.mirea.kachalov.domain.AuthorizationCallback;
import ru.mirea.kachalov.domain.repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {

    private final AuthController authController;

    public AccountRepositoryImpl(AuthController authController) {
        this.authController = authController;
    }

    @Override
    public void logIn(String email, String password, AuthorizationCallback authCallback) {
        authController.logIn(email, password, new FirebaseCallbackAdapter(authCallback));
    }

    @Override
    public void register(String email, String password, AuthorizationCallback authCallback) {
        authController.register(email, password, new FirebaseCallbackAdapter(authCallback));
    }

    @Override
    public void logOut() {
    }

    @Override
    public boolean hasUserLogged() {
        return authController.hasUserLogged();
    }

    @Override
    public void changeUserInfo(String newInfo) {
    }

    private static class FirebaseCallbackAdapter implements FirebaseCallback {

        private final AuthorizationCallback authCallback;

        public FirebaseCallbackAdapter(AuthorizationCallback authCallback) {
            this.authCallback = authCallback;
        }

        @Override
        public void onSuccess() {
            authCallback.onSuccess();
        }

        @Override
        public void onFailure() {
            authCallback.onFailure();
        }
    }
}
