package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends  BasePage{

    //Add new Payee Tab input Locators
    //====================================
    //Payee Name inputbox locator
    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    //Payee Addres inputbox locator
    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBox;

    //Account inputbox locator
    @FindBy(id = "np_new_payee_account")
    public WebElement accountInputBox;

    //Payye details inputbox locator
    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    //Add button locator
    @FindBy(id = "add_new_payee")
    public WebElement addButton;
    //====================================


    //Retriving informations from data table by the given feature file
    //Adding new payee
    public void addNewPayee(String payeeName,String payeeAddress,
                            String account, String payeeDetails ){
        BrowserUtils.waitFor(1);
        this.payeeNameInputBox.sendKeys(payeeName);
        this.payeeAddressInputBox.sendKeys(payeeAddress);
        this.accountInputBox.sendKeys(account);
        this.payeeDetailsInputBox.sendKeys(payeeDetails);
        addButton.click();

    }
}
