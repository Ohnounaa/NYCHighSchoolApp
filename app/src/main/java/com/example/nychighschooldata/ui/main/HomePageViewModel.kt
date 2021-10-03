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
   val highSchools: LiveData<List<HighSchool>>  get() = highSchoolsMutableLiveData

   init {
          fetchHighSchoolsData()
       Log.d("ALIZA", highSchools.value?.first()?.school_name?:"")
   }

    private fun fetchHighSchoolsData() {
     viewModelScope.launch {
       highSchoolsMutableLiveData = repository.getHighSchools()
     }
    }


//    private fun getPopularMovies(pageNumber: String) {
//        viewModelScope.launch {
//            val popularMoviesAPIData = repository.getPopularMoviesFromAPI(pageNumber)
//            popularMovies = popularMoviesAPIData
//        }
//    }
//
//    private fun getConfigurationData() {
//        viewModelScope.launch{
//            val configDataFromAPI = repository.getConfigurationDataFromAPI()
//            configurationData = configDataFromAPI
//        }
//    }
//
//    private fun getGenres() {
//        viewModelScope.launch {
//            val genresFromAPI = repository.getGenreMap()
//            genreMap = genresFromAPI
//        }
//    }
//
//    private fun getNowPlayingMovies(pageNumber: String)  {
//        viewModelScope.launch {
//            val currentMoviesAPIData = repository.getNowPlayingMoviesFromAPI(pageNumber)
//            currentMovies = currentMoviesAPIData
//        }
//    }
}