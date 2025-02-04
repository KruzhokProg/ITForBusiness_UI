import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val tags = listOf(
    "City Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deals",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support"
)

data class Offer(
    val iconPath: String,
    val label: String
)

val offers = listOf(
    Offer(iconPath = "drawable/bed.xml", label = "Bed"),
    Offer(iconPath = "drawable/breakfast.xml", label = "Breakfast"),
    Offer(iconPath = "drawable/cutlery.xml", label = "Cutlery"),
    Offer(iconPath = "drawable/pawprint.xml", label = "Friendly"),
    Offer(iconPath = "drawable/serving_dish.xml", label = "Dinner"),
    Offer(iconPath = "drawable/snowflake.xml", label = "Air Conditioning"),
    Offer(iconPath = "drawable/television.xml", label = "TV"),
    Offer(iconPath = "drawable/wi_fi_icon.xml", label = "Wifi"),
)

//val offers = mapOf(
//    "drawable/bed.xml" to "2 Bed",
//    "drawable/breakfast.xml" to "Breakfast",
//    "drawable/cutlery.xml" to "Cutlery",
//    "drawable/pawprint.xml" to "Pet Friendly",
//    "drawable/serving_dish.xml" to "Dinner",
//    "drawable/snowflake.xml" to "Air Conditioning",
//    "drawable/television.xml" to "TV",
//    "drawable/wi_fi_icon.xml" to "Wifi"
//)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box {
                Image(
                    painter = painterResource("drawable/living_room.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
                FadedBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = Color.Gray
            )
        }
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                tags.forEach { tag ->
                    Chip(
                        text = tag
                    )
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = Color.Gray
            )
        }
        item {
            Text(
                text = "he advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park and stunning beaches, the hotel is perfectly located for guests to explore L.A.'s best attractions.",
                fontSize = 13.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify
            )
        }
        item {
            Text(
                text = "What we offer",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                items(offers) { offer ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(offer.iconPath),
                            contentDescription = null,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = offer.label,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
        item {
            Button(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(
                        max = 400.dp
                    )
                    .fillMaxWidth()
            ) {
                Text(text = "Book Now!")
            }
        }
    }
}

@Composable
fun Chip(
    text: String
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
//            .clickable {
//
//            }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 15.dp, vertical = 10.dp)
        )
    }
}

@Composable
fun FadedBanner(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            LabeledIcon(
                text = "Los Angeles, California",
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }

            )
            LabeledIcon(
                text = "4.9 (13K reviews)",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }
            )
        }
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                ) {
                    append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                ) {
                    append("night")
                }
            }
        )
    }
}

@Composable
fun LabeledIcon(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontSize = 13.sp
        )
    }
}