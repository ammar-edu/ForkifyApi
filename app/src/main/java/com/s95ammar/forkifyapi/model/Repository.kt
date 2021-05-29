package com.s95ammar.forkifyapi.model

import com.s95ammar.forkifyapi.model.api.ApiService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    private val apiService = createApiService()

    fun search(query: String) = apiService.search(query)

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://forkify-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun createApiService(): ApiService {
        return createRetrofit().create(ApiService::class.java)
    }
}