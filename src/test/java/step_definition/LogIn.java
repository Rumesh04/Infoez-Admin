package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class LogIn extends Base_Class {

	PomClass pom = new PomClass();

	@Given("the user is on the Infoez dashboard page")
	public void the_user_is_on_the_infoez_dashboard_page() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/");
		waitImpletic();
	}

	@When("User clicks on Sign in button in header section of the page")
	public void user_clicks_on_sign_in_button_in_header_section_of_the_page() {
		button(pom.getHeaderSignInBtn());
	}

	@Then("User should redirect to log in page")
	public void user_should_redirect_to_log_in_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("Log in page is not displayed", currentUrl.contains("/login"));
	}

	@When("the User enters email {string} and password {string}")
	public void the_user_enters_email_and_password(String string, String string2) {
		setText(pom.getEnterEmail(), string);
		setText(pom.getEnterPassword(), string2);
	}

	@When("the user clicks the Sign in button")
	public void the_user_clicks_the_sign_in_button() {
		button(pom.getClickSignIn());
	}

	@Then("Welcome Bake pop-up should be displayed")
	public void welcome_bake_pop_up_should_be_displayed() {
		visibleOfElement(pom.getWelcomeToast());
		Assert.assertTrue("Toster message is not displayed", pom.getWelcomeToast().isDisplayed());
	}

	@Then("the user should redirected to the User page")
	public void the_user_should_redirected_to_the_user_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}

	@When("the user enters EMail {string} and Password {string}")
	public void the_user_enters_e_mail_and_password(String string, String string2) {
		setText(pom.getEnterEmail(), string);
		setText(pom.getEnterPassword(), string2);
	}

	@When("User clicks the Sign in button")
	public void user_clicks_the_sign_in_button() {
		button(pom.getClickSignIn());
	}

	@Then("an error message {string} should be displayed")
	public void an_error_message_should_be_displayed(String string) {
		String text = pom.getInvalidToast().getText();
		Assert.assertTrue("Toster message is not displayed", string.equalsIgnoreCase(text));
	}

	@Then("User should stay on the login page")
	public void user_should_stay_on_the_login_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("Admin not in the log in page", currentUrl.contains("/login"));
	}

	@When("User clicks on the Sign in button without entering any details")
	public void user_clicks_on_the_sign_in_button_without_entering_any_details() {
		button(pom.getClickSignIn());
	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		String actualMessage = pom.setEnterEmail();
		Assert.assertEquals("Please fill out this field.", actualMessage);
		System.out.println("Validation Message: " + actualMessage);

	}

	@Then("User should stays on the login page")
	public void user_should_stays_on_the_login_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("Admin not in the log in page", currentUrl.contains("/login"));

	}

}
