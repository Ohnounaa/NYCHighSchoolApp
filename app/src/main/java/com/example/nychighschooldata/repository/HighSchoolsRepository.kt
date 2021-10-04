package com.example.nychighschooldata.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore

class HighSchoolsRepository private constructor(context: Context){

   fun getHighSchools(): MutableLiveData<List<HighSchool>> {
        return HighSchoolsDataRetriever().getNYCHighSchoolData();
    }

    fun getSATScore(dbn: String): MutableLiveData<List<SATScore>> {
        return HighSchoolsDataRetriever().getHighSchoolSATScore(dbn)
    }

    private val database: HighSchoolDatabase? = HighSchoolDatabase.getInstance(context.applicationContext)
    private val highSchoolsDAO = database?.highSchoolsDAO()
    suspend fun addHighSchoolToDB(highSchools: HighSchool) = highSchoolsDAO?.addHighSchool(highSchools)
    suspend fun addSATScoresToDB(satScores: List<SATScore>) = highSchoolsDAO?.addSATScores(satScores)
    suspend fun getSelectedSATScoreFromDB(dbn:String) = highSchoolsDAO?.getSATScoreForHighSchool(dbn)
    suspend fun getAllSATScoresFromDB() = highSchoolsDAO?.fetchSATScores()
//
//  suspend fun addFavoriteMovieToDB(movie: Movie) = highSchoolsDAO?.addHighSchool(movie)
//
//  suspend fun removeFavoriteMovieFromDB(movie: Movie) = highSchoolsDAO?.removeMovie(movie)
//
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