package screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class ExampleScreen : Screen {
    @Composable
    override fun Content() {
//        ScrollableList()
//        ScrollableLazyList()
          Tooltips()
    }

    @Composable
    fun ScrollableList() {
        val verticalScroll = rememberScrollState(0)
        val horizontalScroll = rememberScrollState(0)

        val scrollbarStyle = defaultScrollbarStyle().copy(
            unhoverColor = Color(0xAC683B).copy(alpha = 0.22f),
            hoverColor = Color(0xAC683B).copy(alpha = 0.50f)
        )

        Box(
            modifier = Modifier.fillMaxSize().padding(12.dp),

            ) {

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(verticalScroll).horizontalScroll(horizontalScroll)
                    .padding(end = 12.dp, bottom = 12.dp)
            ) {
                for (item in 0..30) {
                    Text(
                        modifier = Modifier.padding(bottom = 12.dp),
                        text = "This the item number #$item",
                    )
                }
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(verticalScroll),
                style = scrollbarStyle,
            )
            HorizontalScrollbar(
                modifier = Modifier.align(Alignment.BottomStart).padding(end = 12.dp),
                adapter = rememberScrollbarAdapter(horizontalScroll),
                style = scrollbarStyle,
            )
        }
    }

    @Composable
    fun ScrollableLazyList() {
        val horizontalScroll = rememberScrollState(0)
        val lazyListState = rememberLazyListState()

        val scrollbarStyle = defaultScrollbarStyle().copy(
            unhoverColor = Color(0xAC683B).copy(alpha = 0.22f),
            hoverColor = Color(0xAC683B).copy(alpha = 0.50f)
        )

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
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(lazyListState),
                style = scrollbarStyle,
            )
            HorizontalScrollbar(
                modifier = Modifier.align(Alignment.BottomStart).padding(end = 12.dp),
                adapter = rememberScrollbarAdapter(horizontalScroll),
                style = scrollbarStyle,
            )
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Tooltips() {
        val buttons = listOf("Contact us", "About")

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            buttons.forEachIndexed { index, title ->
                TooltipArea(
                    tooltip = {
                        Surface(
                            modifier = Modifier.shadow(8.dp),
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = if (index == 0) " Get in touch"
                                else "This is our team",
                            )
                        }
                    },
                    delayMillis = 600,
                    tooltipPlacement = TooltipPlacement.CursorPoint(
                        alignment = BottomEnd
                    )
                ) {
                    Button(onClick = {}) {
                        Text(text = title)
                    }
                }
                if (index == 0) {
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }
        }
    }
}