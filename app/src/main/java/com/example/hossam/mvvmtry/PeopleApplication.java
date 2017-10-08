package com.example.hossam.mvvmtry;

import android.app.Application;
import android.content.Context;

import com.example.hossam.mvvmtry.data.PeopleApi;
import com.example.hossam.mvvmtry.data.PeopleApiService;

/**
 * Created by hossam on 10/8/17.
 */

public class PeopleApplication extends Application {
    private  PeopleApiService peopleApiService;
    private PeopleApi peopleApi;





    public  static  PeopleApplication get (Context context)
    {
        return ((PeopleApplication) (context.getApplicationContext()));
    }



    public   PeopleApi getPeopleService() {
        if (peopleApi == null) {
            peopleApi = PeopleApiService.create();
        }
        return peopleApi;

    }


    public static PeopleApplication create(Context context) {
        return PeopleApplication.get(context);
    }





}
