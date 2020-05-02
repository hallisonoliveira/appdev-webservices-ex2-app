package br.com.hallisonoliveira.exercicio2.core

import br.com.hallisonoliveira.exercicio2.api.DateApi
import br.com.hallisonoliveira.exercicio2.api.MimicApi
import br.com.hallisonoliveira.exercicio2.api.NumberApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {

        private const val BASE_URL = "http://192.168.25.147:8080/"

        val mimicApi: MimicApi by lazy {
            getRetrofit(
                GsonConverterFactory.create()
            ).create(MimicApi::class.java)
        }

        val numberApi: NumberApi by lazy {
            getRetrofit(
                GsonConverterFactory.create()
            ).create(NumberApi::class.java)
        }

        val dateApi: DateApi by lazy {
            getRetrofit(
                GsonConverterFactory.create()
            ).create(DateApi::class.java)
        }

        private fun createOkHttpClient() : OkHttpClient.Builder {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient
                .addInterceptor(logging)

            return okHttpClient
        }

        private fun getRetrofit(factory: Converter.Factory): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .client(createOkHttpClient().build())
                .build()
        }
    }
}

