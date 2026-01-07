package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RenameEncryptPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RenameEncryptPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    private final By header     = By.xpath("//h2[contains(.,'Rename') or contains(.,'Encrypt')]");
    private final By uploadBtn  = By.xpath("//label[@for='fileUpload']");
    private final By pdfFor     = By.xpath("//select[@id='pdfFor']");
    private final By basedOn    = By.xpath("//select[@id='basedOn']");
    private final By previewBtn = By.xpath("//label[@for='previewUpload']");

    private final By columnLabel = By.xpath("//input[@id='labelInput']");
    private final By typeDropdown = By.xpath("//select[@id='typeSelect']");
    private final By referenceInput = By.xpath("//input[@id='referenceInput']");

    private final By downloadExcel = By.xpath("//button[@id='downloadExcelBtn']");

    private WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void scrollTo(By locator) {
        WebElement el = visible(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
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

    public void uploadMainPdf(String path) throws Exception {
        click(uploadBtn);
        robotUpload(path);
    }

    public void choosePdfForIfNeeded(String value) {
        scrollTo(pdfFor);
        new Select(visible(pdfFor)).selectByVisibleText(value);
    }

    public void chooseBasedOnIfNeeded(String value) {
        scrollTo(basedOn);
        new Select(visible(basedOn)).selectByVisibleText(value);
    }

    public void uploadPreviewPdf(String path) throws Exception {
        click(previewBtn);
        robotUpload(path);
    }

    public void setColumnLabel(String text) {
        type(columnLabel, text);
    }

    public void setReference(String text) {
        type(referenceInput, text);
    }

    public void downloadExcelFile() {
        click(downloadExcel);
    }
}
