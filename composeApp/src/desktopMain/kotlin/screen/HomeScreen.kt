package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.local.DataStoreSingleton
import data.local.PreferencesDataStore
import ui.theme.components.MenuItemButton
import viewmodel.ConfigurationViewModel
import kotlin.random.Random

class HomeScreen : Screen {
    val preferencesDataStore = PreferencesDataStore(DataStoreSingleton.getDataStoreInstance())

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val configViewModel: ConfigurationViewModel = viewModel { ConfigurationViewModel(preferencesDataStore) }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart,
        ) {
            IconButton(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd),
                onClick = {
                    configViewModel.toggleDarkTheme()
                },
                colors = IconButtonDefaults.filledIconButtonColors()
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Theme",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            Features(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                navigator = navigator
            )
        }


    }

    @Composable
    fun Features(
        modifier: Modifier = Modifier,
        navigator: Navigator
    ) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Adaptive(200.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            DetailsScreen(Random.nextInt(0, 100))
                        )
                    },
                    text = "Go to details"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            ScrollableListScreen()
                        )
                    },
                    text = "ScrollableListScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            ScrollableLazyListScreen()
                        )
                    },
                    text = "ScrollableLazyListScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            ClickEventScreen()
                        )
                    },
                    text = "ClickEventScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            ContextMenuScreen()
                        )
                    },
                    text = "ContextMenuScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            DraggableScreen()
                        )
                    },
                    text = "DraggableScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            KeyEventScreen()
                        )
                    },
                    text = "KeyEventScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            MouseHoverScreen()
                        )
                    },
                    text = "MouseHoverScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            TooltipsScreen()
                        )
                    },
                    text = "TooltipsScreen"
                )
            }
            item {
                MenuItemButton(
                    onClick = {
                        navigator.push(
                            NetworkScreen()
                        )
                    },
                    text = "NetworkScreen"
                )
            }
        }
    }
}