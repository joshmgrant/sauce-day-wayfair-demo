import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL


open class TestCase {

    protected lateinit var driver: WebDriver
    protected lateinit var js: JavascriptExecutor

    class SauceTestWatcher : TestWatcher {

        public override fun testSuccessful(context: ExtensionContext?) {
            js.execute()
        }
    }

    @BeforeEach
    fun setUp(info: TestInfo) {
        val sauceOptions = MutableCapabilities()
        val browserOptions = ChromeOptions()

        browserOptions.setCapability("platformName", "Windows 10")
        browserOptions.setCapability("browserVersion", "latest")
        sauceOptions.setCapability("name", info.displayName.toString())
        sauceOptions.setCapability("build", "Kotlin-Wayfair-Example")
        browserOptions.setCapability("sauce:options", sauceOptions)

        val username = System.getenv("SAUCE_USERNAME")
        val accessKey = System.getenv("SAUCE_ACCESS_KEY")
        val url = "https://$username:$accessKey@ondemand.us-west-1.saucelabs.com/wd/hub/"

        val remoteUrl = URL(url)

        driver = RemoteWebDriver(remoteUrl, browserOptions)
    }

    @AfterEach
    fun tearDown() {
        js = driver as JavascriptExecutor
        driver.quit()
    }
}