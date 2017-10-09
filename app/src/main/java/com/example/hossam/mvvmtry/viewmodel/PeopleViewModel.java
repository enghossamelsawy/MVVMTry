package com.example.hossam.mvvmtry.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.hossam.mvvmtry.PeopleApplication;
import com.example.hossam.mvvmtry.data.PeopleApi;
import com.example.hossam.mvvmtry.data.PeopleResponse;
import com.example.hossam.mvvmtry.model.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by hossam on 10/9/17.
 */

public class PeopleViewModel extends Observable {


    public ObservableInt peopleRecycler;
    // public ObservableInt peopleLabel;
    //public ObservableField<String> messageLabel;
    private List<People> peopleList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public PeopleViewModel(@NonNull Context context) {
        this.context = context;
        this.peopleList = new ArrayList<>();
        peopleRecycler = new ObservableInt(View.VISIBLE);
        // peopleLabel = new ObservableInt(View.VISIBLE);
//        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_people));
    }

    private void fetchPeopleList() {

        PeopleApplication peopleApplication = PeopleApplication.create(context);
        PeopleApi peopleService = peopleApplication.getPeopleService();

        compositeDisposable.add(peopleService.fetchPeople(PeopleApi.RANDOM_USER_URL)
                .subscribeOn(peopleApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<PeopleResponse>() {
                    @Override
                    public void onNext(PeopleResponse value) {

                        List<People> peopleList = value.getPeopleList();
                        changePeopleDataSet(peopleList);
                        peopleRecycler.set(View.VISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {


                        // peopleRecycler.set(View.GONE);
                    }

                    @Override
                    public void onComplete() {

                    }

                }));
    }

    public void onClickFabLoad(View view) {

        fetchPeopleList();
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }


    private void changePeopleDataSet(List<People> peoples) {
        peopleList.addAll(peoples);
        setChanged();
        notifyObservers();
    }


}
