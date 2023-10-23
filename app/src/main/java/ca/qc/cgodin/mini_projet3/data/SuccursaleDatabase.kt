package ca.qc.cgodin.mini_projet3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Succursale::class), version = 1, exportSchema = false)
abstract class SuccursaleDatabase : RoomDatabase() {
    abstract fun succursaleDao(): SuccursaleDao

    companion object{
        @Volatile
        private var INSTANCE: SuccursaleDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

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