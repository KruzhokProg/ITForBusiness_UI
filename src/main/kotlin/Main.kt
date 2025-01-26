import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    Box()
}

fun main() {
    application(
        content = {
            Window(
                onCloseRequest = ::exitApplication,
                content = {
                    App()
                }
            )
        }
    )
}

@Composable
private fun Box() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .weight(1f)
                .background(
                    brush = Brush.horizontalGradient(gradientColors)
                )
        )
        Column(
            modifier = Modifier.weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(fuksia)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(chocolate)
            )
        }

    }
}

@Composable
private fun TextDemo() {
    Column (
//        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)),
//            .background(color = Color.LightGray, shape = CircleShape),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = fuksia),
                text = "Hello World",
                color = vasilek,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = vasilek),
                text = "Hello Kotlin",
                color = fuksia,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }
    )

}
//fun main() = application {
//    Window(onCloseRequest = ::exitApplication) {
//        App()
//    }
//}
