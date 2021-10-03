package com.example.nychighschooldata.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nychighschooldata.Models.HighSchool;
import com.example.nychighschooldata.R;
import com.example.nychighschooldata.databinding.FragmentHomeBinding;
import com.example.nychighschooldata.databinding.MovieViewHolderBinding;

import java.util.List;


public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       HomePageViewModel homePageViewModel = new ViewModelProvider(requireActivity()).get(HomePageViewModel.class);

       final Observer<List<HighSchool>> highSchoolsObserver = highSchools -> {

       };
        homePageViewModel.getHighSchools().observe(getViewLifecycleOwner(), highSchoolsObserver);
    }
}




