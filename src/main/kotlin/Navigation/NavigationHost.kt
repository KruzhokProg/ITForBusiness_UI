package Navigation

import androidx.compose.runtime.Composable
import kval_otbor.Screen
import kval_otbor.Screen2

@Composable
fun NavigationHost(
    currentScreen: Screen,
    navController: NavController
) {
    when(currentScreen) {
        Screen.MAIN -> Screen(navController)//HomeScreen(navController)
        Screen.PROFILE -> Screen2(navController)//ProfileScreen(navController)
    }
}