package ru.mirea.kachalov.domain;

public interface ApiCallback<T> {

    public void onSuccess(T result);
    public void onError(Exception error);

}
