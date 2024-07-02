package data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

object DataStoreSingleton {
    private var dataStore: DataStore<Preferences>? = null
    private const val dataStoreFileName = "kmpproject.preferences_pb"

    fun getDataStoreInstance(): DataStore<Preferences> {
        if (dataStore == null) {
            dataStore = createDataStore { "./" }
        } else {
            dataStore
        }
        return dataStore!!
    }

    private fun createDataStore(producePath: () -> String): DataStore<Preferences> =
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { (producePath() + dataStoreFileName).toPath() }
        )
}