package br.com.hallisonoliveira.exercicio2.api

import br.com.hallisonoliveira.exercicio2.model.Numbers
import retrofit2.http.Body
import retrofit2.http.POST

interface NumberApi {
    @POST("number/")
    suspend fun getClassifiedNumbers(
        @Body numbers: String
    ) : Numbers
}