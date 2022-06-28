package com.project.Data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServices {

    companion object {

        private  val client = OkHttpClient.Builder().apply {
            addInterceptor(InterceptorAuth())
        }.build()

        private  lateinit var  INSTANCE : Retrofit
        private const val BASE_URL = "https://api.mercadolibre.com/"

        private fun getRetrofitInstance() : Retrofit {
            val http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  INSTANCE
        }

        fun createGetService() : IGetServices {
            return getRetrofitInstance().create(IGetServices::class.java)
        }
    }
}