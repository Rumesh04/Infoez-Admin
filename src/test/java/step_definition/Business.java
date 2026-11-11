package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Business extends Base_Class {
	
	PomClass pom = new PomClass();
	String verifiedBefore;
	
	@Given("the admin has signed in to the Infoez portal")
	public void the_admin_has_signed_in_to_the_infoez_portal() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	    
	}
	@Given("the admin is on the home page")
	public void the_admin_is_on_the_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin clicks the account menu in the header")
	public void the_admin_clicks_the_account_menu_in_the_header() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@When("the admin chooses admin menu to go to the admin portal")
	public void the_admin_chooses_admin_menu_to_go_to_the_admin_portal() {
		button(pom.getClickAdminMenu());
	}
	@When("Admin clicks Businesses module in the sidebar menu")
	public void admin_clicks_businesses_module_in_the_sidebar_menu() {
	    button(pom.getClickBusiness());
	}
	@Then("the businesses page should be displayed")
	public void the_businesses_page_should_be_displayed() {
	    Assert.assertTrue("Business page is not displayed", pom.getPageHeader().isDisplayed());
	}
	@Then("the businesses list should not be empty")
	public void the_businesses_list_should_not_be_empty() {
	    visibleOfAllElement(pom.getBusinessPageList());
	    Assert.assertTrue("Business list is empty", pom.getBusinessPageList().size()>0);
	}
	
	@When("the admin notes the verified count from the overview page")
	public void the_admin_notes_the_verified_count_from_the_overview_page() {
		button(pom.getClickOverview());
		verifiedBefore = pom.getVerifiedCount().getText();
		System.out.println("Verified before: " + verifiedBefore);
		button(pom.getClickBusiness());
	}
	@When("the admin toggles the verified badge of the first business")
	public void the_admin_toggles_the_verified_badge_of_the_first_business() {
	    visibleOfElement(pom.getVerifyToggleBtn());
	    button(pom.getVerifyToggleBtn());
	}
	@When("the admin returns to the overview page")
	public void the_admin_returns_to_the_overview_page() {
	    button(pom.getClickOverview());
	}
	@Then("the verified count should change by {int}")
	public void the_verified_count_should_change_by(Integer int1) {
		visibleOfElement(pom.getVerifiedCount());
		String verifiedAfter = pom.getVerifiedCount().getText();
		System.out.println("Verified After: " + verifiedAfter);
		Assert.assertEquals("Verified count are same", verifiedBefore, verifiedAfter);
	}

}
