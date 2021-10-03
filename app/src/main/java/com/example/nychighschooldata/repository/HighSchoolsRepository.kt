package com.example.nychighschooldata.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.nychighschooldata.Models.HighSchool

class HighSchoolsRepository private constructor(context: Context){

   fun getHighSchools(): MutableLiveData<ArrayList<HighSchool>> {
        return HighSchoolsDataRetriever().getNYCHighSchoolData();
    }

//    fun getPopularMoviesFromAPI(pageNumber: String) : MutableLiveData<List<Movie>> {
//        return HighSchoolsDataRetriever().retrieveMostPopularMoviesData(pageNumber)
//    }
//
//   fun getConfigurationDataFromAPI() : MutableLiveData<Configuration> {
//       return HighSchoolsDataRetriever().retrieveConfigurationData()
//   }
//    fun getGenreMap() : MutableLiveData<Genres> {
//        return HighSchoolsDataRetriever().retrieveGenreIdsAndNames()
//
//    }

  private val database: HighSchoolDatabase? = HighSchoolDatabase.getInstance(context.applicationContext)

  private val highSchoolsDAO = database?.highSchoolsDAO()
//
//  suspend fun addFavoriteMovieToDB(movie: Movie) = highSchoolsDAO?.addHighSchool(movie)
//
//  suspend fun removeFavoriteMovieFromDB(movie: Movie) = highSchoolsDAO?.removeMovie(movie)
//
//  suspend fun getFavoriteMovies(): LiveData<List<Movie>>? = highSchoolsDAO?.fetchHighSchools()


    companion object{
        private var INSTANCE: HighSchoolsRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = HighSchoolsRepository(context)
            }
        }

        fun retrieve(): HighSchoolsRepository {
            return INSTANCE ?: throw IllegalStateException("Repository has not been initialized.")
        }

    }
}