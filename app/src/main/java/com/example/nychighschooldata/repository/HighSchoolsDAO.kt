package com.example.nychighschooldata.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nychighschooldata.Models.HighSchool

@Dao
interface HighSchoolsDAO {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun addHighSchool(schools: List<HighSchool>)

@Query("SELECT * FROM high_school")
fun fetchHighSchools() : LiveData<List<HighSchool>>

@Delete
suspend fun removeMovie(movie: HighSchool)

}

