package com.example.nychighschooldata.ui.main;

import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nychighschooldata.Models.HighSchool;
import com.squareup.picasso.Picasso;

class DetailViewModel extends ViewModel {
    private MutableLiveData<HighSchool> mutableLiveDataHighSchool;
    public LiveData<HighSchool> selectedSchool = mutableLiveDataHighSchool;

    public LiveData<HighSchool> getSelectedSchool()  {return selectedSchool;}
    public void selectSchool(HighSchool highSchool){ mutableLiveDataHighSchool.setValue(highSchool); }


}


