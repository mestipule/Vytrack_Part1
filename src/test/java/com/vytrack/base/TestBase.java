package com.vytrack.base;

import com.vytrack.utilites.ConfigurationReader;
import com.vytrack.utilites.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
//
        String url = ConfigurationReader.getProperty("url");
        driver = Driver.getDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }
    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
