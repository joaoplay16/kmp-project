package screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.TooltipPlacement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class TooltipsScreen : Screen {
    @Composable
    override fun Content(){
        Tooltips()
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