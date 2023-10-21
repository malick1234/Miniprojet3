package ca.qc.cgodin.mini_projet3

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.Student
import ca.qc.cgodin.mini_projet3.network.RetrofitInstance
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import kotlinx.coroutines.launch
import retrofit2.Callback
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class SuccursaleViewModel(
    private val succursaleRepository: SuccursaleRepository
    )  : ViewModel(){
    val connexion: MutableLiveData<Student> = MutableLiveData()


    /* fun getConnexion(mat: String, mdp: String) = viewModelScope.launch {
        try {
            val response = succursaleRepository.getConnexion(mat, mdp)
                connexion.postValue(response.body())
        }catch (e: Exception){
            Log.i(javaClass.simpleName, e.message.toString())
        }
    }*/
     /*fun getConnexion(connexion: Connexion,
                     onResponse: (Response<ResponseBody>) -> Unit,
                     onFailure: (Throwable) -> Unit) = viewModelScope.launch {

        RetrofitInstance.retrofitService.getConnexion(connexion)
            .enqueue(object : Callback<ResponseBody> {
             override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                onResponse(response)
            }

             override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                onFailure(t)
            }
        })
    }*/
}