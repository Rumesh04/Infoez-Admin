@profile
Feature: Admin Profile

Background:
Given the admin has logged in with the Infoez account
And the admin views the home page
When the admin clicks the profile icon to open the account menu
And the admin clicks Profile in the account menu

@profileView
Scenario: Profile details are displayed
Then the profile should show the email "admin@infoez.com"

@profileUpdate
Scenario Outline: Admin updates the profile name
When the admin changes the profile name to "<name>"
And the admin saves the profile
Then the profile updated message should be displayed

Examples:
| name             |
| Infoez Admin QA  |
| Infoez Admin     |



































