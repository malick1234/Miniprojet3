package ca.qc.cgodin.mini_projet3.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuccursaleDaoFavoris {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(succursalesFavoris: SuccursaleFavoris)

    @Query("SELECT * from table_succursale_favoris")
    fun getSuccursalesFavoris(): LiveData<List<SuccursaleFavoris>>

    @Delete
    fun deleteSuccursaleFavoris(succursalesFavoris: SuccursaleFavoris)

}
