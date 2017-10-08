package com.example.hossam.mvvmtry.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by hossam on 10/8/17.
 */

public interface PeopleApi {

     String BASE_URL = "http://api.randomuser.me/";
     String RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en";
     String PROJECT_URL = "https://github.com/erikcaffrey/People-MVVM";


    @GET Observable<PeopleResponse> fetchPeople(@Url String url);


}
