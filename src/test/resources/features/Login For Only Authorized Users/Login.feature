Feature:Only authorized users should be able to login to the application.

  Background:
    Given the user is on the login page

  Scenario: User logs in with valid credentials
    When the user enters username and password
      | userName | username |
      | passWord | password |
    Then the user should see Account Summary page


  Scenario Outline: : User logs in with invalid credentials
    When the user eneters wrong "<username>" and "<password>"
    Then the user gets the following "<error message>"


    Examples:
      | username  | password  | error message                    |
      | username  | password1 | Login and/or password are wrong. |
      | username1 | password  | Login and/or password are wrong. |
      |           | password  | Login and/or password are wrong. |
      | username  |           | Login and/or password are wrong. |
