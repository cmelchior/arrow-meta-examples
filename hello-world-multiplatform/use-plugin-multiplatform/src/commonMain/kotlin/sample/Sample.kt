package sample

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun helloFromActualPlatform(): String = "Hello from ${Platform.name}"
fun helloFromArrowMeta(): String = TODO()