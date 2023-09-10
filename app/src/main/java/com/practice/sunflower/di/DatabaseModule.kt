package com.practice.sunflower.di

import android.content.Context
import com.practice.sunflower.data.AppDatabase
import com.practice.sunflower.data.dao.GardenPlantingDao
import com.practice.sunflower.data.dao.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao{
        return appDatabase.plantDao()
    }

    @Provides
    fun provideGardenPlantingDao(appDatabase: AppDatabase): GardenPlantingDao {
        return appDatabase.gardenPlantingDao()
    }
}