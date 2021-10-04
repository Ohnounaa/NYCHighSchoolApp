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
import com.example.nychighschooldata.databinding.FavoriteHighSchoolViewHolderBinding;
import com.example.nychighschooldata.databinding.FragmentFavoritesBinding;
import com.example.nychighschooldata.databinding.HighSchoolViewHolderBinding;
import java.util.List;

public class FavoritesFragment extends Fragment {

    public FavoritesFragment() {
        super(R.layout.fragment_favorites);
    }
    View fragmentLayout = null;
    FavoriteHighSchoolsViewModel favoriteHighSchoolsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFavoritesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);
        favoriteHighSchoolsViewModel = new ViewModelProvider(requireActivity()).get(FavoriteHighSchoolsViewModel.class);
        fragmentLayout = binding.getRoot();

        final Observer<List<HighSchool>> favoriteHighSchoolsObserver = highSchools -> {
            binding.favoriteSchoolsCollection.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            binding.favoriteSchoolsCollection.setAdapter(new FavoritesFragment.FavoriteHighSchoolsAdapter(highSchools));
        };

        favoriteHighSchoolsViewModel.getHighSchoolsLiveData().observe(getViewLifecycleOwner(), favoriteHighSchoolsObserver);
        return fragmentLayout;
    }

    class FavoriteHighSchoolsAdapter extends RecyclerView.Adapter<FavoritesFragment.FavoriteHighSchoolViewHolder> {

        List<HighSchool> favoriteHighSchoolsList;

        public FavoriteHighSchoolsAdapter(List<HighSchool> highSchools) {
            favoriteHighSchoolsList = highSchools;
        }

        @NonNull
        @Override
        public FavoriteHighSchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            FavoriteHighSchoolViewHolderBinding binding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.favorite_high_school_view_holder, parent,
                    false);
            // set the view's size, margins, paddings and layout parameters
            return new FavoritesFragment.FavoriteHighSchoolViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull FavoritesFragment.FavoriteHighSchoolViewHolder holder, int position) {
            holder.bind(favoriteHighSchoolsList.get(position));
        }

        @Override
        public int getItemCount() {
            return favoriteHighSchoolsList.size();
        }
    }

    class FavoriteHighSchoolViewHolder extends RecyclerView.ViewHolder {

        private final FavoriteHighSchoolViewHolderBinding binding;
        DetailViewModel detailViewModel = new ViewModelProvider(requireActivity()).get(DetailViewModel.class);

        public FavoriteHighSchoolViewHolder(FavoriteHighSchoolViewHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HighSchool highSchool) {
            binding.favoriteHighSchoolName.setText(highSchool.getSchool_name());
            binding.emailAddress.setText(highSchool.getSchool_email());
            binding.removeButton.setOnClickListener(v -> {
                favoriteHighSchoolsViewModel.removeFavoriteHighSchool(highSchool);
            });
            binding.executePendingBindings();
        }
    }

}