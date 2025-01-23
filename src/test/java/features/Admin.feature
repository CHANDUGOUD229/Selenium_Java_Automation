Feature: validating Admin feature



  Scenario: Validating Admin Creation
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard
    When the user click on Admin on menu items
    Then it should open user Management
    And  click on Add user Button
    Then user select "Admin"
    And user enter employee Name
    And select the employee status as "Enabled"
    And  Enter Username
    And Enter Password
    And Enter Confirm Password
    Then click on Save Button
