package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AccountAvtivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountList;

    //Find Transaction Tab---------------------------

    //showing table result
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> dateTableResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> descriptionTableResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> depositeTableResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> withdrawalTableResult;


    //Description
    @FindBy(css = "#aa_description")
    public WebElement descroptionInputBox;

    //Starting Date
    @FindBy(css = "#aa_fromDate")
    public WebElement startingDate;

    //Ending Dates
    @FindBy(css = "#aa_toDate")
    public WebElement endingDate;

    //Initial Amount
    @FindBy(css = "aa_fromAmount")
    public WebElement initialAmount;

    //Clicking Find Button
    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;


    //Navigating through main menus
    public String dropDownFristListName() {

        BrowserUtils.waitFor(2);
        Select title = new Select(accountList);
        return title.getFirstSelectedOption().getText();
    }

    //It's navigating through tabs
    public void navigateToTabMenu(String tabName) {
        BrowserUtils.waitFor(2);
        WebElement tab = Driver.get().findElement(By.xpath("//li[.='" + tabName + "']"));
        tab.click();
    }

    public void inputDescription(String description) {
        BrowserUtils.waitFor(1);
        this.descroptionInputBox.clear();
        this.descroptionInputBox.sendKeys(description);
    }

    public void inputDatesFromTo(String fromDate, String toDate) {

        BrowserUtils.waitFor(1);
        this.startingDate.clear();
        this.startingDate.sendKeys(fromDate);
        this.endingDate.clear();
        this.endingDate.sendKeys(toDate);
    }

    public void verifyingDatesWithTableResults(String fromDate, String toDate) throws ParseException {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date fdate = fmt.parse(fromDate);
        Date tdate = fmt.parse(toDate);

        List<String> listDates = BrowserUtils.getElementsText(dateTableResult);

        for (String dates : listDates) {
            // SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dateInTable = fmt.parse(dates);
            Assert.assertTrue(fdate.compareTo(dateInTable) <= 0 && tdate.compareTo(dateInTable) >= 0);
        }
    }

    public void verifyingDatesWithTableResults(String dateNotContain) throws ParseException {

        BrowserUtils.waitFor(2);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date dd = date.parse(dateNotContain);

        List<String> listDates = BrowserUtils.getElementsText(dateTableResult);

        for (String dates : listDates) {
            // SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dateInTable = date.parse(dates);
            Assert.assertFalse(dd.compareTo(dateInTable) == 0);
        }
    }

    public void verifyingDescriptionWithTableResults(String description) {

        BrowserUtils.waitFor(2);
        List<WebElement> descriptionColumn = descriptionTableResult;
        for (WebElement s : descriptionColumn) {
            String column = s.getText();
            System.out.println(column);
            Assert.assertTrue(column.contains(description));
        }
    }
}


