package com.vytrack.page;

import com.vytrack.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard {
    public UserDashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Fleet")
    public WebElement fleet;

    @FindBy(how = How.XPATH, using = "//span[@class='title title-level-2'][1]")
    public WebElement vehicle;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a")
    public WebElement customer;

    @FindBy(how = How.XPATH, using = "//li[@data-route='oro_account_index']/a[@href='/account']")
    public WebElement accounts;

    @FindBy(how = How.XPATH, using = "//li[@data-route='oro_contact_index']/a[@href='/contact']/span[@class='title title-level-2']")
    public WebElement contacts;

    @FindBy(how = How.CSS, using = ".dropdown.dropdown-level-1>.unclickable>.title.title-level-1>.fa-puzzle-piece.menu-icon")
    public WebElement activities;

    @FindBy(how = How.XPATH, using = "//ul/li[3][@data-route='oro_calendar_event_index']/a")
    public WebElement eventCalendar;
}
