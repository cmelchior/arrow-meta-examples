package sample

actual class Sample {
    actual fun checkMe() = 9
}

actual object Platform {
    actual val name: String = "Native - iOS"
}