package com.example.nychighschooldata.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import com.example.nychighschooldata.repository.HighSchoolsRepository
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {

   private val repository = HighSchoolsRepository.retrieve()
   private var highSchoolsMutableLiveData: MutableLiveData<List<HighSchool>> = MutableLiveData<List<HighSchool>>()
   val highSchools: LiveData<List<HighSchool>> get() = highSchoolsMutableLiveData
   private var satScoresMutableLiveData: MutableLiveData<List<SATScore>> = MutableLiveData<List<SATScore>>()

   init {
       fetchHighSchoolsData()
       fetchHighSchoolSATScores()
   }

    private fun fetchHighSchoolsData() {
     viewModelScope.launch {
         highSchoolsMutableLiveData = repository.getHighSchools()
         //one improvement to this would be to have the vm check if the db is pre-populated and then read from that
         repository.addHighSchoolToDB(highSchools.value?:ArrayList())
     }
    }
    private fun fetchHighSchoolSATScores() {
        viewModelScope.launch{
            satScoresMutableLiveData = repository.getSATScores()
            repository.addSATScoresToDB(satScoresMutableLiveData.value?:ArrayList())
        }
    }

}