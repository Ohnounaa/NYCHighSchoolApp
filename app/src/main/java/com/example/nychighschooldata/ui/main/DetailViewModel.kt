package com.example.nychighschooldata.ui.main;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import com.example.nychighschooldata.repository.HighSchoolsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val repository = HighSchoolsRepository.retrieve()

    private var mutableLiveDataSelectedSchool: MutableLiveData<HighSchool> = MutableLiveData()
    val selectedHighSchool: LiveData<HighSchool> get() = mutableLiveDataSelectedSchool

    var mutableLiveDataSATScore: MutableLiveData<List<SATScore>> = MutableLiveData()
    val selectedSATScore: LiveData<List<SATScore>> get() =  mutableLiveDataSATScore

    fun onSelectSchool(highSchool: HighSchool) {
        mutableLiveDataSelectedSchool.value = highSchool
        getSATScore(highSchool)
    }

    private fun getSATScore(highSchool: HighSchool) {
        viewModelScope.launch {
           mutableLiveDataSATScore = repository.getSATScore(highSchool.dbn)
        }

    }
}


