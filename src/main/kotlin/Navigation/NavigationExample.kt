package Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun NavigationExample() {
    val navController = remember { NavController(Screen.MAIN) }
    val currentScreen = remember { navController.currentScreen }

    NavigationHost(currentScreen.value, navController)
}