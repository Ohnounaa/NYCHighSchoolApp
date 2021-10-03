package com.example.nychighschooldata.repository
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nychighschooldata.Models.HighSchool
import com.example.nychighschooldata.Models.SATScore

//@Database(entities = [HighSchool:: class],
//    version = 1,
//    exportSchema = false)

@Database(
    entities = [
        HighSchool::class,
       SATScore::class
    ],
    version = 3
)


    abstract class HighSchoolDatabase: RoomDatabase() {
       abstract fun highSchoolsDAO() : HighSchoolsDAO
        companion object {
            //we want database to be a singleton
            @Volatile
            private var INSTANCE: HighSchoolDatabase? = null
            fun getInstance(context: Context): HighSchoolDatabase? {
                synchronized(this) {
                    var instance = INSTANCE
                    if(instance == null) {
                        instance = Room.databaseBuilder(context.applicationContext,
                            HighSchoolDatabase::class.java,
                            "highschool_database")
                            .fallbackToDestructiveMigration().build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
    }

