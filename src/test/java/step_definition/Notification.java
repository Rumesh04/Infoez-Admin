package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Notification extends Base_Class{
	
	PomClass pom = new PomClass();
	
	@Given("the admin is Logged in to the Infoez portal")
	public void the_admin_is_logged_in_to_the_infoez_portal() throws InterruptedException {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/");
		button(pom.getHeaderSignInBtn());
		Thread.sleep(5000);
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@When("Admin click Account menu in the header section and Account menu section should displayed")
	public void admin_click_account_menu_in_the_header_section_and_account_menu_section_should_displayed() throws InterruptedException {
		Thread.sleep(5000);
		visibleOfElement(pom.getClickProfileBtn());
		pom.getClickProfileBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
	}
	@When("clicks notification menu in the section to redirect to the notifications page")
	public void clicks_notification_menu_in_the_section_to_redirect_to_the_notifications_page() {
	    
	}
	@When("the admin is on the Notification page")
	public void the_admin_is_on_the_notification_page() {
	    
	}
	@Then("the notification list should be displayed")
	public void the_notification_list_should_be_displayed() {
	    
	}
	
	@Given("the admin has unread notifications")
	public void the_admin_has_unread_notifications() {
	    
	}
	@Then("Unread count should be displayed")
	public void unread_count_should_be_displayed() {
	    
	}
	@Then("the unread count should be a number greater than {int}")
	public void the_unread_count_should_be_a_number_greater_than(Integer int1) {
	    
	}
	
	@When("Admin click Account menu in the header section and account section should displayed")
	public void admin_click_account_menu_in_the_header_section_and_account_section_should_displayed() throws InterruptedException {
		Thread.sleep(5000);
		visibleOfElement(pom.getClickProfileBtn());
		pom.getClickProfileBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
	}
	
	@When("the admin opens the notification")
	public void the_admin_opens_the_notification() {
	    button(pom.getClickNotification());
	}
	
	@When("the Admin has unread notification")
	public void the_admin_has_unread_notification() {
	    Assert.assertTrue("Mark Read button is not displayed", pom.getMarkRead().isDisplayed());
	}
	@When("the admin clicks marks all notifications as read")
	public void the_admin_clicks_marks_all_notifications_as_read() {
	    button(pom.getMarkAllReadbtn());
	}
	@Then("All notifications should be show as read")
	public void all_notifications_should_be_show_as_read() {
	    Assert.assertFalse("Mark read button is displayed", pom.getMarkAllReadbtn().isDisplayed());
	}
	@Then("the unread count should be {int}")
	public void the_unread_count_should_be(Integer int1) {
	    
	}
	

}
