package com.example.hossam.mvvmtry.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hossam on 10/8/17.
 */

public class Picture {
    @SerializedName("large") public String large;

    @SerializedName("medium") public String medium;

    @SerializedName("thumbnail") public String thumbnail;
}
