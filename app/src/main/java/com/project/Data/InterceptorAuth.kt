package com.project.Data

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterceptorAuth : Interceptor {
    val access_token = "APP_USR-2200225733175765-062808-356e823975e75fbadbeb769aea674479-795944208"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Token $access_token")
            .build()
        return chain.proceed(request)
    }
}