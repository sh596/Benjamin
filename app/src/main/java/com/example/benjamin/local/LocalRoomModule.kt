package com.example.benjamin.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.benjamin.model.Record
import com.example.benjamin.repository.RecordRepositoryImpl
import com.example.benjamin.repository.VirtueSeeMoreRepository
import com.example.benjamin.repository.VirtueSeeMoreRepositoryImpl
import com.example.benjamin.room.MainDatabase
import com.example.benjamin.room.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalRoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : MainDatabase{
        return Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            "main db"
        ).fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideMainDao(database: MainDatabase) : RecordDao{
        return database.mainDao()
    }
    @Singleton
    @Provides
    fun provideVirtueSeeMoreRepository(recordDao: RecordDao): VirtueSeeMoreRepositoryImpl{
        return VirtueSeeMoreRepositoryImpl(recordDao)
    }

    @Singleton
    @Provides
    fun provideRecordRepository(recordDao: RecordDao): RecordRepositoryImpl{
        return RecordRepositoryImpl(recordDao)
    }


}