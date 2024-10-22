package ru.mirea.kachalov.data.firebase;

public interface AuthController {

    public void logIn(String email, String password, FirebaseCallback authCallback);
    public void register(String email, String password, FirebaseCallback authCallback);
    public boolean hasUserLogged();
    public void logOut();

}
