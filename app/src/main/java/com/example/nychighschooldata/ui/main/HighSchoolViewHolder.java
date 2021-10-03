package com.example.nychighschooldata.ui.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;

public class HighSchoolViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    public HighSchoolViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(HighSchool highSchool) {
       binding.setVariable(R.id.high_school_name, highSchool.getSchool_name());
        binding.executePendingBindings();
    }

}
