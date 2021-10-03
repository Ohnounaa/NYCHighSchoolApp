package com.example.nychighschooldata.ui.main;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import com.example.nychighschooldata.repository.HighSchoolsRepository
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    private val repository = HighSchoolsRepository.retrieve()
  private var mutableLiveDataSelectedSchool: MutableLiveData<HighSchool> = MutableLiveData()
    val selectedHighSchool: LiveData<HighSchool> get() = mutableLiveDataSelectedSchool
    lateinit var selectedSATScore: LiveData<SATScore>;


    fun selectHighSchool(highSchool: HighSchool) {
        mutableLiveDataSelectedSchool.value = highSchool
        viewModelScope.launch {
            selectedSATScore = repository.getSelectedSATScoreFromDB(selectedHighSchool.value!!.dbn)!!
        }
    }
}


