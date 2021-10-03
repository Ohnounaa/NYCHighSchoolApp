package com.example.nychighschooldata.ui.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;
import com.example.nychighschooldata.databinding.HighSchoolViewHolderBinding;

public class HighSchoolViewHolder extends RecyclerView.ViewHolder {

    private final HighSchoolViewHolderBinding binding;

    public HighSchoolViewHolder(HighSchoolViewHolderBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(HighSchool highSchool) {
       binding.highSchoolName.setText(highSchool.getSchool_name());
       binding.address.setText(highSchool.getLocation());
       binding.gradesServed.setText("Grade Levels Served: "  + highSchool.getFinalgrades());
       binding.executePendingBindings();
    }

}
