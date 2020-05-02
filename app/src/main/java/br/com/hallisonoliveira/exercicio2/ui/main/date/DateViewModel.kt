package br.com.hallisonoliveira.exercicio2.ui.main.date

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.hallisonoliveira.exercicio2.model.Date
import br.com.hallisonoliveira.exercicio2.repository.DateRepository
import kotlinx.coroutines.runBlocking

class DateViewModel : ViewModel() {
    private val repository = DateRepository()

    val dateLiveData = MutableLiveData<Date>()

    fun getDateDifferences(startDate: String, endDate: String) {
        runBlocking {
            dateLiveData.postValue(repository.getDateDifferences(startDate, endDate))
        }
    }
}