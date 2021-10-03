package com.example.nychighschooldata.repository

import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import retrofit2.Call
import retrofit2.http.GET

interface HighSchoolsAPI {

    @GET("s3k6-pzi2.json?\$limit=100&\$offset=0")
     fun retrieveNYCHighSchools(): Call<List<HighSchool>>


     @GET("f9bf-2cp4.json")
     fun retrieveNYCHighSchoolsSATScores():Call<List<SATScore>>


//    @GET("movie/popular?api_key=51c73e162cf5c4b1265e9d3e4b8f0128&language=en-US&page=1")
//     fun retrieveMostPopularMovies(@Query("page")page: String): Call<Movies>
//
//    @GET("configuration?api_key=51c73e162cf5c4b1265e9d3e4b8f0128")
//     fun retrieveConfiguration(): Call<Configuration>
//
//     @GET("genre/movie/list?api_key=51c73e162cf5c4b1265e9d3e4b8f0128&language=en-US")
//     fun getGenreIdsToNamesMap() : Call<Genres>

}