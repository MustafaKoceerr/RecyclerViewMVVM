package com.example.recyclerviewmvvm

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {

        val response = call.invoke()

        if (response.isSuccessful) {
            // we can return the response
            return response.body()!!
        } else {
            throw ApiException("SafeApiRequest Exception: ${response.code()}")
        }
    }

}

class ApiException(message: String) : IOException(message)