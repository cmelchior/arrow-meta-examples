package sample

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SampleTestsNative {
    @Test
    fun testHelloFromPlatform() {
        assertEquals("Hello from Native", helloFromActualPlatform())
    }

    @Test
    fun testHelloFromArrowMeta() {
        assertEquals("Hello from ΛRROW Meta!", helloFromArrowMeta())
    }
}