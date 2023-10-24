package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.CompteSuccursale
import ca.qc.cgodin.mini_projet3.Connexion
import ca.qc.cgodin.mini_projet3.network.RetrofitInstance
import retrofit2.http.Body

class SuccursaleRepository() {
    suspend fun getConnexion(@Body connexion: Connexion) =
        RetrofitInstance.retrofitService.getConnexion(connexion);

    suspend fun getCompteSuccursale(@Body compteSuccursale: CompteSuccursale) =
        RetrofitInstance.retrofitService.getCompteSuccursale(compteSuccursale);

    suspend fun getListeSuccursale(@Body compteSuccursale: CompteSuccursale) =
        RetrofitInstance.retrofitService.getListeSuccursale(compteSuccursale);

}
import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleDao

class SuccursaleRepository(private val succursaleDao: SuccursaleDao) {

    val allSuccursales: LiveData<List<Succursale>> = succursaleDao.getSuccursales()

    suspend fun insert(succursale: Succursale){
        succursaleDao.insert(succursale)
    }

     fun getBudget(ville: String): Long {
        return succursaleDao.getBudget(ville)
    }

    suspend fun delete(succursale: Succursale){
        succursaleDao.deleteSuccursale(succursale)
    }

    suspend fun deleteAll(){
        succursaleDao.deleteAll()
    }

}
