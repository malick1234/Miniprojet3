package ca.qc.cgodin.mini_projet3.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuccursaleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(succursale: Succursale)
    @Query("SELECT * from table_succursale")
    fun getSuccursales(): LiveData<List<Succursale>>

    //@Query("SELECT * from table_student")
    @Query("SELECT * from table_succursale WHERE Ville=(:Ville)")
    fun getBudget(Ville: String): LiveData<Succursale?>

    @Update
    fun updateSuccursale(succursale: Succursale)
    @Delete
    fun deleteSuccursale(succursale: Succursale)
}
