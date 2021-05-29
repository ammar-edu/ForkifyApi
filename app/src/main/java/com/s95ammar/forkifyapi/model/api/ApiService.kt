package com.s95ammar.forkifyapi.model.api

import com.s95ammar.forkifyapi.model.api.response.SearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    fun search(@Query("q") query: String): Single<SearchResponse>
}
