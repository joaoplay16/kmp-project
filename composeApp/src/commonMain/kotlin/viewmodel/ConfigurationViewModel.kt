package viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConfigurationViewModel : ViewModel() {
    val darkTheme: State<Boolean> field = mutableStateOf(false)

    fun toggleDarkTheme() {
        darkTheme.value = !darkTheme.value
    }
}