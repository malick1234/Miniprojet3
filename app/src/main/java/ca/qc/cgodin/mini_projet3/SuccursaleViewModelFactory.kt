package ca.qc.cgodin.mini_projet3

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel

class SuccursaleViewModelFactory(private val application: Application) : ViewModelProvider.AndroidViewModelFactory(application){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SuccursaleViewModel::class.java)){
            SuccursaleViewModel(application) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}