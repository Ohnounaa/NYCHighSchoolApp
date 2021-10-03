package com.example.nychighschooldata.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;

import java.util.ArrayList;

public class HighSchoolsAdapter extends RecyclerView.Adapter<HighSchoolViewHolder> {

    ArrayList<HighSchool> highSchoolsList = null;

    public HighSchoolsAdapter(ArrayList<HighSchool> highSchools) {
        highSchoolsList = highSchools;
    }

    @NonNull
    @Override
    public HighSchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.high_school_view_holder, parent, false);
        return new HighSchoolViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HighSchoolViewHolder holder, int position) {
        holder.bind(highSchoolsList.get(position));
    }

    @Override
    public int getItemCount() {
        return highSchoolsList.size();
    }
}
