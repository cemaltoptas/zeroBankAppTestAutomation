package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountActivityNavigationStepDef extends BasePage {



      /*  String expectedPageTitle = "Zero - Account Summary";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);*/


    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String LinkName) {
        //Click on the link by the given value
        new AccountSummaryPage().clickOnAccountLink(LinkName);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageTitle) {

        Assert.assertTrue(getPageTitle().contains(pageTitle));

    }

    @Then("Account dropdown should have {string} selected")
    public void account_dropdown_should_have_selected(String dropDownListName) {

        AccountAvtivityPage accountActivityPage = new AccountAvtivityPage();
        String actualTitle = accountActivityPage.dropDownFristListName();
        Assert.assertEquals(dropDownListName, actualTitle);
    }

}
