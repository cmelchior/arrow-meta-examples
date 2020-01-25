package sample

import kotlin.test.Test
import kotlin.test.assertEquals

class SampleTestsJS {
    @Test
    fun testHelloFromPlatform() {
        assertEquals("Hello from JS", helloFromActualPlatform())
    }

    @Test
    fun testHelloFromArrowMeta() {
        assertEquals("Hello from ΛRROW Meta!", helloFromArrowMeta())
    }
}