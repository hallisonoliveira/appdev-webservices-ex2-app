package br.com.hallisonoliveira.exercicio2.repository

import br.com.hallisonoliveira.exercicio2.core.Retrofit
import br.com.hallisonoliveira.exercicio2.model.Mimic

class MimicRepository {

    suspend fun getMimicText(text: String) : Mimic {
        return Retrofit.mimicApi.getMimicText(text)
    }

}