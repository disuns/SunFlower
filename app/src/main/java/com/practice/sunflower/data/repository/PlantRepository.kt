package com.practice.sunflower.data.repository

import com.practice.sunflower.data.dao.PlantDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepository @Inject constructor(private val plantDao : PlantDao){
    fun getPlants() = plantDao.getPlants()
    fun getPlant(plantId: String) = plantDao.getPlant(plantId)
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
    companion object {
        // For Singleton instantiation
        @Volatile private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao) =
            instance ?: synchronized(this) {
                instance ?: PlantRepository(plantDao).also { instance = it }
            }
    }
}