@overview
Feature: Admin Dashboard KPI

Background: 
Given the admin logged in to the infoez portal
And Admin is on the user page
When Admin clicks Account menu in the header section
And clicks admin menu in the section to Navigate to the admin page

@card
Scenario: All KPI cards are displayed
Then the following "<KPI>" cards should be displayed 
Examples:
|  KPI                 |
|  PENDING             |
|  Users               |
|  Businesses          |
|  Verified            |
|  Reviews             |
|  Enquiries           |
|  Pending claims      |

@pending
Scenario: Pending card matches the Pending list
When the admin notes the "Pending" value 
And the admin opens the pending page 
Then the Total number of pending listed should match the card value 

@user
Scenario: Total User card matches the User list
When the admin notes the user "User" value 
And the admin opens the User page 
Then the Total number of User listed should match the card value 

@bussiness
Scenario: Total Businesses card matches the Businesses list
When the admin notes the Businesses "Businesses" value 
And the admin opens the Businesses page 
Then the Total number of Businesses listed should match the card value 

@verified
Scenario: Total Verified card matches the Verified list
When the admin notes the Verified "Verified" value 
And the admin open the Businesses page 
Then the Total number of Verified listed should match the card value

@review
Scenario: Total Reviews card matches the Reviews list
When the admin notes the Reviews "Reviews" value 
And the admin opens the business page 
Then the Total number of Reviews listed should match the card value

@pendingclaim
Scenario: Total Pending claims card matches the Pending claims list
When the admin notes the Pending claims "Pending claims" value 
And the admin opens the Claims page 
Then the Total number of pending claims listed should match the card value

@Enquiry
Scenario: Total Enquiries card matches the Enquiries list
When the admin notes the Enquiries "Enquiries" value 
And the admin opens the Enquiries page 
Then the Total number of Enquiries listed should match the card value










