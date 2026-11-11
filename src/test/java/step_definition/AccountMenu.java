 package step_definition;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class AccountMenu extends Base_Class {
	
	PomClass pom = new PomClass();
	String menu;
	
	@Given("the admin is logged in with the Infoez account")
	public void the_admin_is_logged_in_with_the_infoez_account() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("the admin is shown the home page")
	public void the_admin_is_shown_the_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin clicks the profile icon in the header")
	public void the_admin_clicks_the_profile_icon_in_the_header() throws InterruptedException {
		Thread.sleep(5000);
	    button(pom.getHeaderSignInBtn());
	}
	@Then("the account menu should show {string}")
	public void the_account_menu_should_show(String string) {
		List<WebElement> menus = pom.getAdminMenuSection();
		boolean found = false;
		for(WebElement menu : menus) {
			String text = menu.getText();
			if(string.equals(text)) {
				System.out.println("Admin menu section displayed:"+ text);
				found = true;
			}
		}
	    Assert.assertTrue("Account menu section is not displayed"+ string, found);
	}
	
	@When("the admin clicks {string} in the account menu")
	public void the_admin_clicks_in_the_account_menu(String string) {
		 int size = pom.getAdminMenuSection().size();
		 for(int i=0;i<size;i++) {
			 menu = pom.getAdminMenuSection().get(i).getText();
			 if(menu.equals(string)) {
				 pom.getAdminMenuSection().get(i).click();
				 return;
			 }
		 }
	}
	@Then("the page heading should contain {string}")
	public void the_page_heading_should_contain(String string) {
	    String pageHeader = pom.getPageHeader().getText();
	    Assert.assertTrue("Correct page is not displayed", pageHeader.contains(string));
	    
	}
	
	@When("the admin click {string} in the account menu")
	public void the_admin_click_in_the_account_menu(String string) {
	     String signOut = pom.getClickSignOut().getText();
	     Assert.assertEquals(string, signOut);
	     button(pom.getClickSignOut());
	    
	}
	@Then("the Sign in button should be displayed in the header")
	public void the_sign_in_button_should_be_displayed_in_the_header() {
	    Assert.assertTrue("Sign In btn is not displayed", pom.getHeaderSignInBtn().isDisplayed());
	}

}
