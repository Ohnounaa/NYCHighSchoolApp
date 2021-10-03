package com.example.nychighschooldata.ui.main;

import android.util.Log;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nychighschooldata.Models.HighSchool;
import com.squareup.picasso.Picasso;

class DetailViewModel: ViewModel() {
  private var mutableLiveDataSelectedSchool: MutableLiveData<HighSchool> = MutableLiveData()
    val selectedHighSchool: LiveData<HighSchool> get() = mutableLiveDataSelectedSchool

    fun selectHighSchool(highSchool: HighSchool) {
        mutableLiveDataSelectedSchool.value = highSchool
    }

}


