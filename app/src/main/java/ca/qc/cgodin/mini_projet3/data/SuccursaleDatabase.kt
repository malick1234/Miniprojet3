package ca.qc.cgodin.mini_projet3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.text.Collator.PRIMARY


@Database(entities = arrayOf(Succursale::class), version = 1, exportSchema = false)
abstract class SuccursaleDatabase : RoomDatabase() {
    abstract fun succursaleDao(): SuccursaleDao

    companion object{
        @Volatile
        private var INSTANCE: SuccursaleDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS table_succursale_favoris(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "Ville TEXT," +
                        "Budget INTEGER" +
                        ");"
                )
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
            )
                .addMigrations(MIGRATION_1_2)
                .build()
            return INSTANCE as SuccursaleDatabase
        }
    }
}