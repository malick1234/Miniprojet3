package ca.qc.cgodin.mini_projet3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository

class SuccursaleViewModelProvider(
    private val succursaleRepository: SuccursaleRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SuccursaleViewModel::class.java)){
            SuccursaleViewModel(succursaleRepository) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}