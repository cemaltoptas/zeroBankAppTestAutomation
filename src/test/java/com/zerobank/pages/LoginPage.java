package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#user_login")
    public WebElement userName;

    @FindBy(css = "input#user_password")
    public WebElement userPassword;

    @FindBy(xpath= "//input[@name='submit']")
    public WebElement signInBtn;

    @FindBy(css= ".alert.alert-error")
    public WebElement errorMessageForLogin;


    public void login(String username, String password){
        BrowserUtils.waitFor(2);
        this.userName.sendKeys(username);
        this.userPassword.sendKeys(password);
        signInBtn.click();
    }
}
