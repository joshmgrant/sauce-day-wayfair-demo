import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase {

    public WebDriver driver;

    @Rule
    public TestName testName = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Rule
    public SauceTestWatcher sauceTestWatcher = new SauceTestWatcher();

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    @Before
    public void setUp() {
        SauceOptions sauceOptions = new SauceOptions();
        sauceOptions.setCapability("browserName", "chrome");
        sauceOptions.setCapability("browserVersion", "latest");
        sauceOptions.setName(testName.getMethodName());
        sauceOptions.setBuild("Wayfair-Java-Example");

        SauceSession session = new SauceSession(sauceOptions);
        driver = session.start();
        sauceTestWatcher.setDriver(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}