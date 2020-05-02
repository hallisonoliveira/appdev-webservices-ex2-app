package br.com.hallisonoliveira.exercicio2.repository

import br.com.hallisonoliveira.exercicio2.core.Retrofit
import br.com.hallisonoliveira.exercicio2.model.Date

class DateRepository {

    suspend fun getDateDifferences(startDate: String, endDate: String) : Date {
        return Retrofit.dateApi.getDateDifferences(startDate, endDate)
    }

}