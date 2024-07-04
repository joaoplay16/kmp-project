package com.playlab.kmpproject.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

object DataStoreSingleton {
    private var dataStore: DataStore<Preferences>? = null

    fun getDataStoreInstance(context: Context): DataStore<Preferences> {
        if (dataStore == null) {
            dataStore = context.dataStore
        } else {
            dataStore
        }
        return dataStore!!
    }
}