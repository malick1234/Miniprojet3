package ca.qc.cgodin.mini_projet3.network

import retrofit2.http.DELETE
import retrofit2.http.POST

interface SuccursalesApiService {
    @POST("/students/Connexion")
    suspend fun getConnexion(mat : String, mdp: String)

    @POST("/students/Succursale-Liste")
    suspend fun getListeSuccursale(aut: String)

    @POST("/students/Succursale-Compte")
    suspend fun getCompteSuccursale(aut: String)

    @POST("/students/Succursale-Budget")
    suspend fun setBudgetSuccursale(aut: String, ville: String)

    @DELETE("/students/Succursale-Suppression")
    suspend fun deleteAjoutSuccursale(aut: String, ville: String)


}