package com.s95ammar.forkifyapi.util

sealed class LoadingState {
    object Loading : LoadingState()
    object Success : LoadingState()
    class Error(val throwable: Throwable): LoadingState()
}
