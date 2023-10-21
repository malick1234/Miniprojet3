package ca.qc.cgodin.mini_projet3.network

import ca.qc.cgodin.mini_projet3.Connexion
import ca.qc.cgodin.mini_projet3.models.Student
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST


interface SuccursalesApiService {
    @POST("/students/Connexion")
    suspend fun getConnexion(@Body connexion: Connexion): Response<Student> //Call<ResponseBody>

    @POST("/students/Succursale-Liste")
    suspend fun getListeSuccursale(aut: String)

    @POST("/students/Succursale-Compte")
    suspend fun getCompteSuccursale(aut: String)

    @POST("/students/Succursale-Budget")
    suspend fun setBudgetSuccursale(aut: String, ville: String)

    @DELETE("/students/Succursale-Suppression")
    suspend fun deleteAjoutSuccursale(aut: String, ville: String)


}