
Feature: Navigating to specific accounts in Accounts Activity
  Background:
    Given the user is on the login page
    When the user enters username and password
    Then the user should see Account Summary page

  Scenario Outline:<account> Redirect Funtionality
    When the user clicks on "<account>" link on the Account Summary page
    Then the "<pageTitle>" page should be displayed
    And Account dropdown should have "<accountList>" selected
    Examples:
      | account     | pageTitle        | accountList |
      | Savings     | Account Activity | Savings     |
      | Brokerage   | Account Activity | Brokerage   |
      | Checking    | Account Activity | Checking    |
      | Credit Card | Account Activity | Credit Card |
      | Loan        | Account Activity | Loan        |


