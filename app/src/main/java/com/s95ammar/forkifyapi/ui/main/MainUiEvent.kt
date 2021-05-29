package com.s95ammar.forkifyapi.ui.main

import com.s95ammar.forkifyapi.util.LoadingState

sealed class MainUiEvent {
    class DisplayLoadingState(val loadingState: LoadingState) : MainUiEvent()
}
