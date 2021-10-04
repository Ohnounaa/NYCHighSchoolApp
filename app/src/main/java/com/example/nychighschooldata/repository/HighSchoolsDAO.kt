package com.example.nychighschooldata.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import com.squareup.picasso.Picasso
import java.nio.channels.SelectableChannel

@Dao
interface HighSchoolsDAO {

@Insert
 fun addHighSchool(school: HighSchool)

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun addSATScores(schools: List<SATScore>)

@Query("SELECT * FROM high_school")
fun fetchHighSchools(): LiveData<List<HighSchool>>

@Query("SELECT * FROM sat_score")
fun fetchSATScores() : LiveData<List<SATScore>>

@Query("SELECT * FROM sat_score WHERE dbn = :selectedDbn")
fun getSATScoreForHighSchool(selectedDbn:String) : LiveData<SATScore>

@Delete
suspend fun removeFavoriteHighSchool(movie: HighSchool)

}

