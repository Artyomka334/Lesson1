package ru.mirea.kachalov.domain.models;

public class Account {
    private String id;
    private String email;
    private String password;

    public Account(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
