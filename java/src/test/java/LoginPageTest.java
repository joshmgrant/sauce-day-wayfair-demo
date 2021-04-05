import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginPageTest extends TestCase {

    @Test
    public void loginToSwagLabs() {
        driver.get("https://www.saucedemo.com/v1/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLogin() {
        driver.get("https://www.saucedemo.com/v1/");

        driver.findElement(By.id("user-name")).sendKeys("bad");
        driver.findElement(By.id("password")).sendKeys("bad");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error-button")).isDisplayed());
    }
}
