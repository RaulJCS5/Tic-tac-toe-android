package project.android.rauljcs5.ui.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    private var _isLoading by mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading
}