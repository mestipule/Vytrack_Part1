package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.page.StoreManagerDashboard;
import com.vytrack.page.UserDashboard;
import com.vytrack.page.LoginPage;
import com.vytrack.utilites.ConfigurationReader;
import com.vytrack.utilites.Driver;
import com.vytrack.utilites.Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Menu_Options_Tests extends TestBase{
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 5);
    Methods methods = new Methods();
    LoginPage loginPage = new LoginPage();
    UserDashboard dashboard = new UserDashboard();
    StoreManagerDashboard managerDashboard = new StoreManagerDashboard();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    @Test
    public void loginPage() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//        1. LoginPage to Vytrack as a driver



//        2. Navigate to Fleet à Vehicles, verify page title Car - Entities - System - Car - Entities -
//                System, page name Cars

        /*

            here i created a LoginPage class for locators
        */


        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
        System.out.println("login done");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(dashboard.fleet));

            /*
                action class is a class that has method that helps us

                    hover, it also has a method that sync which pause
                    and click method.

                    the click method finds the element and click at
                    at the same time
            */
        actions.
                moveToElement(dashboard.fleet).
                pause(2000).
                click(dashboard.vehicle).
                build().perform();

        System.out.println("vehicle clicked");

        webDriverWait.until(ExpectedConditions.titleIs("Car - Entities - System - Car - Entities - System"));
        String expectedTitleCar = "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(driver.getTitle(), expectedTitleCar);

////        3. Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page
////        name Accounts

//        WebElement accounts = driver.findElement(By.xpath("//li[@data-route='oro_account_index']/a[@href='/account']"));
        actions.
                moveToElement(dashboard.customer).
                pause(2000).
                click(dashboard.accounts).
                build().perform();

        System.out.println("accounts shown");

        webDriverWait.until(ExpectedConditions.titleIs("Accounts - Customers"));
        String titleIs = "Accounts - Customers";
        Assert.assertEquals(titleIs, driver.getTitle());
//
//
////        4. Navigate to Customers à Contacts, verify page title Contacts - Customers, verify page name
////        Contacts

        actions.
                moveToElement(dashboard.customer).
                pause(2000).
                click(dashboard.contacts).
                build().perform();

        webDriverWait.until(ExpectedConditions.titleIs("Contacts - Customers"));
        titleIs = "Contacts - Customers";
        Assert.assertEquals(titleIs, driver.getTitle());

////        5. Navigate to Activities à Calendar Events, verify page title Calendar Events - Activities, page
////        name Calendar Events


        js.executeScript("arguments[0].click();", dashboard.eventCalendar);

        webDriverWait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        titleIs = "Calendar Events - Activities";
        Assert.assertEquals(titleIs, driver.getTitle());
        System.out.println("title");

    }
    @Test
    public void storeManagerTest() {

//            TEST CASE: Menu options, store manager
//            1. LoginPage to Vytrack as a store manager

            loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));


//            2. Navigate to Dashboards à UserDashboard, verify page title UserDashboard - Dashboards, verify
//            page name UserDashboard
            webDriverWait.until(ExpectedConditions.titleIs("Dashboard"));

            actions.
                    moveToElement(managerDashboard.dashboard).
                    pause(2000).
                    moveToElement(managerDashboard.dashboard2).click().
                    build().perform();



            webDriverWait.until(ExpectedConditions.titleIs("Dashboard - Dashboards"));
            String titleIs = "Dashboard - Dashboards";
            assertEquals(titleIs, driver.getTitle());

//            3. Navigate to Fleet à Vehicles, verify page title All - Car - Entities - System - Car - Entities -
//            System, page name All Cars

            actions.
                    moveToElement(managerDashboard.fleet).
                    pause(2000).
                    moveToElement(managerDashboard.vehicle).
                    click().build().perform();

        webDriverWait.until(ExpectedConditions.titleIs("All - Car - Entities - System - Car - Entities - System"));
        titleIs = "All - Car - Entities - System - Car - Entities - System";
        assertEquals(titleIs, Driver.getDriver().getTitle());
//            4. Navigate to Customers à Accounts, verify page title All - Accounts – Customers, verify
//            page name All Accounts


//            5. Navigate to Customers à Contacts, verify page title All - Contacts - Customers, verify page
//            name All Contacts
//            6. Navigate to Sales à Opportunities, verify page title Open Opportunities - Opportunities -
//            Sales, verify page name Open Opportunities
//            7. Navigate to Activities à Calls verify page title All - Calls - Activities, page name All Calls
//            8. Navigate to Activities à Calendar Events, verify page title Calendar Events - Activities, page
//            name All Calendar Events
//
    }
}
