Feature: User Login

  @111
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard
    And the user clicks the logout button


@222
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And clicks the login button
    Then an error message "Invalid credentials" should be displayed

  @333
  Scenario: Login attempt with empty fields
    Given the user is on the login page
    When the user leaves the username and password fields empty
    And clicks the login button
    Then an error Message "Required" should be displayed

    @444
  Scenario: Logout after successful login
    Given the user is logged in and on the dashboard
    When the user clicks the logout button
    Then the user should be redirected to the login page

#

