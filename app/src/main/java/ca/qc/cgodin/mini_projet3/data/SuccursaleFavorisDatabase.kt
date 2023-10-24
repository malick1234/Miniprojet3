package ca.qc.cgodin.mini_projet3.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SuccursaleFavoris::class), version = 1, exportSchema = false)
abstract class SuccursaleFavorisDatabase : RoomDatabase() {

    abstract fun succursaleFavorisDao(): SuccursaleDaoFavoris

    companion object{
        @Volatile
        private var INSTANCE: SuccursaleFavorisDatabase? = null

        fun getDatabase(context: Context): SuccursaleFavorisDatabase{

            //test
            val db = Room.databaseBuilder(
                context.applicationContext,
                SuccursaleFavorisDatabase::class.java,
                "succursalefavoris_database"
            ).build()

            if (db != null) {
                Log.d("Database", "Database created successfully")
            } else {
                Log.e("Database", "Database creation failed")
            }

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SuccursaleFavorisDatabase::class.java,
                "succursalefavoris_database"
            ).build()
            return INSTANCE as SuccursaleFavorisDatabase
        }
    }
}