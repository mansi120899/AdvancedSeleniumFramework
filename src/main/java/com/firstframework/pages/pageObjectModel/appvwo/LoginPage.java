package com.firstframework.pages.pageObjectModel.appvwo;

import com.firstframework.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.sql.DriverManager.getDriver;

// Page Class
public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // Step 2 - Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd)
    {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.waitJVM(5000);
        //WaitHelpers.checkVisibility(driver,error_message);
        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;
    }

    public void loginToVWOLoginValidCreds(String user, String pwd)
    {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.waitJVM(5000);
    }
}
