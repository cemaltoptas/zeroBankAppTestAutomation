package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyOptions) {

        BrowserUtils.waitFor(2);
        PayBillsPage payBillsPage = new PayBillsPage();

        Assert.assertEquals(currencyOptions, payBillsPage.readingCurrencyList());
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("500");
        payBillsPage.calculateCostBtn.click();


    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        PayBillsPage payBillsPage = new PayBillsPage();
        String expectedErrorMessage = "Please, ensure that you have filled all the required fields with valid values.";

        Assert.assertEquals(expectedErrorMessage,payBillsPage.displayingErrorMessage());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.checkbOXBocUSD.click();
        payBillsPage.calculateCostBtn.click();


    }
}
