package ca.qc.cgodin.mini_projet3.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuccursaleViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SuccursaleRepository

    val allSuccursales: LiveData<List<Succursale>>

    private val _budgetLiveData = MutableLiveData<Int>()
    val budgetLiveData: LiveData<Int>
        get() = _budgetLiveData

    init {
        val succursaleDao = SuccursaleDatabase.getDatabase(application).succursaleDao()
        repository = SuccursaleRepository(succursaleDao)
        allSuccursales = repository.allSuccursales
    }
    fun insert(succursale: Succursale) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(succursale)
    }

    fun getBudget(ville: String) = viewModelScope.launch(Dispatchers.IO) {
        val budget = repository.getBudget(ville)
        _budgetLiveData.postValue(budget)
    }

    fun delete(succursale: Succursale) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(succursale)
    }
}
