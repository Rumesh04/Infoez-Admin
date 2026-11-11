@accountMenu
Feature: Admin Account Menu

Background:
Given the admin is logged in with the Infoez account
And the admin is shown the home page
When the admin clicks the profile icon in the header

@menuItems
Scenario Outline: Account menu items are displayed
Then the account menu should show "<item>"

Examples:
| item          |
| Profile       |
| Favorites     |
| My Reviews    |
| My Enquiries  |
| Notifications |
| Admin         |

@menuNavigation
Scenario Outline: Account menu item opens its page
When the admin clicks "<item>" in the account menu
Then the page heading should contain "<heading>"

Examples:
| item          | heading        |
| Profile       | Profile        |
#| Favorites     | Favorites      |
#| My Reviews    | My Reviews     |
#| My Enquiries  | My Enquiries   |
#| Notifications | Notifications  |
#| Admin         | Control Center |

@signOut
Scenario: Admin signs out from the account menu
When the admin click "Log out" in the account menu
Then the Sign in button should be displayed in the header

































