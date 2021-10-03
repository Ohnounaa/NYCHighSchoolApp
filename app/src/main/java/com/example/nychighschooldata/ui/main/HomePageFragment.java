package com.example.nychighschooldata.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;
import com.example.nychighschooldata.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        super(R.layout.fragment_home);
    }
    View fragmentLayout = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        fragmentLayout = binding.getRoot();
        HomePageViewModel homePageViewModel = new ViewModelProvider(requireActivity()).get(HomePageViewModel.class);

        final Observer<List<HighSchool>> highSchoolsObserver = highSchools -> {
           binding.highSchoolsList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
           binding.highSchoolsList.setAdapter(new HighSchoolsAdapter(highSchools));
        };
        homePageViewModel.getHighSchools().observe(getViewLifecycleOwner(), highSchoolsObserver);

        return fragmentLayout;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}




