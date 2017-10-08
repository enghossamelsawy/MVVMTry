package com.example.hossam.mvvmtry.data;

import com.example.hossam.mvvmtry.model.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hossam on 10/8/17.
 */

public class PeopleResponse {


    @SerializedName("results") private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> mPeopleList) {
        this.peopleList = mPeopleList;
    }
}




