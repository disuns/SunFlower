package com.practice.sunflower.compose.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.practice.sunflower.R

enum class SunflowerPage(
    @StringRes val titleResId : Int,
    @DrawableRes val drawableResId : Int
){
    MY_GARDEN(R.string.my_garden_title, R.drawable.ic_my_garden_active),
    PLANT_LIST(R.string.plant_list_title, R.drawable.ic_plant_list_active)
}