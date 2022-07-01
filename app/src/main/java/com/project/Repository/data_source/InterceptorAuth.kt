package com.project.Repository.data_source

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorAuth : Interceptor {

    val access_token = "Bearer APP_USR-2200225733175765-070114-bb4256cce719f73b6e141983187f88fc-795944208"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", access_token)
            .build()
        return chain.proceed(request)
    }
}