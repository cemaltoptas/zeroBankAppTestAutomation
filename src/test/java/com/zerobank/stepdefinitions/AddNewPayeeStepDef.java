package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDef {

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {

        new PayBillsPage().addNewPayee(dataTable.get("Payee Name"),
                                        dataTable.get("Payee Address"),
                                        dataTable.get("Account"),
                                        dataTable.get("Payee details"));

    }

    @Then("message The new payee {string} was successfully created.should be displayed")
    public void message_The_new_payee_was_successfully_created_should_be_displayed(String expectedTitle) {

        PayBillsPage payBillsPage = new PayBillsPage();
        String actuallTitle = payBillsPage.popUpMessage.getText();
        Assert.assertEquals(expectedTitle,actuallTitle);
    }
}
