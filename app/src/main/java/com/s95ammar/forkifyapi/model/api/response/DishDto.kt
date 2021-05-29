package com.s95ammar.forkifyapi.model.api.response

import com.google.gson.annotations.SerializedName

data class DishDto(
    @SerializedName("title")
    val title: String?,
    @SerializedName("image_url")
    val imageUrl: String?
)
