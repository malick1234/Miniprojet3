package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.network.RetrofitInstance

class SuccursaleRepository() {
    suspend fun getConnexion(mat: String, mdp: String) =
        RetrofitInstance.retrofitService.getConnexion(mat, mdp);
}
import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleDao

class SuccursaleRepository(private val succursaleDao: SuccursaleDao) {

    val allSuccursales: LiveData<List<Succursale>> = succursaleDao.getSuccursales()

    suspend fun insert(succursale: Succursale){
        succursaleDao.insert(succursale)
    }

    suspend fun getBudget(ville: String): Double{
        return succursaleDao.getBudget(ville)
    }

}
