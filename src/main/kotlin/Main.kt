import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlin.random.Random

@Composable
@Preview
fun App() {
//    ImageDemo()
//    ListDemo()
//    HW2()
    FlowDemo()
}

fun main() {
    application(
        content = {
            Window(
//                state = WindowState(width = 600.dp, height = 600.dp),
//                resizable = false,
                title = "Московские мастера 2025",
                onCloseRequest = ::exitApplication,
                content = {
//                    App()
//                    HW3()
                    HotelBookingScreen()
                }
            )
        }
    )
}

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val imagePath: String
)

@Composable
fun ListDemo() {
    val names = listOf(
        User(1, "Коля", 20, "drawable/kermit.jpg"),
        User(2, "Петя", 30, "drawable/kermit.jpg"),
        User(1, "Вася", 40, "drawable/kermit.jpg"),
    )
//    val randomStrings = (1..100)
    Row (
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        names.forEach { item ->
            UserCard(item)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowDemo() {
    val names = listOf(
        User(1, "Коля", 20, "drawable/kermit.jpg"),
        User(2, "Петя", 30, "drawable/kermit.jpg"),
        User(1, "Вася", 40, "drawable/kermit.jpg"),
    )
//    val items = (1..100)
    FlowRow (
        modifier = Modifier.fillMaxSize(),
        maxItemsInEachRow = 3
    ) {
        names.forEach { item ->
            UserCard(item)
        }
//        items.forEach { item ->
//            Text(item.toString(), modifier = Modifier.padding(10.dp))
//        }
    }
}

@Composable
fun UserCard(user: User) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(color = orphidea, shape = RoundedCornerShape(5.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .size(150.dp),
                    contentScale = ContentScale.Crop,
                    imageVector = Icons.Default.Face,//painter = painterResource(user.imagePath),
                    contentDescription = null
                )
                Box(
                    modifier = Modifier
                        .background(color = Color.Black.copy(alpha = 0.3f))
                        .width(150.dp)
                        .height(30.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Row{
                        Text(text = user.name, style = myStyle)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(user.age.toString(), style = myStyle)
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier.height(150.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(user.name)
                Text(user.age.toString())
            }
        }
    }
}

@Composable
fun ImageDemo() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier.align(Alignment.Center),
        ) {
            Image(
                painter = painterResource("drawable/kermit.jpg"),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black)
                        )
                    )
            )
            IconButton(
                onClick = {},
                modifier = Modifier.align(Alignment.BottomEnd),
                content = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = fuksia
                    )
                }
            )
        }
    }
}

@Composable
fun HW() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(
                        brush = Brush.horizontalGradient(gradientColors)
                    )
            )
            Column(
                modifier = Modifier.weight(2f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(fuksia)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Hello",
                        fontSize = 50.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(chocolate)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Hello",
                        fontSize = 50.sp
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(
                        color = Color.Red
                    )
            )

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Cyan)
            )
        }
    }
}

@Composable
private fun HW2(){

//        Box(
//            modifier = Modifier
//                .dis
//
//                .height(100.dp)
//                .background(color = Color.Black)
//        )


    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().weight(4f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(
                            brush = Brush.horizontalGradient(gradientColors)
                        )
                )
                Column(
                    modifier = Modifier.weight(2f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .background(fuksia)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Hello",
                            fontSize = 50.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .background(chocolate)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Hello",
                            fontSize = 50.sp
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(
                            color = Color.Red
                        )
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Green)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Cyan)
                )
            }
            Row(modifier = Modifier.fillMaxSize().weight(2f)) {
                Column(modifier = Modifier.fillMaxSize().weight(3f)) {
                    Row(modifier = Modifier.fillMaxSize().weight(5f)){
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(color = greysquirell)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f)
                                .background(color = orphidea)
                        )
                    }
                    Row(modifier = Modifier.fillMaxSize().weight(5f)) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f)
                                .background(color = blackpurpur)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(color = colorvk)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = indigo)
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize().weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(4f)
                    .background(
                        brush = Brush.horizontalGradient(listOf(fuksia, greysquirell, greenblue))
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Magenta)
            )
        }
    }
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
    Column(
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
