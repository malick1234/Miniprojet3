package ca.qc.cgodin.mini_projet3.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuccursaleViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SuccursaleRepository

    val allSuccursales: LiveData<List<Succursale>>

    init {
        val succursaleDao = SuccursaleDatabase.getDatabase(application).succursaleDao()
        repository = SuccursaleRepository(succursaleDao)
        allSuccursales = repository.allSuccursales
    }
    fun insert(succursale: Succursale) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(succursale)
    }
}
