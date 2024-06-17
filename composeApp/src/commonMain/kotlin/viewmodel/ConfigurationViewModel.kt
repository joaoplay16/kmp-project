package viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ConfigurationViewModel : ViewModel() {
    private var _darkTheme by mutableStateOf(false)
    val darkTheme get() =  _darkTheme

    fun toggleDarkTheme() {
        _darkTheme = !_darkTheme
    }
}