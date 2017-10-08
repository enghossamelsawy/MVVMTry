package com.example.hossam.mvvmtry.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hossam on 10/8/17.
 */

public class Location {

    @SerializedName("street") public String street;

    @SerializedName("city") public String city;

    @SerializedName("state") public String state;

    @SerializedName("zip") public String zip;
}
