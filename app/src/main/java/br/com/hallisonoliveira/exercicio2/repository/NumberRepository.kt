package br.com.hallisonoliveira.exercicio2.repository

import br.com.hallisonoliveira.exercicio2.core.Retrofit
import br.com.hallisonoliveira.exercicio2.model.Numbers

class NumberRepository {

    suspend fun getClassifiedNumbers(numbers: String) : Numbers {
        return Retrofit.numberApi.getClassifiedNumbers(numbers)
    }

}