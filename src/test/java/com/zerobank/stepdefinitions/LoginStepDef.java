package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class LoginStepDef extends BasePage {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().findElement(By.id("signin_button")).click();
    }

    //Positive scenario
    @When("the user enters username and password")
    public void the_user_enters_username_and_password(Map<String, String> userInfo) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(userInfo.get("userName"), userInfo.get("passWord"));
    }

    @Then("the user should see Account Summary page")
    public void the_user_should_see_Account_Summary_page() {

        DashBoardPage dashBoardPage = new DashBoardPage();

        Assert.assertTrue(getPageTitle().contains("Account Summary"));
    }

    //Negative scenario
    @When("the user eneters wrong {string} and {string}")
    public void the_user_eneters_wrong_and(String userName, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

    }

    @Then("the user gets the following {string}")
    public void the_user_gets_the_following(String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage();
        String actualErrorMessage = loginPage.errorMessageForLogin.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}
