package ca.qc.cgodin.mini_projet3.network

import android.adservices.adselection.ReportImpressionRequest
import ca.qc.cgodin.mini_projet3.CompteSuccursale
import ca.qc.cgodin.mini_projet3.Connexion
import ca.qc.cgodin.mini_projet3.models.NbSuccursales
import ca.qc.cgodin.mini_projet3.models.ResponseStudent
import ca.qc.cgodin.mini_projet3.models.ResponseSuccursales
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST


interface SuccursalesApiService {
    @POST("/students/Connexion")
    suspend fun getConnexion(@Body connexion: Connexion): Response<ResponseStudent> //Call<ResponseBody>

    @POST("/succursales/Succursale-Liste")
    suspend fun getListeSuccursale(@Body compteSuccursale: CompteSuccursale): Response<ResponseSuccursales>

    @POST("/succursales/Succursale-Compte")
    suspend fun getCompteSuccursale(@Body compteSuccursale: CompteSuccursale): Response<NbSuccursales>

    @POST("/succursales/Succursale-Budget")
    suspend fun setBudgetSuccursale(aut: String, ville: String)

    @DELETE("/succursales/Succursale-Suppression")
    suspend fun deleteAjoutSuccursale(aut: String, ville: String)


}