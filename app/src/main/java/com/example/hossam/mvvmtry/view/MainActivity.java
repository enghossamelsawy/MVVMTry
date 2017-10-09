package com.example.hossam.mvvmtry.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hossam.mvvmtry.R;
import com.example.hossam.mvvmtry.databinding.ActivityMainBinding;
import com.example.hossam.mvvmtry.viewmodel.PeopleViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {


    private ActivityMainBinding activityMainBinding;
    private PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setupObserver(peopleViewModel);
        setupListPeopleView(activityMainBinding.listPeople);
    }


    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        peopleViewModel = new PeopleViewModel(this);
        activityMainBinding.setMainViewModel(peopleViewModel);

    }


    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {


        if (observable instanceof PeopleViewModel) {
            PeopleAdapter peopleAdapter = (PeopleAdapter) activityMainBinding.listPeople.getAdapter();
            PeopleViewModel peopleViewModel = (PeopleViewModel) observable;
            peopleAdapter.setPeopleList(peopleViewModel.getPeopleList());
        }

    }


    private void setupListPeopleView(RecyclerView listPeople) {
        PeopleAdapter adapter = new PeopleAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

}
