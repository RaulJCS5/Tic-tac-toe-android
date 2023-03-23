package project.android.rauljcs5.ui.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.android.rauljcs5.LocalPlDto

class MainViewModel(): ViewModel() {
    private var _isLoading by mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading

    private var _username by mutableStateOf<String?>(null)
    var username: String?=null
        get() = _username

    fun logout(){
        viewModelScope.launch {
            _username=null
        }
    }

    fun setLogin(userExtra: LocalPlDto?) {
        viewModelScope.launch {
            if (userExtra!=null)
                _username=userExtra.username
        }
    }
}