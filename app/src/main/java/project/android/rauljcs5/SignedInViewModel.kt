package project.android.rauljcs5

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignedInViewModel(
    val userRepository: UserRepository
) : ViewModel() {
    private val _username = mutableStateOf<String?>(null)
    val username: MutableState<String?>
        get() = _username
}
