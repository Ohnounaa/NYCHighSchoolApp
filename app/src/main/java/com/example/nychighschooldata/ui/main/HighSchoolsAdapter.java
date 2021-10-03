package com.example.nychighschooldata.ui.main;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;

import java.util.ArrayList;

public class HighSchoolsAdapter extends RecyclerView.Adapter<HighSchoolViewHolder> {

    ArrayList<HighSchool> highSchoolsList = null;

    public HighSchoolsAdapter(ArrayList<HighSchool> highSchools) {
        highSchoolsList = highSchools;
    }

    @NonNull
    @Override
    public HighSchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HighSchoolViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return highSchoolsList.size();
    }
}
