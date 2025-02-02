import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.Painter

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HW3(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize().weight(4f)) {
            Image(
                painter = painterResource("drawable/living_room.png"),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = Color.White.copy(alpha = 0.5F))
                ) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Column(modifier = Modifier.fillMaxSize().weight(9f)) {
                            Text("Hotel California Strawberry",
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.ExtraBold,
                            )
                            Text("Los Angeles, California",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "4.9 (14K reviews)",
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Column(modifier = Modifier.fillMaxSize().weight(1f)) {
                            Text(
                                text = "$420/night",
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.ExtraBold

                                )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.02f)
                .background(color = Color.Black)
        )
        Box(modifier = Modifier.fillMaxSize().weight(2f).align(alignment = Alignment.CenterHorizontally)) {
            FlowRow (
                modifier = Modifier.fillMaxSize(),
                maxItemsInEachRow = 7
            ) {

                Text(
                    text = "City-Center",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )

                Text(
                    text = "Luxury",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )

                Text(
                    text = "Instant Booking",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )

                Text(
                    text = "Exclusive Deal",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )

                Text(
                    text = "Early Bird Discount",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )

                Text(
                    text = "Romantic Getaway",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )


                Text(
                    text = "24/7 Support",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.background(color = Color.White).padding(15.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.02f)
                .background(color = Color.Black)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(
                text = "The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the Iconic Hollywood Sign, Grimith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.'s best attractions",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .align(alignment = Alignment.Center)
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
        ) {
            Text(
                text = "What we offer",
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 250.dp)
            )
        }
    }
}