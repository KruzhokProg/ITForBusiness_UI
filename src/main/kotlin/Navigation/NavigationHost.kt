package Navigation

import androidx.compose.runtime.Composable

@Composable
fun NavigationHost(
    currentScreen: Screen,
    navController: NavController
) {
    when(currentScreen) {
        Screen.MAIN -> HomeScreen(navController)
        Screen.PROFILE -> ProfileScreen(navController)
    }
}