@myReviews @nosteps
Feature: Admin My Reviews

Background:
Given the admin is logged in to view reviews
And the admin is on the reviews home page
When the admin clicks the profile icon to open the account menu for reviews
And the admin clicks My Reviews in the account menu

@reviewsPage
Scenario: My Reviews page is displayed
Then the My Reviews page should be displayed

@reviewsNew
Scenario Outline: Admin posts a review and it appears in My Reviews
When the admin review the first business from Explore
When the admin posts a review for the first business with rating "<rating>" and comment "<comment>"
And the admin opens My Reviews from the account menu
Then the review for the business should be listed
And the listed rating should be "<rating>"

Examples:
| rating | comment                |
| 5      | Excellent service      |















