package state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//fun onValueChange(text: String): Unit {
//
//}

@Composable
fun CheckerDemo() {
    val checkedState = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.8f)
                .background(Color.White)
                .padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Column {
                Text(
                    text = "Bring out the Trash",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (checkedState.value) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )
                Text(
                    text = "Better do this before wife comes home",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textDecoration = if (checkedState.value) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )
            }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                }
            )
        }
    }
}
//Духлес
//ДухLess[без]
//StateLess
@Composable
fun Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onCounterButtonClick: () -> Unit
) {
    Button(
        onClick = {
            onCounterButtonClick()
        }
    ) {
        Text("Count: ${count}")
    }

}