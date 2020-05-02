package br.com.hallisonoliveira.exercicio2.ui.main.number

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.hallisonoliveira.exercicio2.model.Numbers
import br.com.hallisonoliveira.exercicio2.repository.NumberRepository
import kotlinx.coroutines.runBlocking

class NumberViewModel : ViewModel() {
    private val repository = NumberRepository()

    val numbersLiveData = MutableLiveData<Numbers>()

    fun getClassifiedNumbers(numbers: String) {
        runBlocking {
            numbersLiveData.postValue(repository.getClassifiedNumbers(numbers))
        }
    }
}