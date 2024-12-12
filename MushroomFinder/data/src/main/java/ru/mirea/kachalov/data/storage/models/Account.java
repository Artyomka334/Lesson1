package ru.mirea.kachalov.data.storage.models;

public class Account {

    private int id;

    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Account(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
