import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class GetStringLengthKtTest {

    @Test
    fun testGetStringLength() {
        assertThat(getStringLength("ABC")).isEqualTo(3)
    }

}