package state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import orange

@Composable
fun StateHW(
    text: String, date: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .width(400.dp)
                .align(alignment = Alignment.Center)
                .background(color = orange, shape = RoundedCornerShape(10.dp)),

            ) {
            Box(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        modifier = Modifier.background(color = orange),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = ("Project X"),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(Modifier.weight(30f))
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.background(color = orange),
                        tint = Color.White,
                    )
                }
                //Text()
            }
            Text(
                text = text,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 35.dp, vertical = 10.dp)
            )
            Text(
                modifier = Modifier.align(alignment = Alignment.End).padding(7.dp),
                text = date,
                color = Color.White
            )
        }
    }
}