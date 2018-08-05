package ru.aeroidea.aerotest.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> {
    private CompositeDisposable mDisposable;

    public UseCase() {
        mDisposable = new CompositeDisposable();
    }

    protected abstract Observable<P> buildUseCaseObservable(Q requestValues);

    public void executeUseCase(DisposableObserver<P> observer, Q requestValues) {
        mDisposable.add(buildUseCaseObservable(requestValues)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }

    public void dispose() {
        if (mDisposable.isDisposed())
            mDisposable.dispose();
    }

    public interface RequestValues {
    }

    public interface ResponseValues {
    }
}
