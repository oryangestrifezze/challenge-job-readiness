package com.project.Data

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterceptorAuth : Interceptor {
    val access_token = "Bearer APP_USR-2200225733175765-062814-c930aff56f12c0e6149cb6e7c0bba96b-795944208"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", access_token)
            .build()
        return chain.proceed(request)
    }
}