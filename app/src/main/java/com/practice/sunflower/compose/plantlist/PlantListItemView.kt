package com.practice.sunflower.compose.plantlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.practice.sunflower.R
import com.practice.sunflower.compose.utils.SunflowerImage
import com.practice.sunflower.data.Plant
@Composable
fun PlantListItem(plant: Plant, onClick: () -> Unit) {
    ImageListItem(name = plant.name, imageUrl = plant.imageUrl, onClick = onClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageListItem(name: String, imageUrl:String, onClick: () -> Unit){
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.card_side_margin))
            .padding(bottom = dimensionResource(id = R.dimen.card_bottom_margin))
    ){
        Column(Modifier.fillMaxHeight()) {
            SunflowerImage(model = imageUrl, contentDescription = stringResource(id = R.string.a11y_plant_item_image),
                Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.plant_item_image_height)),
                contentScale = ContentScale.Crop)
            Text(text = name, textAlign = TextAlign.Center, maxLines = 1, style = MaterialTheme.typography.titleMedium, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(id = R.dimen.margin_normal))
                .wrapContentWidth(Alignment.CenterHorizontally))
        }
    }
}