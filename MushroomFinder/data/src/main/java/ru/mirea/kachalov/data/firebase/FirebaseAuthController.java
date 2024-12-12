package ru.mirea.kachalov.data.firebase;

import android.util.Log;

import androidx.lifecycle.MediatorLiveData;

import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.kachalov.domain.UserCallback;
import ru.mirea.kachalov.domain.models.Account;

public class FirebaseAuthController implements AuthController {

    private final FirebaseAuth firebaseAuth;

    public FirebaseAuthController() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void logIn(String email, String password, FirebaseCallback authCallback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Log.d("MAIN_DEBUG", "Logged In");
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    Log.d("MAIN_DEBUG", "Failed when logging in");
                    authCallback.onFailure();
                });
    }

    @Override
    public void register(String email, String password, FirebaseCallback authCallback) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Log.d("MAIN_DEBUG", "Signed Up");
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    Log.d("MAIN_DEBUG", "Failed when signing in");
                    authCallback.onFailure();
                });
    }

    @Override
    public boolean hasUserLogged() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void logOut() {
        firebaseAuth.signOut();
    }

    @Override
    public void getUserInfo(String userId, UserCallback userCallback) {
        if (firebaseAuth.getCurrentUser() != null) {
            Account account = new Account(userId, firebaseAuth.getCurrentUser().getEmail());
            userCallback.onSuccess(account);
        } else {
            userCallback.onFailure();
        }
    }

    @Override
    public String getUserId() {
        return firebaseAuth.getCurrentUser().getUid();
    }
}
