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
import com.practice.sunflower.viewmodels.PlantListViewModel

@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {

    private val viewModel: PlantListViewModel by viewModels()

    private val menuProvider = object :MenuProvider{
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.menu_plant_list,menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return when(menuItem.itemId){
                R.id.filter_zone -> {
                    viewModel.updateData()
                    true
                }
                else -> false
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MdcTheme{
                SunflowerApp(
                    onAttached = { toolbar ->
                        setSupportActionBar(toolbar)
                    },
                    onPageChange = { page ->
                        when(page){
                            SunflowerPage.MY_GARDEN -> removeMenuProvider(menuProvider)
                            SunflowerPage.PLANT_LIST -> addMenuProvider(menuProvider, this)
                        }
                    },
                    plantListViewModel = viewModel
                )
            }
        }
    }
}
