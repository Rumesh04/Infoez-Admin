@category
Feature: Admin Category Taxonomy

Background:
Given the admin is signed in to the Infoez portal
And the admin sees the home page
When the admin opens the account menu from the header
And the admin selects admin menu to enter the admin portal
And Admin clicks Categories module in the sidebar menu

@categoryList
Scenario: Categories page is displayed
Then the categories page should be displayed

@addCategory
Scenario: Admin adds a new category
When the Admin adds a category with name "QA Test Category" 
Then the category success message should be displayed
And the category "QA Test Category" should be in the list

@duplicateCategory
Scenario: Admin cannot add a category with a duplicate slug
When the Admin add a category with name "QA Duplicate" 
Then the category error message should be displayed
And the category "QA Duplicate" should not be in the list

@deleteCategory
Scenario: Admin deletes a category
When the Admin deletes the category "QA Test Category"
And the Admin accepts the category delete confirmation
Then the category delete message should be displayed
And the category "QA Test Category" should not be in list



















