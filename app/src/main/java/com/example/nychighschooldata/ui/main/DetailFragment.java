package com.example.nychighschooldata.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.Models.SATScore;
import com.example.nychighschooldata.R;
import com.example.nychighschooldata.databinding.FragmentDetailBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;


public class DetailFragment extends BottomSheetDialogFragment {


    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DetailViewModel detailViewModel = new ViewModelProvider(requireActivity()).get(DetailViewModel.class);
        View fragmentLayout;
        FragmentDetailBinding fragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        fragmentLayout = fragmentDetailBinding.getRoot();
        final Observer<HighSchool> highSchoolObserver = highSchool -> {
            fragmentDetailBinding.heading.setText(highSchool.getSchool_name());
            fragmentDetailBinding.schoolDescription.setText(highSchool.getOverview_paragraph());
            highSchool.
        };
        detailViewModel.getSelectedHighSchool().observe(getViewLifecycleOwner(), highSchoolObserver);
   return fragmentLayout;

    }
}