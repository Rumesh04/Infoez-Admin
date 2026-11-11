Feature: Infoez Admin User Management
# Scenario: Log in to Infoez Application
# Given the Admin is logged in to the infoez portal
# And the Admin is on the users page

  Background: User list is displayed
    Given the Admin is logged in to the infoez portal
    And the Admin is on the users page
    When Admin clicks ACcount menu in the header section and Account menu section should displayed
    And clicks Admin menu in the section to navigate to the Admin page
    And Admin clicks Users module in the sidebar menu
    Then the user table should be displayed
    And the table should show name, email, role and joined columns

  @user
  Scenario Outline: Admin changes a Users role
    When the Admin changes the role of "<email>" to "<new_role>"
    Then a success message should be displayed
    And the role of "<email>" should be  "<new_role>"

    Examples:
      | email          | new_role        |
      |test@gmail.com  |  bussiness_owner    |
     # | test@gmail.com | Customer |
@delete
  Scenario: Admin deletes a user
    When the Admin deletes the user "test@gmail.com"
    And Admin confirms the deletes
    Then a success message should displayed
    And the user "test@gmail.com" should not be in the table

  Scenario: Admin cannot delete their own Account
    When the Admin tries to delete the own account "admin@infoez.com"
    Then an error message should be displayed
    And the user "admin@infoez.com" should still be in the table
@role
  Scenario: Admin cannot downgrade their own account
    When the Admin changes the role of "admin@infoez.com" to customer
    Then error message should be displayed
    And the Admin role should still remains "admin"
