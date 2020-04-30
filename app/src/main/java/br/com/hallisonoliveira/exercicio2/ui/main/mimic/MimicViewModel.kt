package br.com.hallisonoliveira.exercicio2.ui.main.mimic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.hallisonoliveira.exercicio2.model.Mimic
import br.com.hallisonoliveira.exercicio2.repository.MimicRepository
import kotlinx.coroutines.runBlocking

class MimicViewModel : ViewModel() {
    private val repository = MimicRepository()

    val mimicTextLiveData = MutableLiveData<Mimic>()

    fun getMimicText(text: String) {
        runBlocking {
            mimicTextLiveData.postValue(repository.getMimicText(text))
        }
    }
}