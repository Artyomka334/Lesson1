package ru.mirea.kachalov.data.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

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

}
