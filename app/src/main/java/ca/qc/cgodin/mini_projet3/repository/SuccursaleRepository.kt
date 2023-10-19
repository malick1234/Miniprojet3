package ca.qc.cgodin.mini_projet3.repository

import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleDao

class SuccursaleRepository(private val succursaleDao: SuccursaleDao) {

    val allSuccursales: LiveData<List<Succursale>> = succursaleDao.getSuccursales()

    suspend fun insert(succursale: Succursale){
        succursaleDao.insert(succursale)
    }

}