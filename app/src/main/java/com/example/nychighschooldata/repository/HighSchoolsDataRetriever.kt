package com.example.nychighschooldata.repository


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nychighschooldata.Models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HighSchoolsDataRetriever {
    private val baseUrl = "https://data.cityofnewyork.us/resource/"

    fun getNYCHighSchoolData(): MutableLiveData<List<HighSchool>> {
        val highSchools: MutableLiveData<List<HighSchool>>  = MutableLiveData()
        val retrofit: Retrofit = Retrofit.
        Builder().
        baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build()
        val api: HighSchoolsAPI = retrofit.create(HighSchoolsAPI::class.java)
        val retriever = api.retrieveNYCHighSchools()
        retriever.enqueue(object: Callback<List<HighSchool>> {
            override fun onResponse(
                call: Call<List<HighSchool>>,
                response: Response<List<HighSchool>>
            ) {
                val resp = ArrayList<HighSchool>()
                response.isSuccessful.let {
                    response.body()?.forEach {""
                        resp.add(it)
                    }

                    highSchools.value = resp
                }
            }
            override fun onFailure(call: Call<List<HighSchool>>, t: Throwable) {
                Log.d("OHNOUNA", t.message.toString())
            }
        })
            return highSchools
    }
}