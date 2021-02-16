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

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created.should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        String expectedTitle="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actuallTitle = payBillsPage.popUpMessage.getText();
        Assert.assertEquals(expectedTitle,actuallTitle);
    }


}