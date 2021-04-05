import org.junit.jupiter.api.*
import org.openqa.selenium.By


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InventoryTest() : TestCase() {

    @Test
    fun addItemToCart() {
        driver.get("https://www.saucedemo.com/v1/inventory.html")

        driver.findElement(By.cssSelector(".btn_primary")).click()

        val expected = "1"
        val actual = driver.findElement(By.cssSelector(".shopping_cart_badge")).text

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun removeItemFromCart() {
        driver.get("https://www.saucedemo.com/v1/inventory.html")

        driver.findElement(By.cssSelector(".btn_primary")).click()
        driver.findElement(By.cssSelector(".btn_secondary")).click()

        Assertions.assertTrue(driver.findElements(By.cssSelector(".shopping_cart_badge")).size == 0)
    }
}