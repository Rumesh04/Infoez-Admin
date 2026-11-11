@login
Feature: Infoez Admin Login

  Background:
    Given the user is on the Infoez dashboard page
    When User clicks on Sign in button in header section of the page
    Then User should redirect to log in page

  @logged
  Scenario: Admin Log in with Valid Credentials
    When the User enters email "admin@infoez.com" and password "Admin@123"
    And the user clicks the Sign in button
    Then the user should redirected to the User page
    And Welcome Bake pop-up should be displayed

  Scenario Outline: Log in with invalid credentials
    When the user enters EMail "<email>" and Password "<password>"
    And User clicks the Sign in button
    Then an error message "<message>" should be displayed
    And User should stay on the login page

    Examples:
      | email            | password  | message             |
      | admin@infoez.com | name@123  | Invalid credentials |
      | name@infoez.com  | Admin@123 | Invalid credentials |

  @final
  Scenario: Log in Fails when both fields are empty
    When User clicks on the Sign in button without entering any details
    Then error message should be displayed
    And User should stays on the login page

    Examples:
      | email | password | message             |
      |       | name@123 | Invalid credentials |
