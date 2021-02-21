package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage {

    //Add new Payee Tab input Locators
    //Starts
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

    //Ends
    //====================================

    //Allert pop-up message after adding payee
    @FindBy(id = "alert_content")
    public WebElement popUpMessage;

    //====================================

    //Purchase Foreign Currency  tab locators
    @FindBy(id = "pc_currency")
    public WebElement currencyDropDownList;

    //Amount input box
    @FindBy(id = "pc_amount")
    public WebElement amount;

    @FindBy(xpath = "//label[contains(@class,'radio inline')][2]")
    public WebElement checkbOXBocUSD;

    //Calculate cost button
    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostBtn;


    //=======================================================================

    //Retriving information from data table by the given feature file
    //Adding new payee
    public void addNewPayee(String payeeName, String payeeAddress,
                            String account, String payeeDetails) {
        BrowserUtils.waitFor(1);
        this.payeeNameInputBox.sendKeys(payeeName);
        this.payeeAddressInputBox.sendKeys(payeeAddress);
        this.accountInputBox.sendKeys(account);
        this.payeeDetailsInputBox.sendKeys(payeeDetails);
        addButton.click();
    }

    //Reading currency dropdown list
    public List<String> readingCurrencyList() {

        BrowserUtils.waitFor(2);

        Select dropDownList = new Select(currencyDropDownList);
        return BrowserUtils.getElementsText(dropDownList.getOptions());
    }

    public String displayingErrorMessage(){

        Alert alert = Driver.get().switchTo().alert();
        return alert.getText();
    }
}


