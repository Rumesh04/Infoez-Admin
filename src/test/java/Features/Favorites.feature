@favorites
Feature: Admin Favorites

Background:
Given the admin has signed in with the Infoez account
And the admin is shown the landing page
When the admin clicks the profile icon to reach the account menu
And the admin clicks Favorites in the account menu

@favoritesList
Scenario: Favorites page is displayed
Then the favorites page should be displayed

@addFavorite
Scenario: Admin adds a business to favorites
When the admin notes the number of favorites
And the admin favorites the first business from Explore
And the admin returns to the favorites page
Then the favorites count should change by 1

@removeFavorite
Scenario: Admin removes a business from favorites
When the admin note the number of favorites
And the admin removes the first favorite
Then the favorite count should change by 1



















