package sample

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class SampleTestsAndroid {
    @Test
    fun testHelloFromPlatform() {
        assertEquals("Hello from Android", helloFromActualPlatform())
    }

    @Test
    fun testHelloFromArrowMeta() {
        assertEquals("Hello from ΛRROW Meta!", helloFromArrowMeta())
    }
}