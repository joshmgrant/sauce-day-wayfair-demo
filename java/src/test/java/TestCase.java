import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase {

    protected WebDriver driver;

    @Rule
    public TestName testName = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Rule
    public SauceTestWatcher sauceTestWatcher = new SauceTestWatcher();

    @Before
    public void setUp() {
        SauceOptions sauceOptions = new SauceOptions();
        sauceOptions.setCapability("browserName", "chrome");
        sauceOptions.setCapability("browserVersion", "latest");
        sauceOptions.setName(testName.getMethodName());
        sauceOptions.setBuild("Wayfair-Java-Example");

        SauceSession session = new SauceSession(sauceOptions);
        driver = session.start();
    }

    public class SauceTestWatcher extends TestWatcher {
        @Override
        protected void succeeded(Description description) {
            if (driver != null) {
                ((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
                driver.quit();
            }
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            if (driver != null) {
                ((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
                driver.quit();
            }
            super.failed(e, description);
        }
    }

}