package Navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

enum class Screen(
    val label: String,
) {
    MAIN("Главная"),
    PROFILE("Профиль")
}

class NavController(startDestination: Screen) {
    private var backStackScreens = mutableListOf<Screen>()
    var currentScreen: MutableState<Screen> = mutableStateOf(startDestination)

    fun navigate(route: Screen) {
        if (route != currentScreen.value) {
            backStackScreens += currentScreen.value
            currentScreen.value = route
        }
    }

    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            currentScreen.value = backStackScreens.removeLast()
        }
    }
}