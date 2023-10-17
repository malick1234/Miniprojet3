package ca.qc.cgodin.mini_projet3.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)
    @Query("SELECT * from table_student")
    fun getStudents(): LiveData<List<Student>>

    @Query("SELECT * from table_student")
    fun getStudent(Mat: String): LiveData<Student?>

    @Update
    fun updateStudent(student: Student)
    @Delete
    fun deleteStudent(student: Student)
}