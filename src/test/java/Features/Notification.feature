@notification
Feature: Admin Notification

Background:
Given the admin is Logged in to the Infoez portal
@notificationsPage
Scenario: Notification list is displayed
When Admin click Account menu in the header section and Account menu section should displayed 
And clicks notification menu in the section to redirect to the notifications page
And the admin is on the Notification page 
Then the notification list should be displayed 

Scenario: Unread count is displayed
Given the admin has unread notifications 
Then Unread count should be displayed 
And the unread count should be a number greater than 0

@markAll
Scenario: Admin marks all notification as read
When Admin click Account menu in the header section and account section should displayed 
When the admin opens the notification  
When the Admin has unread notification 
And the admin clicks marks all notifications as read 
Then All notifications should be show as read 
And the unread count should be 0 



























