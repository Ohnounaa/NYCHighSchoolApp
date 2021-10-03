package com.example.nychighschooldata.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.repository.HighSchoolsRepository
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {

   private val repository = HighSchoolsRepository.retrieve()
   private var highSchoolsMutableLiveData: MutableLiveData<List<HighSchool>> = MutableLiveData<List<HighSchool>>()
   var highSchools: LiveData<List<HighSchool>>? = null

   init { fetchHighSchoolsData() }

    private fun fetchHighSchoolsData() {
     viewModelScope.launch {
        if (!repository.getHighSchoolsFromDB()!!.value.isNullOrEmpty()) highSchools = repository.getHighSchools() else {
            highSchoolsMutableLiveData = repository.getHighSchools()
            highSchools = highSchoolsMutableLiveData
        }

//        highSchoolsMutableLiveData =
//            if(repository.getHighSchoolsFromDB()?.value!!.isNotEmpty()) repository.getHighSchoolsFromDB() else repository.getHighSchools()
     }
    }
}