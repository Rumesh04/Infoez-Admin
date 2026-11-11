package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Claim extends Base_Class {
	
	PomClass pom = new PomClass();
	
	@Given("the Admin is logged in to Infoez portal")
	public void the_admin_is_logged_in_to_infoez_portal() throws InterruptedException {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/");
		button(pom.getHeaderSignInBtn());
		Thread.sleep(5000);
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	    
	}
	@Given("the Admin is on the user page")
	public void the_admin_is_on_the_user_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		// System.out.println(currentUrl);
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("Admin clicks Account menu in the header section and Account menu section should displayed")
	public void admin_clicks_account_menu_in_the_header_section_and_account_menu_section_should_displayed() throws InterruptedException {
		Thread.sleep(7000);
		visibleOfElement(pom.getHeaderSignInBtn());
		pom.getHeaderSignInBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
	}
	@When("clicks admin menu in the section to navigate to the Admin page")
	public void clicks_admin_menu_in_the_section_to_navigate_to_the_admin_page() {
		button(pom.getClickAdminMenu());
	}
	@When("Admin clicks claims module in the sidebar menu")
	public void admin_clicks_claims_module_in_the_sidebar_menu() {
	    button(pom.getClickClaim());
	}
	@When("the admin is on the claims page")
	public void the_admin_is_on_the_claims_page() {
	    Assert.assertTrue("Claim page is not displayed", pom.getClaimPage().isDisplayed());
	}
	@Then("the claims list should be displayed")
	public void the_claims_list_should_be_displayed() {
	    Assert.assertTrue("Claim list is not displayed", pom.getClaimList().isDisplayed());
	}
	@Then("each claim should show business, claimant and status")
	public void each_claim_should_show_business_claimant_and_status() {
	    Assert.assertTrue("Status is not displayed", pom.getClaimStatus().isDisplayed());
	    Assert.assertTrue("Business and claimant name is not displayed", pom.getClaimBusiness().isDisplayed());
	}
	
	@When("the admin opens the pending claim")
	public void the_admin_opens_the_pending_claim() throws InterruptedException {
//		Thread.sleep(5000);
//		visibleOfElement(pom.getClickProfileBtn());
//		pom.getClickProfileBtn().click();
//		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
//		button(pom.getClickAdminMenu());
//		button(pom.getClickClaim());
		Assert.assertTrue("Claim page is not displayed", pom.getClaimPage().isDisplayed());
	}
	@When("the admin approves the claim")
	public void the_admin_approves_the_claim() {
	    button(pom.getClickApprove());
	}
	@Then("A success message should be displayed")
	public void a_success_message_should_be_displayed() {
	    Assert.assertTrue("Approval Pop up not displayed", pom.getApprovalPopup().isDisplayed());
	}
	@Then("the claim status should be {string}")
	public void the_claim_status_should_be(String string) {
	    String text = pom.getViewProof().getText();
	    Assert.assertTrue("Claim status is not changed", text.contains(string));
	    
	}
	
	@When("the admin open the pending Claim")
	public void the_admin_open_the_pending_claim() throws InterruptedException {
		Thread.sleep(5000);
		visibleOfElement(pom.getClickProfileBtn());
		pom.getClickProfileBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
		button(pom.getClickAdminMenu());
		button(pom.getClickClaim());
	}
	@When("the Admin rejects the claim")
	public void the_admin_rejects_the_claim() {
		button(pom.getClickReject());
	    
	}
	@Then("success message should be displayed")
	public void success_message_should_be_displayed() {
	    Assert.assertTrue("Rejected Pop up is not displayed", pom.getRejectedPopup().isDisplayed());
	}
	@Then("the claim status should {string}")
	public void the_claim_status_should(String string) {
	    
	}
	
	@Given("the Admin has rejected the claim")
	public void the_admin_has_rejected_the_claim() {
	    
	}
	@When("the claimant logs in")
	public void the_claimant_logs_in() {
	    
	}
	@Then("the claimant should see a notification about the claim decision")
	public void the_claimant_should_see_a_notification_about_the_claim_decision() {
	    
	}
	

}
