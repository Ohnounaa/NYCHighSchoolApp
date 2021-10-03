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
import com.example.nychighschooldata.databinding.HighSchoolViewHolderBinding;

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
   class HighSchoolsAdapter extends RecyclerView.Adapter<HighSchoolViewHolder> {

        List<HighSchool> highSchoolsList = null;

        public HighSchoolsAdapter(List<HighSchool> highSchools) {
            highSchoolsList = highSchools;
        }

        @NonNull
        @Override
        public HighSchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            HighSchoolViewHolderBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.high_school_view_holder, parent, false);
            // set the view's size, margins, paddings and layout parameters
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

    class HighSchoolViewHolder extends RecyclerView.ViewHolder {

        private final HighSchoolViewHolderBinding binding;
        DetailViewModel detailViewModel = new ViewModelProvider(requireActivity()).get(DetailViewModel.class);

        public HighSchoolViewHolder(HighSchoolViewHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HighSchool highSchool) {
            binding.highSchoolName.setText(highSchool.getSchool_name());
            binding.address.setText(highSchool.getLocation());
            binding.gradesServed.setText("Grade Levels Served: "  + highSchool.getFinalgrades());
            binding.card.setOnClickListener(v -> {
                        this.detailViewModel.selectHighSchool(highSchool);
                    }
            );
            binding.executePendingBindings();
        }

    }

}




