package com.example.nychighschooldata.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschooldata.repository.HighSchoolsRepository
import kotlinx.coroutines.launch

class FavoriteMoviesViewModel: ViewModel() {
//    private val repository = HighSchoolsRepository.retrieve()
//    var favoriteMovies: ArrayList<Movie> = ArrayList()
//    var favoriteMoviesLiveData : MutableLiveData<List<Movie>>? = MutableLiveData()
//
//    fun addFavoriteMovie(favoriteMovie: Movie) {
//            favoriteMovies.add(favoriteMovie)
//            favoriteMoviesLiveData?.value = favoriteMovies
//            updateFavoriteMovieInDB(favoriteMovie)
//    }
//
//    fun removeFavoriteMovie(movieToRemove: Movie) {
//        if(favoriteMovies.contains(movieToRemove)) {
//            favoriteMovies.remove(movieToRemove)
//            favoriteMoviesLiveData?.value = favoriteMovies
//            removeFavoriteMovieInDb(movieToRemove)
//        }
//    }
//
//    private fun updateFavoriteMovieInDB(movie: Movie) {
//        viewModelScope.launch {
//            repository.addFavoriteMovieToDB(movie)
//        }
//    }
//
//    private fun removeFavoriteMovieInDb(movie:Movie) {
//        viewModelScope.launch {
//            repository.removeFavoriteMovieFromDB(movie)
//        }
//    }
}