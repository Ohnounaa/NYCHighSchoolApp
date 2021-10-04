package com.example.nychighschooldata.ui.main;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nychighschooldata.Models.HighSchool;

import java.util.ArrayList;


class FavoriteHighSchoolsViewModel: ViewModel() {
     var favoriteHighSchools: ArrayList<HighSchool> = ArrayList()
    private var highSchoolsMutableLiveData : MutableLiveData<List<HighSchool>> = MutableLiveData()
    val highSchoolsLiveData: LiveData<List<HighSchool>> get() = highSchoolsMutableLiveData

    fun addFavoriteHighSchool(highSchool: HighSchool) {
        favoriteHighSchools.add(highSchool);
        highSchoolsMutableLiveData.value = favoriteHighSchools;
    }



    fun removeFavoriteHighSchool(highSchool: HighSchool){
        if(favoriteHighSchools.contains(highSchool)) {
            favoriteHighSchools.remove(highSchool);
            highSchoolsMutableLiveData.value = favoriteHighSchools;
        }
    }

}
