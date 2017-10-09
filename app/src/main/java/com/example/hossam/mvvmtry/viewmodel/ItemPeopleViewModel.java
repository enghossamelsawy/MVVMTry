package com.example.hossam.mvvmtry.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hossam.mvvmtry.model.People;

/**
 * Created by hossam on 10/9/17.
 */

public class ItemPeopleViewModel extends BaseObservable {

    private People people;
    private Context context;


    public ItemPeopleViewModel(People people, Context context) {
        this.people = people;
        this.context = context;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);

    }

    public String getFullName() {
        people.fullName =
                people.name.title + "." + people.name.firts + " " + people.name.last;
        return people.fullName;
    }

    public String getCell() {
        return people.cell;
    }

    public String getMail() {
        return people.mail;
    }

    public String getPictureProfile() {
        return people.picture.medium;
    }

    public void setPeople(People people) {
        this.people = people;
        notifyChange();
    }

}
