package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("baseUrl");
        String wait = ConfigReader.getProperty("implicitWait");

        if (browser == null) {
            throw new RuntimeException("browser key is missing in config.properties");
        }

        if (url == null) {
            throw new RuntimeException("baseUrl key is missing in config.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(Long.parseLong(wait)));

        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
