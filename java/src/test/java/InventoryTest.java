import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class InventoryTest extends TestCase {

    @Test
    public void addItemToCart() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        driver.findElement(By.cssSelector(".btn_primary")).click();

        String expected = "1";
        String actual = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeItemFromCart() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        driver.findElement(By.cssSelector(".btn_primary")).click();
        driver.findElement(By.cssSelector(".btn_secondary")).click();

        Assert.assertTrue(driver.findElements(By.cssSelector(".shopping_cart_badge")).size() == 0);
    }
}
