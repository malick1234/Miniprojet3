package ca.qc.cgodin.mini_projet3.repository

import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleDao
import ca.qc.cgodin.mini_projet3.data.SuccursaleDaoFavoris
import ca.qc.cgodin.mini_projet3.data.SuccursaleFavoris

class SuccursaleFavorisRepository(private val succursaleDaoFavoris: SuccursaleDaoFavoris) {

    val allSuccursalesFavoris: LiveData<List<SuccursaleFavoris>> = succursaleDaoFavoris.getSuccursalesFavoris()

    suspend fun insert(succursaleFavoris: SuccursaleFavoris){
        succursaleDaoFavoris.insert(succursaleFavoris)
    }

    suspend fun delete(succursaleFavoris: SuccursaleFavoris){
        succursaleDaoFavoris.deleteSuccursaleFavoris(succursaleFavoris)
    }


}