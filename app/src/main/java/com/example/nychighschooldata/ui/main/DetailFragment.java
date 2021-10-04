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
        FavoriteHighSchoolsViewModel favoriteHighSchoolsViewModel = new ViewModelProvider(requireActivity()).get(FavoriteHighSchoolsViewModel.class);
        View fragmentLayout;
        FragmentDetailBinding fragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        fragmentLayout = fragmentDetailBinding.getRoot();

        final Observer<HighSchool> highSchoolObserver = highSchool -> {
            fragmentDetailBinding.heading.setText(highSchool.getSchool_name());
            fragmentDetailBinding.schoolDescription.setText(highSchool.getOverview_paragraph());
            fragmentDetailBinding.transportationOptions.setText("MTA Options: " + highSchool.getSubway());
            fragmentDetailBinding.favoriteButton.setOnClickListener(v -> {
                if(!favoriteHighSchoolsViewModel.getFavoriteHighSchools().contains(highSchool)) {
                    favoriteHighSchoolsViewModel.addFavoriteHighSchool(highSchool);
                    fragmentDetailBinding.favoriteButton.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                } else {
                    favoriteHighSchoolsViewModel.removeFavoriteHighSchool(highSchool);
                    fragmentDetailBinding.favoriteButton.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                }
            });
        };
        detailViewModel.getSelectedHighSchool().observe(getViewLifecycleOwner(), highSchoolObserver);
        final Observer<List<SATScore>> singleSATObserver = satScore -> {
            if(!satScore.isEmpty()) {
                fragmentDetailBinding.satMath.setText("Math: " + satScore.get(0).getSat_math_avg_score());
                fragmentDetailBinding.satEnglish.setText("Critical Reading: " + satScore.get(0).getSat_critical_reading_avg_score());
                fragmentDetailBinding.satWriting.setText("Writing: " + satScore.get(0).getSat_writing_avg_score());
            } else {
                fragmentDetailBinding.noScoresReported.setVisibility(View.VISIBLE);
                fragmentDetailBinding.satSectionHeader.setVisibility(View.GONE);
                fragmentDetailBinding.satMath.setVisibility(View.GONE);
                fragmentDetailBinding.satEnglish.setVisibility(View.GONE);
                fragmentDetailBinding.satWriting.setVisibility(View.GONE);
            }
        };
        detailViewModel.getSelectedSATScore().observe(getViewLifecycleOwner(), singleSATObserver);

        return fragmentLayout;
    }
}