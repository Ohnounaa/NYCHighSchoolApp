package com.example.nychighschooldata.repository

import android.app.Application

class HighSchoolsRepositoryInitializer: Application() {
    override fun onCreate() {
        super.onCreate()
        HighSchoolsRepository.initialize(this)
    }
}