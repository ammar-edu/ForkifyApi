package com.s95ammar.forkifyapi.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.s95ammar.forkifyapi.model.Repository
import com.s95ammar.forkifyapi.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _dishes = MutableLiveData<List<Dish>>()

    val dishes: LiveData<List<Dish>> = _dishes

    fun search(query: String) {
        disposeOnCleared(
            Repository.search(query),
            { response ->
                _dishes.value = response.dishesDto
                    ?.mapNotNull { dishDto -> Dish.Mapper.fromDto(dishDto) }
                    .orEmpty()

                Log.d("MainViewModel", _dishes.value.toString())
            },
            { throwable ->
                // TODO: handle possible error
                Log.e("MainViewModel", throwable.message.toString())
            }
        )
    }
}