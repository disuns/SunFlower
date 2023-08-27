package com.practice.sunflower.compose.garden

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun GardenScreen(
    modifier: Modifier = Modifier,
    viewModel: GardenPlantingListViewModel = hiltViewModel(),
    onAddPlantClick: () -> Unit,
    onPlantClick: (PlantAndGardenPlantings) -> Unit
) {
    val gardenPlants by viewModel.plantAndGardenPlantings.collectAsState(initial = emptyList())
    GardenScreen(
        gardenPlants = gardenPlants,
        modifier = modifier,
        onAddPlantClick = onAddPlantClick,
        onPlantClick = onPlantClick
    )
}