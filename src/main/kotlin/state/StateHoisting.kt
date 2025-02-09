package state

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.random.Random

@Composable
fun StateHoisting(){
    val countState: MutableState<Int> = remember { mutableStateOf(0) }
    Column {
        Counter(
            count = countState.value,
            onCounterButtonClick = {
                countState.value++
            }
        )
        Button(
            onClick = {
                countState.value = 0
            }
        ) {
            Text("Reset")
        }
    }
}