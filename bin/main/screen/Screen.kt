package screen

sealed class Screen {
    object LoginScreen : Screen()

    object RegisterScreen : Screen()
    object MainScreen : Screen()
}