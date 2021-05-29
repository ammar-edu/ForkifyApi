package com.s95ammar.forkifyapi.ui.main

import com.s95ammar.forkifyapi.model.api.response.DishDto

data class Dish(
    val title: String,
    val imageUrl: String
) {
    object Mapper {

        fun fromDto(dishDto: DishDto): Dish? {
            if (dishDto.title == null || dishDto.imageUrl == null) return null
            return Dish(dishDto.title, dishDto.imageUrl)
        }

    }
}
