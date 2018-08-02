package ru.aeroidea.aerotest.presentation.base;

public interface BasePresenter<T> {
    void bind(T view);

    void unbind();
}
