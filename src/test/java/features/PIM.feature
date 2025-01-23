Feature: validating PIM feature



  Scenario: Validating PIM Creation
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard
    And the user click on PIM link on menu items list
    And click on Add Employee button
    And enter all the fields and click on save btn
    Then it should navigate to personal details page
    And user should fill all the mandatory fields and click on save button
    Then validate created employee displayed in the orangehrm-container