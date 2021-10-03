package com.example.nychighschooldata.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       HomePageViewModel homePageViewModel = new ViewModelProvider(requireActivity()).get(HomePageViewModel.class);

       final Observer<ArrayList<HighSchool>> highSchoolsObserver = highSchools -> {
           RecyclerView recyclerView = new RecyclerView(requireContext());
           recyclerView.setAdapter(new HighSchoolsAdapter(highSchools));
           recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
       };
        homePageViewModel.getHighSchools().observe(getViewLifecycleOwner(), highSchoolsObserver);
    }
}




