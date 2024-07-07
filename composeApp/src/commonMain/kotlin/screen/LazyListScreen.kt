package screen

import components.NavigationControls
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class LazyListScreen : Screen {
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.currentOrThrow

        NavigationControls(navigator = navigator) {
            ScrollableLazyList()
        }
    }

    @Composable
    fun ScrollableLazyList() {
        val horizontalScroll = rememberScrollState(0)
        val lazyListState = rememberLazyListState()


        Box(
            modifier = Modifier.fillMaxSize().padding(12.dp),

            ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScroll(horizontalScroll)
                    .padding(end = 12.dp, bottom = 12.dp),
                state = lazyListState
            ) {
                for (item in 0..30) {
                    item {
                        Text(
                            modifier = Modifier.padding(bottom = 12.dp),
                            text = "This the item number #$item",
                        )
                    }
                }
            }
        }
    }
}