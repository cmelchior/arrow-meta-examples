package sample

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SampleTestsJVM {
    @Test
    fun testHelloFromPlatform() {
        assertEquals("Hello from JVM", helloFromActualPlatform())
    }

    @Test
    fun testHelloFromArrowMeta() {
        assertEquals("Hello from ΛRROW Meta!", helloFromArrowMeta())
    }
}