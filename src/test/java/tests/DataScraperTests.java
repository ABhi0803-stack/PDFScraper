package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DataScraperPage;
import pages.LandingPage;

public class DataScraperTests extends BaseTest {

	@Test(priority = 1)
	public void complete_End_To_End_DataScraper_Flow() throws Exception {

		LandingPage lp = new LandingPage(getDriver());

		// 1) Open Data Scraper from home
		lp.openDataScraperFromHome();

		DataScraperPage ds = new DataScraperPage(getDriver());
		Assert.assertTrue(ds.isLoaded(), "Data Scraper page not loaded");

		String pdfPath = "C:\\Users\\cool\\Downloads\\file-sample_150kB.pdf";

		ds.uploadSamplePdf(pdfPath);

		ds.uploadMultiplePdf(pdfPath);

		ds.selectWordAndCreateColumn();

		ds.chooseEntity("Entity 1");

		ds.chooseTemplate("Template 1");

		ds.configureColumn("1", "Invoice No", "Normal-1", "Line 2");

		ds.verifyColumnTable();

		ds.setSheetName("MySheet");
		ds.saveTemplateFlow("My Template Name");

		ds.startExcelDownload();

		ds.openNotificationPanel();

		ds.downloadGeneratedFile();
	}
}
