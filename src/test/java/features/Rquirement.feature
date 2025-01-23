Feature: validating Requirement feature



  Scenario: Validating Add candidate Creation
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard
    And the user click on Requirement link on menu items list
    Then user fill the all the details of candidate and click on save button