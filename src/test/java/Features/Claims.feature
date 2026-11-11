@claim
Feature: Admin claims Audit

Background:
Given the Admin is logged in to Infoez portal
And the Admin is on the user page
When Admin clicks Account menu in the header section and Account menu section should displayed 
And clicks admin menu in the section to navigate to the Admin page
And Admin clicks claims module in the sidebar menu 
And the admin is on the claims page 

@claimPage
Scenario: Claims list is displayed
Then the claims list should be displayed 
And each claim should show business, claimant and status 

@claimApproval
Scenario: Admin approves a claim
When the admin opens the pending claim 
And the admin approves the claim 
Then A success message should be displayed 
And the claim status should be "View proof"

@claimreject
Scenario: Admin Rejects a claim
When the admin open the pending Claim 
And the Admin rejects the claim
Then success message should be displayed 
And the claim status should "rejected"

Scenario: claimant is notified of the decision
Given the Admin has rejected the claim
When the claimant logs in 
Then the claimant should see a notification about the claim decision 









