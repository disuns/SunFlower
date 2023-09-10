package com.practice.sunflower.data.repository

import com.practice.sunflower.data.dao.GardenPlantingDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GardenPlantingRepository @Inject constructor(
    private val gardenPlantingDao : GardenPlantingDao
){

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()

}