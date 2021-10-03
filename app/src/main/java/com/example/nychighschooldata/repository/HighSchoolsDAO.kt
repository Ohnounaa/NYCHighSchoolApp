package com.example.nychighschooldata.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore

@Dao
interface HighSchoolsDAO {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun addHighSchools(schools: List<HighSchool>)

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun addSATScores(schools: List<SATScore>)

@Query("SELECT * FROM high_school")
fun fetchHighSchools() : LiveData<List<HighSchool>>

@Delete
suspend fun removeMovie(movie: HighSchool)

}

