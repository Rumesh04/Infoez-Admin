@business
Feature: Admin Businesses Management

Background:
Given the admin has signed in to the Infoez portal
And the admin is on the home page
When the admin clicks the account menu in the header
And the admin chooses admin menu to go to the admin portal
And Admin clicks Businesses module in the sidebar menu

@businessList
Scenario: Businesses list is displayed
Then the businesses page should be displayed
And the businesses list should not be empty

@verifiedBadge
Scenario: Admin toggles the verified badge of a business
When the admin notes the verified count from the overview page
And the admin toggles the verified badge of the first business
And the admin returns to the overview page
Then the verified count should change by 1





