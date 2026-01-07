package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DataScraperPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public DataScraperPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By header = By.xpath("//h2[contains(.,'Data Scraper')]");
    private final By samplefileinput = By.xpath("//input[@id='fileName']");
    private final By sampleFileBrowsebtn = By.xpath("//label[@for='fileUpload']");
    private final By sucessnotification = By.xpath("//div[contains(text(),'✓ PDF preview loaded successfully - Now select tex')]");
    private final By pdfpreview = By.xpath("//div[@class='section-title']//div[1]");
    private final By pdfwrapper = By.xpath("//div[@id='pdfContainerWrapper']");
    private final By successtoast = By.xpath("//div[@class='toast toast-success']");
    private final By editrowpanel = By.xpath("//div[@id='editableRowPanel']");
    private final By rowcolumnnumber = By.xpath("//input[@id='quickColumnNumber']");
    private final By columnNumberInput = By.xpath("//input[@id='quickColumnNumber']");
    private final By columnlabelInput = By.xpath("//input[@id='quickLabelInput']");
    private final By typeDropdown = By.xpath("//select[@id='quickTypeSelect']");
    private final By addButton = By.xpath("//button[@id='quickAddBtn']");
    private final By cancelButton = By.xpath("//button[@id='quickCancelBtn']");
    private final By toastMessagecolumn = By.xpath("//div[@class='toast-message']");
    private final By configsection = By.xpath("//div[@class='wrapper']//div[8]");
    private final By selectentity = By.xpath("//select[@id='selectEntity']");
    private final By entitytoast = By.xpath("//select[@id='selectEntity']");
    private final By createnewentity = By.xpath("//a[@id='createNewEntity']");
    private final By newentityname = By.xpath("//input[@id='swal2-input']");
    private final By newentitycreate = By.xpath("//button[normalize-space()='Create']");
    private final By newentitycancel = By.xpath("//button[contains(text(),'Cancel')]");
    private final By templatedropdown = By.xpath("//select[@id='selectTemplate']");
    private final By columnconfig = By.xpath("//div[9]");
    private final By columnNumber = By.xpath("//input[@id='ColumnNumber']");
    private final By labelName = By.xpath("//input[@id='labelInput']");
    private final By columntype = By.xpath("//select[@id='typeSelect']");
    private final By referenceindex = By.xpath("//input[@id='referenceInput']");
    private final By columnadd = By.xpath("//button[@id='addBtn']");
    private final By columntoast = By.xpath("//div[@class='toast-message']");
    private final By columndatasection = By.xpath("//div[10]");
    private final By columndatatable = By.xpath("//div[@id='dataTable_wrapper']");
    private final By sheetconfigsec = By.xpath("//div[11]");
    private final By sheetName = By.xpath("//input[@id='sheetNameInput']");
    private final By savetemplate = By.xpath("//button[@id='saveTemplate']");
    private final By savepopup = By.xpath("//div[@role='dialog']");
    private final By savetempiput = By.xpath("//input[@id='swal2-input']");
    private final By tempsave = By.xpath("//button[normalize-space()='Save']");
    private final By temcancel = By.xpath("//button[contains(text(),'Cancel')]");
    private final By tempsuccesstoast = By.xpath("//div[@class='toast toast-success']");
    private final By downloadexcel = By.xpath("//button[@id='downloadExcelBtn']");
    private final By bulkuplaodsec = By.xpath("//div[@class='wrapper']//div[7]");
    private final By multifileup = By.xpath("//label[@for='multipleFileUpload']");
    private final By filegeneration = By.xpath("//div[normalize-space()='File generation started. Check the bell icon for progress!']");
    private final By notifcationbadge = By.xpath("//span[@id='notificationBadge']");
    private final By notifbell = By.xpath("//i[@class='fas fa-bell']");
    private final By notifcationlist = By.xpath("//div[@id='notificationList']");
    private final By finalFiledownlaod = By.xpath("//button[@class='notification-download-btn']");
    private final By downlaodedstarttoast = By.xpath("//div[@class='toast-message']");

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
        WebElement el = visible(locator);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
        } catch (Exception ex) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", el);
        }
    }

    private void type(By locator, String value) {
        scrollTo(locator);
        WebElement el = visible(locator);
        el.clear();
        el.sendKeys(value);
    }

    private void uploadUsingRobot(String path) throws Exception {

        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.setAutoDelay(500);

        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        robot.setAutoDelay(400);

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_ALT);

        robot.setAutoDelay(400);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.setAutoDelay(400);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public boolean isLoaded() {
        return visible(header).isDisplayed();
    }

    public void uploadSamplePdf(String path) throws Exception {
        scrollTo(sampleFileBrowsebtn);
        click(sampleFileBrowsebtn);
        uploadUsingRobot(path);
        visible(sucessnotification);
    }

    public void uploadMultiplePdf(String path) throws Exception {
        scrollTo(bulkuplaodsec);
        click(multifileup);
        uploadUsingRobot(path);
        visible(pdfwrapper);
    }

    public void selectWordAndCreateColumn() {
    	scrollTo(bulkuplaodsec);
        visible(editrowpanel);
        click(addButton);
        visible(toastMessagecolumn);
    }

    public void chooseEntity(String text) {
        scrollTo(configsection);
        new Select(visible(selectentity)).selectByVisibleText(text);
        visible(entitytoast);
    }

    public void chooseTemplate(String text) {
        scrollTo(templatedropdown);
        new Select(visible(templatedropdown)).selectByVisibleText(text);
    }

    public void configureColumn(String num, String label, String type, String ref) {
        scrollTo(columnconfig);
        type(columnNumber, num);
        type(labelName, label);
        new Select(visible(columntype)).selectByVisibleText(type);
        type(referenceindex, ref);
        click(columnadd);
        visible(columntoast);
    }

    public void verifyColumnTable() {
        scrollTo(columndatasection);
        visible(columndatatable);
    }

    public void setSheetName(String name) {
        scrollTo(sheetconfigsec);
        type(sheetName, name);
    }

    public void saveTemplateFlow(String name) {
        click(savetemplate);
        visible(savepopup);
        type(savetempiput, name);
        click(tempsave);
        visible(tempsuccesstoast);
    }

    public void startExcelDownload() {
        click(downloadexcel);
        visible(filegeneration);
    }

    public void openNotificationPanel() {
        scrollTo(header);
        click(notifbell);
        visible(notifcationlist);
    }

    public void downloadGeneratedFile() {
        click(finalFiledownlaod);
        visible(downlaodedstarttoast);
    }
}
