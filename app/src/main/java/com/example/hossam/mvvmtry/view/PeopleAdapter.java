package com.example.hossam.mvvmtry.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hossam.mvvmtry.R;
import com.example.hossam.mvvmtry.databinding.RecycleviewItemBinding;
import com.example.hossam.mvvmtry.model.People;
import com.example.hossam.mvvmtry.viewmodel.ItemPeopleViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by hossam on 10/9/17.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {

    private List<People> peopleList;

    public PeopleAdapter() {
        this.peopleList = Collections.emptyList();


    }


    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycleviewItemBinding recycleviewItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycleview_item,
                        parent, false);
        return new PeopleAdapterViewHolder(recycleviewItemBinding);

    }

    @Override
    public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        holder.bindPeople(peopleList.get(position));

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
        notifyDataSetChanged();
    }

    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder {
        RecycleviewItemBinding mItemPeopleBinding;

        public PeopleAdapterViewHolder(RecycleviewItemBinding itemView) {
            super(itemView.itemPeople);
            this.mItemPeopleBinding = itemView;
        }

        void bindPeople(People people) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }


    }
}
