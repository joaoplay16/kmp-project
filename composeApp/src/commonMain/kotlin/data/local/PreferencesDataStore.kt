package data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesDataStore(private val dataStore: DataStore<Preferences>) {

    companion object {
        val IS_DARK_THEME_KEY = stringPreferencesKey("is_dark_theme_key")
    }

    val isDarkThemeEnabled: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[IS_DARK_THEME_KEY]?.toBoolean() ?: false
        }

    suspend fun setDarkThemeEnabled(isDarkThemeEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_THEME_KEY] = isDarkThemeEnabled.toString()
        }
    }
}