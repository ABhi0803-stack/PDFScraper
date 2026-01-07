package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String folderPath = "target/extent-reports";
            String reportPath = folderPath + "/ExtentReport.html";

            
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println(">>> Created report folder: " + folder.getAbsolutePath());
            }

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "PDF Scraper");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
