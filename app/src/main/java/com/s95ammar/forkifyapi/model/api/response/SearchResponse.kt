package com.s95ammar.forkifyapi.model.api.response

import com.google.gson.annotations.SerializedName

class SearchResponse(
    @SerializedName("recipes")
    val dishesDto: List<DishDto>?
)
