package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Profile extends Base_Class{
	
	PomClass pom = new PomClass();
	
	@Given("the admin has logged in with the Infoez account")
	public void the_admin_has_logged_in_with_the_infoez_account() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("the admin views the home page")
	public void the_admin_views_the_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin clicks the profile icon to open the account menu")
	public void the_admin_clicks_the_profile_icon_to_open_the_account_menu() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@When("the admin clicks Profile in the account menu")
	public void the_admin_clicks_profile_in_the_account_menu() {
	    button(pom.getClickProfile());
	}
	@Then("the profile should show the email {string}")
	public void the_profile_should_show_the_email(String string) {
	    visibleOfElement(pom.getProfileEmailField());
	    String attribute = pom.getProfileEmailField().getAttribute("value");
	    Assert.assertEquals("Profile email is not displayed", string, attribute);
	}
	
	@When("the admin changes the profile name to {string}")
	public void the_admin_changes_the_profile_name_to(String string) {
	    pom.getProfileNameField().clear();
	    setText(pom.getProfileEmailField(), string);
	}
	@When("the admin saves the profile")
	public void the_admin_saves_the_profile() {
	    button(pom.getClickSaveAndChange());
	}
	@Then("the profile updated message should be displayed")
	public void the_profile_updated_message_should_be_displayed() {
	    Assert.assertTrue("project updated pop up not displayed", pom.getSavePopUp().isDisplayed());
	}

}
