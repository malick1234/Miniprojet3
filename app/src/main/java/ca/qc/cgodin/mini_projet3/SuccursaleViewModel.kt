package ca.qc.cgodin.mini_projet3

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.ResponseStudent
import ca.qc.cgodin.mini_projet3.models.ResponseSuccursales
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import kotlinx.coroutines.launch
import retrofit2.http.Body

class SuccursaleViewModel(
    private val succursaleRepository: SuccursaleRepository
)  : ViewModel(){
    var connect: ResponseStudent? = null
    var nbSuccursale: String = ""
    val liste: MutableLiveData<ResponseSuccursales> = MutableLiveData()

    fun getConnexion(connexion: Connexion) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getConnexion(connexion)
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" || response.body()?.statut == "PASOK"){
                    connect = response.body()
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }
    fun getCompteSuccursale(compteSuccursale: CompteSuccursale) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getCompteSuccursale(compteSuccursale)
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" && response.body()?.nbSuccursale != null){
                    nbSuccursale = response.body()?.nbSuccursale.toString();
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }

    fun getListeSuccursale(compteSuccursale: CompteSuccursale) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getListeSuccursale(compteSuccursale)
            Log.i("", response.body().toString())
            if(response.isSuccessful){
                if(response.body()?.statut == "OK" && response.body()?.succursales != null){
                    liste.postValue(response.body());
                }
            }
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }
}