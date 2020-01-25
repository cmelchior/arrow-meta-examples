package sample

import kotlin.test.Test
import kotlin.test.assertTrue

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