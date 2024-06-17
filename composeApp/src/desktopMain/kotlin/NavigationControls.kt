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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun NavigationControls(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    content: @Composable () -> Unit
) {
    Column(modifier.padding(horizontal = 16.dp)) {
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