@moderation
Feature: Admin Pending Listings Moderation

Background:
Given the admin signs in to the Infoez portal
And the admin lands on the home page
When the admin opens the account menu to reach the admin portal
And the admin navigates to the admin page from the account menu
And Admin clicks Pending module in the sidebar menu

@pendingList
Scenario: Pending listings are displayed
Then the pending listings page should be displayed
And the pending listing should show the Approve and Reject actions

@approveListing
Scenario: Admin approves a pending listing
When the admin notes the number of pending listings
And the admin approves the first pending listing
Then the listing approval message should be displayed
And the pending listings count should reduce by 1

@rejectListing
Scenario: Admin rejects a pending listing
When the admin note the number of pending listings
And the admin reject the first pending listing
Then the listing rejection message should be displayed
And the pending listing count should reduce by 1
































