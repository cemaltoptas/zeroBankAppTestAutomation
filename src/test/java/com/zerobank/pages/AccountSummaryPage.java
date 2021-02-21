package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountSummaryPage extends BasePage{

    /*//Links
    @FindBy(xpath = "//table//tbody/tr/td[1]/a")
    public WebElement accountLinks;

    @FindBy(xpath = "(//td/a[.='Savings'])[1]")
    public WebElement savingsLink;*/


    public void clickOnAccountLink(String linkName){

       WebElement link=Driver.get().findElement(By.xpath("//table//tbody/tr/td[1]/a[.='"+linkName+"']"));
       link.click();
    }
}
