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
		
		if(browser.equalsIgnoreCase("chrome")) {
			setDriver(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("edge")) {
			setDriver(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));
		getDriver().get(ConfigReader.getProperty("baseUrl"));
			
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
