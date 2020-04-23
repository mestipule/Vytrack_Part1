package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilites.ConfigurationReader;
import com.vytrack.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Menu_Options_Tests extends TestBase{

    /*
        TEST CASE: Menu options, driver
        1. Login to Vytrack as a driver
        2. Navigate to Fleet à Vehicles, verify page title Car - Entities - System - Car - Entities -
        System, page name Cars
        3. Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page
        name Accounts
        4. Navigate to Customers à Contacts, verify page title Contacts - Customers, verify page name
        Contacts
        5. Navigate to Activities à Calendar Events, verify page title Calendar Events - Activities, page
        name Calendar Events
    */
    @Test
    public void loginPage() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.titleIs("Login"));
        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));
        user.sendKeys(ConfigurationReader.getProperty("driver_username"));
        password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        WebElement account = driver.findElement(By.id("_submit"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(account));
        account.click();

        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][1]"));
        fleet.click();
        WebElement vehicle = driver.findElement(By.xpath("//span[@class='title title-level-2'][1]"));
        vehicle.click();

       webDriverWait.until(ExpectedConditions.titleIs("Car - Entities - System - Car - Entities - System"));
        String expectedTitleCar = "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(driver.getTitle(), expectedTitleCar);

        WebElement customer = driver.findElement(By.xpath("//a/span[@class='title title-level-1']/i[@class='fa-users menu-icon']"));

    }

}
