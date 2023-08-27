package com.practice.sunflower

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.themeadapter.material.MdcTheme
import com.practice.sunflower.compose.SunflowerApp
import com.practice.sunflower.compose.home.SunflowerPage
import com.practice.sunflower.ui.theme.SunFlowerTheme
import com.practice.sunflower.viewmodels.PlantListViewModel

@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SunFlowerTheme {
                SunflowerApp()
            }
        }
    }
}
