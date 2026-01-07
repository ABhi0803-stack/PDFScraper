package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class WaterMarkPage {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public WaterMarkPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	}

	private final By header = By.xpath("//h2[contains(.,'Water') or contains(.,'Mark')]");

	private final By uploadFileBtn = By.xpath("//label[@for='fileUpload']");

	private final By passwordUploadBtn = By.xpath("//label[@for='passwordFileUpload']");

	private final By sampleWatermarkBtn = By.xpath("//label[@for='sampleWatermarkUpload']");

	private final By watermarkText = By.xpath("//input[@id='watermarkText']");
	private final By watermarkPages = By.xpath("//input[@id='pageNumbers']");

	private final By generateBtn = By.xpath("//button[@id='generateBtn']");

	private WebElement visible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private void scrollTo(By locator) {
		WebElement el = visible(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
	}

	private void click(By locator) {
		scrollTo(locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	private void type(By locator, String value) {
		scrollTo(locator);
		WebElement el = visible(locator);
		el.clear();
		el.sendKeys(value);
	}

	private void robotUpload(String path) throws Exception {
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.setAutoDelay(400);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean isLoaded() {
		return visible(header).isDisplayed();
	}

	public void uploadMainFile(String path) throws Exception {
		click(uploadFileBtn);
		robotUpload(path);
	}

	public void uploadPasswordFile(String path) throws Exception {
		click(passwordUploadBtn);
		robotUpload(path);
	}

	public void uploadSampleWatermark(String path) throws Exception {
		click(sampleWatermarkBtn);
		robotUpload(path);
	}

	public void configureWatermark(String text, String pages) {
		type(watermarkText, text);
		type(watermarkPages, pages);
	}

	public void generate() {
		click(generateBtn);
	}
}
