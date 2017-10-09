package com.example.hossam.mvvmtry;

import android.app.Application;
import android.content.Context;

import com.example.hossam.mvvmtry.data.PeopleApi;
import com.example.hossam.mvvmtry.data.PeopleApiService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hossam on 10/8/17.
 */

public class PeopleApplication extends Application {

    private PeopleApi peopleApi;
    private Scheduler scheduler;





    public  static  PeopleApplication get (Context context)
    {
        return ((PeopleApplication) context.getApplicationContext());
    }

    public static PeopleApplication create(Context context) {
        return PeopleApplication.get(context);
    }

    public   PeopleApi getPeopleService() {
        if (peopleApi == null) {
            peopleApi = PeopleApiService.create();
        }
        return peopleApi;

    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }


}
