package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountAvtivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
