import org.junit.Assert;
import org.junit.Test;

public class BasicTest extends TestCase {

    @Test
    public void visitSwagLabs() {
        driver.get("https://www.saucedemo.com/v1/");

        Assert.assertTrue(driver.getTitle().contains("Swag"));
    }
}
