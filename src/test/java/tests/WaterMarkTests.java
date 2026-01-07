package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.WaterMarkPage;

public class WaterMarkTests extends BaseTest {

    @Test(priority = 1)
    public void watermark_end_to_end() throws Exception {

        LandingPage lp = new LandingPage(getDriver());
        lp.openWaterMarkFromHome();

        WaterMarkPage wm = new WaterMarkPage(getDriver());
        Assert.assertTrue(wm.isLoaded(), "WaterMark page not loaded");

        String path = "C:\\Users\\cool\\Downloads\\file-sample_150kB.pdf";

        wm.uploadMainFile(path);
        wm.uploadPasswordFile(path);
        wm.uploadSampleWatermark(path);

        wm.configureWatermark("CONFIDENTIAL", "1-3");

        wm.generate();
    }
}
