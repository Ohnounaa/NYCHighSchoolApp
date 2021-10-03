package com.example.nychighschooldata.ui.main;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nychighschooldata.Models.HighSchool

class DetailViewModel: ViewModel() {
  private var mutableLiveDataSelectedSchool: MutableLiveData<HighSchool> = MutableLiveData()
    val selectedHighSchool: LiveData<HighSchool> get() = mutableLiveDataSelectedSchool

    fun selectHighSchool(highSchool: HighSchool) {
        mutableLiveDataSelectedSchool.value = highSchool
    }

    fun getSATScoreForSelectedHighSchool() {

    }
}


