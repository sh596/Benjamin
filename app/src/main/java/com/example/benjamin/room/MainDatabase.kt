package com.example.benjamin.room

import android.content.Context
import androidx.room.*
import com.example.benjamin.model.Record

@Database(entities = [Record::class], version = 1)
abstract class MainDatabase :RoomDatabase() {
    abstract fun mainDao() : RecordDao
//
//    companion object {
//        private var instance : MainDatabase? = null
//
//        @Synchronized
//        fun getInstance(context: Context) : MainDatabase?{
//            if(instance != null){
//                synchronized(MainDatabase::class.java){
//                    instance = Room.databaseBuilder(
//                        context,
//                        MainDatabase::class.java,
//                        "main db"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//
//                }
//            }
//            return instance
//        }
//    }

}