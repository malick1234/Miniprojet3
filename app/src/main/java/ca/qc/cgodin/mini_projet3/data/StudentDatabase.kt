package ca.qc.cgodin.mini_projet3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    companion object{
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getDatabase(context: Context): StudentDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                StudentDatabase::class.java,
                "student_database"
            ).build()
            return INSTANCE as StudentDatabase
        }
    }
}