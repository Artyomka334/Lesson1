package ru.mirea.kachalov.data.firebase;

import ru.mirea.kachalov.domain.UserCallback;

public interface AuthController {

    public void logIn(String email, String password, FirebaseCallback authCallback);
    public void register(String email, String password, FirebaseCallback authCallback);
    public boolean hasUserLogged();
    public void logOut();
    public void getUserInfo(String userId, UserCallback userCallback);
    public String getUserId();

}
