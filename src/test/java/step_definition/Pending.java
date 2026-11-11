package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Pending extends Base_Class {
	
	PomClass pom = new PomClass();
	private int beforeApproval;
	private int beforeReject;
	
	@Given("the admin signs in to the Infoez portal")
	public void the_admin_signs_in_to_the_infoez_portal() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("the admin lands on the home page")
	public void the_admin_lands_on_the_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin opens the account menu to reach the admin portal")
	public void the_admin_opens_the_account_menu_to_reach_the_admin_portal() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@When("the admin navigates to the admin page from the account menu")
	public void the_admin_navigates_to_the_admin_page_from_the_account_menu() {
		button(pom.getClickAdminMenu());
	}
	@When("Admin clicks Pending module in the sidebar menu")
	public void admin_clicks_pending_module_in_the_sidebar_menu() {
	    button(pom.getClickPending());
	}
	@Then("the pending listings page should be displayed")
	public void the_pending_listings_page_should_be_displayed() {
	    visibleOfElement(pom.getPageHeader());
	    Assert.assertTrue("Pending page is not displayed", pom.getPageHeader().isDisplayed());
	}
	@Then("the pending listing should show the Approve and Reject actions")
	public void the_pending_listing_should_show_the_approve_and_reject_actions() {
	    Assert.assertTrue("Approval btn is not displayed", pom.getPendingApprove().isDisplayed());
	    Assert.assertTrue("Reject btn is not displayed", pom.getPendingReject().isDisplayed());
	}
	
	@When("the admin notes the number of pending listings")
	public void the_admin_notes_the_number_of_pending_listings() {
	    beforeApproval = pom.getPendingList().size();
	    Assert.assertTrue("Favorities are not displayed", beforeApproval>0);
	    System.out.println("pending count before clicking approval: "+ beforeApproval);
	}
	@When("the admin approves the first pending listing")
	public void the_admin_approves_the_first_pending_listing() {
	    button(pom.getClickApproval());
	}
	@Then("the listing approval message should be displayed")
	public void the_listing_approval_message_should_be_displayed() {
	    Assert.assertTrue("List Approval message is not displayed", pom.getApprovalPopup().isDisplayed());
	}
	@Then("the pending listings count should reduce by {int}")
	public void the_pending_listings_count_should_reduce_by(Integer int1) {
	    int afterApproval = pom.getPendingList().size();
	    System.out.println("After approval: "+ afterApproval);
	    Assert.assertNotSame("pending should is same", beforeApproval, afterApproval);
	}
	
	@When("the admin note the number of pending listings")
	public void the_admin_note_the_number_of_pending_listings() {
		beforeReject = pom.getPendingList().size();
	    Assert.assertTrue("Favorities are not displayed", beforeApproval>0);
	    System.out.println("pending count before clicking approval: "+ beforeApproval);
	}
	@When("the admin reject the first pending listing")
	public void the_admin_reject_the_first_pending_listing() {
	    button(pom.getClickReject());
	}
	@Then("the listing rejection message should be displayed")
	public void the_listing_rejection_message_should_be_displayed() {
		button(pom.getRejectListingBtn());
		Assert.assertTrue("List rejected message is not displayed", pom.getRejectedPopup().isDisplayed());
	    
	}
	@Then("the pending listing count should reduce by {int}")
	public void the_pending_listing_count_should_reduce_by(Integer int1) {
	    
	}

}
