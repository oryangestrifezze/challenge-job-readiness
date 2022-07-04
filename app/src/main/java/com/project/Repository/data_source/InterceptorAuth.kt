package com.project.Repository.data_source

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorAuth : Interceptor {

    private val accessToken = "Bearer APP_USR-2200225733175765-070416-bcc2f74179882b03f0c45a9aafb1be01-795944208"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", accessToken)
            .build()
        return chain.proceed(request)
    }
}