package ca.qc.cgodin.mini_projet3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Succursale::class), version = 1, exportSchema = false)
abstract class SuccursaleDatabase : RoomDatabase() {
    abstract fun succursaleDao(): SuccursaleDao

    companion object{
        @Volatile
        private var INSTANCE: SuccursaleDatabase? = null
        fun getDatabase(context: Context): SuccursaleDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SuccursaleDatabase::class.java,
                "succursale_database"
            ).build()
            return INSTANCE as SuccursaleDatabase
        }
    }
}