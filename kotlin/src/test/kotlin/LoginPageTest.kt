import org.junit.jupiter.api.*
import org.openqa.selenium.By


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginPageTest() : TestCase() {

    @Test
    fun loginToSwagLabs() {
        driver.get("https://www.saucedemo.com/v1/")

        driver.findElement(By.id("user-name")).sendKeys("standard_user")
        driver.findElement(By.id("password")).sendKeys("secret_sauce")
        driver.findElement(By.id("login-button")).click()

        Assertions.assertTrue("inventory" in driver.currentUrl, "Did not log into Swag Labs")
    }

    @Test
    fun invalidLogin() {
        driver.get("https://www.saucedemo.com/v1/")

        driver.findElement(By.id("user-name")).sendKeys("bad")
        driver.findElement(By.id("password")).sendKeys("bad")
        driver.findElement(By.id("login-button")).click()

        Assertions.assertTrue(driver.findElement(By.cssSelector(".error-button")).isDisplayed)
    }


}