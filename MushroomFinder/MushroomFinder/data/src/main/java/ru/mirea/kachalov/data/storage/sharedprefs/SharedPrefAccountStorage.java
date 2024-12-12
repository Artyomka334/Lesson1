package ru.mirea.kachalov.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.kachalov.data.storage.AccountStorage;
import ru.mirea.kachalov.data.storage.models.Account;

public class SharedPrefAccountStorage implements AccountStorage {

    private static final String SHARED_PREFS_NAME = "account_data";
    private static final String KEY_ACCOUNT_ID = "account_id";
    private static final String KEY_ACCOUNT_EMAIL = "account_email";
    private static final String KEY_ACCOUNT_PASSWORD = "account_password";
    private final SharedPreferences sharedPreferences;

    public SharedPrefAccountStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Account getAccount() {
        int id = sharedPreferences.getInt(KEY_ACCOUNT_ID, 0);
        String email = sharedPreferences.getString(KEY_ACCOUNT_EMAIL, "");
        String password = sharedPreferences.getString(KEY_ACCOUNT_PASSWORD, "");

        return new Account(id, email, password);
    }

    @Override
    public boolean saveAccount(Account account) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ACCOUNT_ID, account.getId());
        editor.putString(KEY_ACCOUNT_EMAIL, account.getEmail());
        editor.putString(KEY_ACCOUNT_PASSWORD, account.getPassword());
        editor.apply();

        return true;
    }
}
