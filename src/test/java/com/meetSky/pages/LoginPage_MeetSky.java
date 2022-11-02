package com.meetSky.pages;

import com.meetSky.utilities.ConfigurationReader;
import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_MeetSky {

    public LoginPage_MeetSky(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    public void loginWithConfig(){
        usernameInput.sendKeys(ConfigurationReader.getProperty("meetsky.username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("meetsky.password"));
        loginButton.click();
    }

    @FindBy(xpath = "//a[@href='/index.php/apps/files/']")
    public WebElement filesButton;

}
