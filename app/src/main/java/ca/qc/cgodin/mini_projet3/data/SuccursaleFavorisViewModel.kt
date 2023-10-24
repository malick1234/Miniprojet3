package ca.qc.cgodin.mini_projet3.data

import ca.qc.cgodin.mini_projet3.repository.SuccursaleFavorisRepository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuccursaleFavorisViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SuccursaleFavorisRepository

    val allSuccursalesFavoris: LiveData<List<SuccursaleFavoris>>

    init {
        val succursaleDaoFavoris = SuccursaleFavorisDatabase.getDatabase(application).succursaleFavorisDao()
        repository = SuccursaleFavorisRepository(succursaleDaoFavoris)
        allSuccursalesFavoris = repository.allSuccursalesFavoris
    }
    fun insert(succursaleFavoris: SuccursaleFavoris) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(succursaleFavoris)
    }

    fun delete(succursaleFavoris: SuccursaleFavoris) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(succursaleFavoris)
    }
}
