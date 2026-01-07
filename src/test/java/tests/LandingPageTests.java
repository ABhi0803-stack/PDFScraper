package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LandingPage;

public class LandingPageTests extends BaseTest {

    @Test(priority = 1)
    public void verifyLandingPageHeaderVisible() {
        LandingPage lp = new LandingPage(getDriver());
        Assert.assertTrue(lp.isHeaderDisplayed(), "Header is not displayed");
    }

    @Test(priority = 2)
    public void verifyHeroSectionVisible() {
        LandingPage lp = new LandingPage(getDriver());
        Assert.assertTrue(lp.isHeroVisible(), "Hero section not visible");
    }

    @Test(priority = 3)
    public void verifyOpenDataScraperFromHome() {
        LandingPage lp = new LandingPage(getDriver());
        lp.openDataScraperFromHome();

        Assert.assertTrue(lp.isDataScraperHeaderVisible(),
                "Data Scraper page did not open");

        getDriver().navigate().back();
    }

    @Test(priority = 4)
    public void verifyOpenRenameEncryptFromHome() {
        LandingPage lp = new LandingPage(getDriver());
        lp.openRenameEncryptFromHome();

        Assert.assertTrue(getDriver().getCurrentUrl().toLowerCase().contains("rename"),
                "Rename / Encrypt page not opened");

        getDriver().navigate().back();
    }

    @Test(priority = 5)
    public void verifyOpenWaterMarkFromHome() {
        LandingPage lp = new LandingPage(getDriver());
        lp.openWaterMarkFromHome();

        Assert.assertTrue(getDriver().getCurrentUrl().toLowerCase().contains("water"),
                "Watermark page not opened");

        getDriver().navigate().back();
    }

    @Test(priority = 6)
    public void verifyNotificationPanelOpens() {
        LandingPage lp = new LandingPage(getDriver());
        lp.openNotificationPanel();

        Assert.assertTrue(lp.isNotificationPanelDisplayed(),
                "Notification panel not visible");
    }
}
