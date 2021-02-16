package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountAvtivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;


public class FindTransactionStepsDef extends BasePage {

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String link) {
        new DashBoardPage().navigateModule(link);
    }

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tabName) {
        AccountAvtivityPage accountAvtivityPage = new AccountAvtivityPage();
        accountAvtivityPage.navigateToTabMenu(tabName);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        new AccountAvtivityPage().inputDatesFromTo(fromDate, toDate);
    }

    @When("clicks search")
    public void clicks_search() {

        new AccountAvtivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        //Verifying dates with the table results
        new AccountAvtivityPage().verifyingDatesWithTableResults(fromDate, toDate);

        /*//Printing table to verify
        List<String> elementsText = BrowserUtils.getElementsText(new AccountAvtivityPage().findTableResult);
        for (String s : elementsText) {
            System.out.println(s);*/

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> list = BrowserUtils.getElementsText(new AccountAvtivityPage().dateTableResult);
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i + 1)) >= 0);
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String dateNotContain) throws ParseException {

        new AccountAvtivityPage().verifyingDatesWithTableResults(dateNotContain);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {

        new AccountAvtivityPage().inputDescription(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String descriptionWord) {

        new AccountAvtivityPage().verifyingDescriptionWithTableResults(descriptionWord);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

        BrowserUtils.waitFor(2);
        int counter = 0;
        List<String> depositColumn = BrowserUtils.getElementsText(new AccountAvtivityPage().depositeTableResult);
        for (String s : depositColumn) {

            if (!s.isEmpty()) {
                counter++;
            }
        }
        Assert.assertTrue(counter != 0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        int counter = 0;
        List<String> depositColumn = BrowserUtils.getElementsText(new AccountAvtivityPage().withdrawalTableResult);
        for (String s : depositColumn) {

            if (!s.isEmpty()) {
                counter++;
            }
        }
        Assert.assertTrue(counter != 0);

    }

    @When("user selects type {string}")
    public void user_selects_type(String typeValue) {
        AccountAvtivityPage accountAvtivityPage = new AccountAvtivityPage();
        accountAvtivityPage.selectType(typeValue);
        accountAvtivityPage.findButton.click();

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        int counter = 0;
        List<String> depositColumn = BrowserUtils.getElementsText(new AccountAvtivityPage().withdrawalTableResult);
        for (String s : depositColumn) {

            if (!s.isEmpty()) {
                counter++;
            }
        }

        Assert.assertTrue(counter == 0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        int counter = 0;
        List<String> depositColumn = BrowserUtils.getElementsText(new AccountAvtivityPage().depositeTableResult);
        for (String s : depositColumn) {

            if (!s.isEmpty()) {
                counter++;
            }
        }

        Assert.assertTrue(counter == 0);
    }
}
