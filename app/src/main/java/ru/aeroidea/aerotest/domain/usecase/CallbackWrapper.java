package ru.aeroidea.aerotest.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class CallbackWrapper<T extends UseCase.ResponseValues> extends DisposableObserver<T> {

    public void onSuccess() {
    }

    public void onSuccess(T t) {
    }

    public void onError(String message) {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        onSuccess();
    }
}
