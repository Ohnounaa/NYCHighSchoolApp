package com.example.nychighschooldata.repository

import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore
import retrofit2.Call
import retrofit2.http.GET

interface HighSchoolsAPI {

   /* Time permitting, I would've liked to have lazy loaded the high school data
   and paginated it to improve the launch performance. I would have appended the following
   query string parameters to do so:
   \$limit=100&\$offset=0"
    */

    @GET("s3k6-pzi2.json")
     fun retrieveNYCHighSchools(): Call<List<HighSchool>>


     @GET("f9bf-2cp4.json")
     fun retrieveNYCHighSchoolsSATScores():Call<List<SATScore>>

}