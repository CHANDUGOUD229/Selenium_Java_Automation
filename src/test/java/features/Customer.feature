Feature:  Verify customer

  @tag2
  Scenario: Verify Customer able to adding or not
#    Given user launch the application
    When user enter the login details and click on login button
    And user click on customers menu
    And user click  on customer option
    Then user  should see customer page
    When user click on the add new button
    Then user should see Add a new customer  page
    And user enter the all the details and click on save button
    And click on logout




