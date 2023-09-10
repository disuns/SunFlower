package com.practice.sunflower.compose.plantlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import com.practice.sunflower.data.Plant
import com.practice.sunflower.R
import com.practice.sunflower.viewmodels.PlantListViewModel

@Composable
fun PlantListScreen(
    onPlantClick: (Plant) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PlantListViewModel = hiltViewModel(),
) {
    val plants by viewModel.plants.observeAsState(initial = emptyList())
    PlantListScreen(plants = plants, modifier, onPlantClick = onPlantClick)
}

@Composable
fun PlantListScreen(
    plants: List<Plant>,
    modifier: Modifier = Modifier,
    onPlantClick: (Plant) -> Unit = {},
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.testTag("plant_list"),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.card_side_margin),
            vertical = dimensionResource(id = R.dimen.header_margin)
        )
    ) {
        items(
            items = plants,
            key = { it.plantId }
        ) { plant ->
            PlantListItem(plant = plant) {
                onPlantClick(plant)
            }
        }
    }
}