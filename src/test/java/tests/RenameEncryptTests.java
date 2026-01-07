package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RenameEncryptPage;

public class RenameEncryptTests extends BaseTest {

    @Test(priority = 1)
    public void rename_encrypt_end_to_end() throws Exception {

        LandingPage lp = new LandingPage(getDriver());
        lp.openRenameEncryptFromHome();

        RenameEncryptPage re = new RenameEncryptPage(getDriver());
        Assert.assertTrue(re.isLoaded(), "Rename/Encrypt page not loaded");

        String path = "C:\\Users\\cool\\Downloads\\file-sample_150kB.pdf";

        re.uploadMainPdf(path);


        re.uploadPreviewPdf(path);

        re.setColumnLabel("Invoice No");
        re.setReference("Line 1");

        re.downloadExcelFile();
    }
}
