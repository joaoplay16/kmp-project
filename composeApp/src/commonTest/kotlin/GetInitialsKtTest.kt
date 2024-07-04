import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class GetInitialsKtTest {
    @Test
    fun testGetInitials() {
        val fullName = "Joao Pedro"

        assertThat(getInitials(fullName)).isEqualTo("JP")
    }
}