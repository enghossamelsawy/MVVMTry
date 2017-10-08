package com.example.hossam.mvvmtry.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hossam on 10/8/17.
 */

public class People {

    @SerializedName("gender") public String gender;

    @SerializedName("name") public Name name;

    @SerializedName("location") public Location location;

    @SerializedName("email") public String mail;

    @SerializedName("login") public Login userName;

    @SerializedName("phone") public String phone;

    @SerializedName("cell") public String cell;

    @SerializedName("picture") public Picture picture;

    public String fullName;

    public boolean hasEmail() {
        return mail != null && !mail.isEmpty();
    }
}


