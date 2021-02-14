package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
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

    public void UserLogin(){
        String username= ConfigurationReader.get("user_name");
        String password = ConfigurationReader.get("user_password");

        this.userName.sendKeys(username);
        this.userPassword.sendKeys(password);
        this.signInBtn.click();
    }
}
