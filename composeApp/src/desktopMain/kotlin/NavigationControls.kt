import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import androidx.compose.ui.input.key.*

@Composable
fun NavigationControls(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    content: @Composable () -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(modifier
        .focusable(true)
        .focusRequester(focusRequester)
        .onKeyEvent {
            if (it.key == Key.Backspace && it.type == KeyEventType.KeyDown) {
                navigator.pop()
                false
            } else false
        }
        .padding(horizontal = 16.dp)) {
        Row {
            IconButton(
                onClick = {
                    navigator.pop()
                },
                colors = IconButtonDefaults.filledIconButtonColors()
            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Row(modifier = Modifier.weight(1f)) {
            content()
        }
    }
}