package com.playlab.kmpproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.playlab.kmpproject.data.local.DataStoreSingleton
import data.local.PreferencesDataStore
import screen.HomeScreen
import screen.LazyListScreen
import ui.theme.KmpProjectTheme
import ui.theme.components.MenuItemButton
import viewmodel.ConfigurationViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferencesDataStore =
            PreferencesDataStore(DataStoreSingleton.getDataStoreInstance(this))
        val configViewModel = ConfigurationViewModel(preferencesDataStore)
        val isDarkTheme by configViewModel.darkTheme

        setContent {
            KmpProjectTheme(darkTheme = isDarkTheme) {
                Surface {
                    Navigator(
                        HomeScreen(
                            preferencesDataStore = preferencesDataStore,
                            configViewModel = configViewModel,
                            featureItems = { navigator ->
                                LazyVerticalGrid(
                                    modifier = Modifier.fillMaxSize(),
                                    columns = GridCells.Adaptive(200.dp),
                                    verticalArrangement = Arrangement.spacedBy(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    contentPadding = PaddingValues(16.dp),
                                ) {
                                    item {
                                        MenuItemButton(
                                            onClick = {
                                                navigator.push(
                                                    LazyListScreen()
                                                )
                                            },
                                            text = "DraggableScreen"
                                        )
                                    }
                                }
                            }
                        )
                    ){ navigator ->
                        SlideTransition(navigator)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    Text("Something")
}