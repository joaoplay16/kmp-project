package viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.local.PreferencesDataStore
import kotlinx.coroutines.launch

class ConfigurationViewModel(private val dataStore: PreferencesDataStore) : ViewModel() {
    val darkTheme: State<Boolean> field = mutableStateOf(false)

    init {
        viewModelScope.launch {
            dataStore.isDarkThemeEnabled.collect {
                darkTheme.value = it
            }
        }
    }

    fun toggleDarkTheme() {
        viewModelScope.launch {
            dataStore.setDarkThemeEnabled(!darkTheme.value)
        }
    }
}