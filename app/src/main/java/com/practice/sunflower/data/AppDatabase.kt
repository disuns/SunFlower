package com.practice.sunflower.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.practice.sunflower.data.dao.GardenPlantingDao
import com.practice.sunflower.data.dao.PlantDao
import com.practice.sunflower.utilities.DATABASE_NAME
import com.practice.sunflower.utilities.PLANT_DATA_FILENAME
import com.practice.sunflower.workers.SeedDatabaseWorker
import com.practice.sunflower.workers.SeedDatabaseWorker.Companion.KEY_FILENAME

@Database(entities = [GardenPlanting::class, Plant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao
    companion object{
        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return instance?: synchronized(this){
                instance ?: buildDatabase(context).also{ instance = it }
            }
        }

        private fun buildDatabase(context: Context):AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().setInputData(
                                workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME)).build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                ).build()
        }
    }
}