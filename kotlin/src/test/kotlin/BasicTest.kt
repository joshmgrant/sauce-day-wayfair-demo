import org.junit.jupiter.api.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTest() : TestCase() {

    @Test
    fun visitSwagLabs() {
        driver.get("https://www.saucedemo.com/v1/")

        Assertions.assertTrue(("Swag") in driver.title, "Incorrect page title")
    }
}