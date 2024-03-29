package com.practice.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import com.practice.sunflower.data.PlantAndGardenPlantings
import com.practice.sunflower.data.repository.GardenPlantingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GardenPlantingListViewModel @Inject internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}