package br.com.hallisonoliveira.exercicio2.api

import br.com.hallisonoliveira.exercicio2.model.Mimic
import retrofit2.http.Body
import retrofit2.http.POST

interface MimicApi {
    @POST("mimic/")
    suspend fun getMimicText(
        @Body text: String
    ) : Mimic
}