package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import viewmodel.ConfigurationViewModel
import kotlin.random.Random

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val configViewModel: ConfigurationViewModel = viewModel { ConfigurationViewModel() }

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
                Button(onClick = {
                    navigator.push(
                        DetailsScreen(Random.nextInt(0, 100))
                    )
                }) {
                    Text(text = "Go to details")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ScrollableListScreen()
                    )
                }) {
                    Text(text = "ScrollableList")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ScrollableLazyListScreen()
                    )
                }) {
                    Text(text = "ScrollableLazyListScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ClickEventScreen()
                    )
                }) {
                    Text(text = "ClickEventScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ContextMenuScreen()
                    )
                }) {
                    Text(text = "ContextMenuScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        DraggableScreen()
                    )
                }) {
                    Text(text = "DraggableScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        KeyEventScreen()
                    )
                }) {
                    Text(text = "KeyEventScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        MouseHoverScreen()
                    )
                }) {
                    Text(text = "MouseHoverScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        TooltipsScreen()
                    )
                }) {
                    Text(text = "TooltipsScreen")
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        NetworkScreen()
                    )
                }) {
                    Text(text = "NetworkScreen")
                }
            }
        }
    }
}