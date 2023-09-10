package com.practice.sunflower.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.practice.sunflower.data.PlantAndGardenPlantings
import kotlinx.coroutines.flow.Flow

@Dao
interface GardenPlantingDao {
    @Transaction
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>>
}