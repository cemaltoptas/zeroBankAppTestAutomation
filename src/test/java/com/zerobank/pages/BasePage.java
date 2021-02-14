package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//li[contains(@id,'_tab')]")
    public List<WebElement> menuOptions;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getPageTitle() {
        BrowserUtils.waitFor(3);
        String actualTtitle = Driver.get().getTitle();
        return actualTtitle;

    }

    public void navigateModule(String linkText){

        WebElement module =Driver.get().findElement(By.xpath("//li[.='"+linkText+"']"));
        module.click();


    }

}
