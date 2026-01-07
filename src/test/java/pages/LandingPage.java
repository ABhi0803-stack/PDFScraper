package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By headerTitle = By.xpath("//header[normalize-space()='PDF SCRAPER']");
    private final By heroTitle = By.xpath("//h2[contains(.,'Pdf-Scraper')]");

    private final By dataScraperCard =
            By.xpath("//h3[text()='Data Scraper']");

    private final By renameEncryptCard =
            By.xpath("//h3[text()='Pdf-Renaming & Encyption']");

    private final By waterMarkCard =
            By.xpath("//h3[text()='Pdf-Water Mark']");

    private final By notificationBell = By.id("notificationBell");
    private final By notificationPanel = By.id("notificationPanel");

    private final By dataScraperHeader =
            By.xpath("//h2[contains(.,'Data Scraper')]");

    private WebElement waitFor(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void click(By locator) {
        WebElement e = waitFor(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
    }

    public boolean isHeaderDisplayed() {
        return waitFor(headerTitle).isDisplayed();
    }

    public boolean isHeroVisible() {
        return waitFor(heroTitle).isDisplayed();
    }

    public void openDataScraperFromHome() {
        click(dataScraperCard);
    }

    public void openRenameEncryptFromHome() {
        click(renameEncryptCard);
    }

    public void openWaterMarkFromHome() {
        click(waterMarkCard);
    }

    public boolean isDataScraperHeaderVisible() {
        return waitFor(dataScraperHeader).isDisplayed();
    }

    public void openNotificationPanel() {
        click(notificationBell);
    }

    public boolean isNotificationPanelDisplayed() {
        return waitFor(notificationPanel).isDisplayed();
    }
}
