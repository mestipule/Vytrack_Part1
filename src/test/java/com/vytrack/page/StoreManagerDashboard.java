package com.vytrack.page;

import com.vytrack.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class StoreManagerDashboard {
    public StoreManagerDashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='main-menu']/ul/li[1]/a/span")
    public WebElement dashboard;

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown-menu-single-item first']/a/span[text()='Dashboard']")
    public WebElement dashboard2;

    @FindBy(how = How.XPATH, using = "//*[@class='dropdown dropdown-level-1']")
    public WebElement fleet;

    @FindBy(how =  How.XPATH, using = "//*[@class='dropdown-menu-single-item first']/a/span[@class='title title-level-2'][text()='Vehicles']")
    public WebElement vehicle;

    @FindBy(how = How.XPATH, using = "//*[@class='title title-level-1']/i[@class='fa-users menu-icon']")
    public WebElement customer;

//    @FindBy(how = How.XPATH, using = "")
}
