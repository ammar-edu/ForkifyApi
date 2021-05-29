package com.s95ammar.forkifyapi.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.s95ammar.forkifyapi.model.Repository
import com.s95ammar.forkifyapi.ui.base.BaseViewModel
import com.s95ammar.forkifyapi.util.EventLiveData
import com.s95ammar.forkifyapi.util.EventMutableLiveData
import com.s95ammar.forkifyapi.util.LoadingState
import com.s95ammar.forkifyapi.util.call

class MainViewModel : BaseViewModel() {

    private val _dishes = MutableLiveData<List<Dish>>()
    private val _showEvent = EventMutableLiveData<MainUiEvent>()

    val dishes: LiveData<List<Dish>> = _dishes
    val showEvent: EventLiveData<MainUiEvent> = _showEvent

    fun search(query: String) {
        _showEvent.call(MainUiEvent.DisplayLoadingState(LoadingState.Loading))

        disposeOnCleared(
            Repository.search(query),
            { response ->
                _dishes.value = response.dishesDto
                    ?.mapNotNull { dishDto -> Dish.Mapper.fromDto(dishDto) }
                    .orEmpty()

                _showEvent.call(MainUiEvent.DisplayLoadingState(LoadingState.Success))
                Log.d("MainViewModel", _dishes.value.toString())
            },
            { throwable ->
                _showEvent.call(MainUiEvent.DisplayLoadingState(LoadingState.Error(throwable)))
                Log.e("MainViewModel", throwable.message.toString())
            }
        )
    }
}