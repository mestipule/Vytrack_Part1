package com.vytrack.base;

import com.vytrack.utilites.ConfigurationReader;
import com.vytrack.utilites.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;
//    WebDriverWait wait;
//
    @BeforeMethod
    public void setUp() {
//        wait = new WebDriverWait(driver, 3);
        String url = ConfigurationReader.getProperty("url");
        driver = Driver.getDriver();
        driver.get(url);
    }
    @AfterMethod
    public void tearDown() {
        Driver.getDriver();
    }
}
