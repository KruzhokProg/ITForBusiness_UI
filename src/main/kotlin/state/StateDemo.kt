package state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//fun onValueChange(text: String): Unit {
//
//}

@Composable
fun Counter(
    modifier: Modifier = Modifier
) {
    val count: MutableState<Int> = remember { mutableStateOf(0) }
    val login: MutableState<String> = remember { mutableStateOf("") }
    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TextField(
            value = login.value,
            onValueChange = { newText ->
                login.value = newText
            }
        )
        Button(
            onClick = {
                count.value++
            }
        ) {
            Text("Count: ${count.value}")
        }
    }
}