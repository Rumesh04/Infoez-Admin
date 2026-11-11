package step_definition;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class UserManagement extends Base_Class {

	PomClass pom = new PomClass();
	private  String emailText;
	private String email;

	@Given("the Admin is logged in to the infoez portal")
	public void the_admin_is_logged_in_to_the_infoez_portal() throws InterruptedException {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/");
		button(pom.getHeaderSignInBtn());
		Thread.sleep(5000);
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();

	}

	@Given("the Admin is on the users page")
	public void the_admin_is_on_the_users_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		// System.out.println(currentUrl);
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}

	@When("Admin clicks ACcount menu in the header section and Account menu section should displayed")
	public void admin_clicks_a_ccount_menu_in_the_header_section_and_account_menu_section_should_displayed() throws InterruptedException {
		Thread.sleep(5000);
		visibleOfElement(pom.getClickProfileBtn());
		pom.getClickProfileBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
	}

	@When("clicks Admin menu in the section to navigate to the Admin page")
	public void clicks_admin_menu_in_the_section_to_navigate_to_the_admin_page() {
		button(pom.getClickAdminMenu());
	}

	@When("Admin clicks Users module in the sidebar menu")
	public void admin_clicks_users_module_in_the_sidebar_menu() {
		visibleOfElement(pom.getClickUserSideBar());
		button(pom.getClickUserSideBar());
	}

	@Then("the user table should be displayed")
	public void the_user_table_should_be_displayed() {
		Assert.assertTrue("User table is not displayed", pom.getUserTable().isDisplayed());
	}

	@Then("the table should show name, email, role and joined columns")
	public void the_table_should_show_name_email_role_and_joined_columns() {
		int size = pom.getTableHeader().size();
		iterateWebElement(pom.getTableHeader(), size);
	}

	@When("the Admin changes the role of {string} to {string}")
	public void the_admin_changes_the_role_of_to(String string, String string2) {
		
		int emailSize = pom.getEmailColumn().size();
		int roleSize = pom.getRoleColumn().size();
		
		int size = Math.min(emailSize, roleSize);
		
		for(int i=0;i<size;i++) {
			String emailText = pom.getEmailColumn().get(i).getText();
			
			java.lang.String roleText = pom.getRoleColumn().get(i).getText();
			
			if(emailText.equals(string)) {
				System.out.println("Email fond: " +emailText);
				button(pom.getTableRoleSelect());
				button(pom.getSelectCustomer());
			}
		}
		
		
		

	}

	@Then("a success message should be displayed")
	public void a_success_message_should_be_displayed() {
		Assert.assertTrue("Toster message is not displayed", pom.getRoleUpdate().isDisplayed());

	}

	@Then("the role of {string} should be  {string}")
	public void the_role_of_should_be(String string, String string2) {

	}

	@When("the Admin deletes the user {string}")
	public void the_admin_deletes_the_user(String string) {
		boolean userFound = false;	   
		int emailSize = pom.getEmailColumn().size();
		for(int i=0;i<emailSize;i++) {
			String emailText = pom.getEmailColumn().get(i).getText();
			if(emailText.equals(string)) {
				System.out.println("Email fond: " +emailText);
				
				pom.getUserDeleteBtn().get(i-1).click();
				userFound = true;
				break;
				
			}
		}
	    

	}

	@When("Admin confirms the deletes")
	public void admin_confirms_the_deletes() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message: "+ alert.getText());
		alert.accept();

	}

	@Then("a success message should displayed")
	public void a_success_message_should_displayed() {
		Assert.assertTrue("Delete confirm message is not displayed", pom.getDeletePopUp().isDisplayed());

	}

	@Then("the user {string} should not be in the table")
	public void the_user_should_not_be_in_the_table(String string) {
		int emailSize = pom.getEmailColumn().size();
			boolean userFound = false;
			for(int i=0;i<emailSize;i++) {
				String actualEMail = pom.getEmailColumn().get(i).getText().trim();
				if(actualEMail.equalsIgnoreCase(string)) {
					userFound = true;
					break;
				}
			}
			Assert.assertFalse("User is still present in the table: " + string, userFound);
		}
	

	@When("the Admin tries to delete the own account {string}")
	public void the_admin_tries_to_delete_the_own_account(String string) {

	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {

	}

	@Then("the user {string} should still be in the table")
	public void the_user_should_still_be_in_the_table(String string) {

	}

	@When("the Admin changes the role of {string} to customer")
	public void the_admin_changes_the_role_of_to_customer(String string) {
		int emailSize = pom.getEmailColumn().size();
		
		for(int i=0;i<emailSize;i++) {
			String emailText = pom.getEmailColumn().get(i).getText();
			System.out.println(emailText);
			
			if(emailText.equals(string)) {
				System.out.println("Email fond: " +emailText);
				//button(pom.getRoleColumn().get(i-1));
				//visibleOfElement(pom.getSelectCustomer());
				button(pom.getTableAdminSelect());
				button(pom.getSelectBussinessOwner());

			}
		}

	}

	@Then("the Admin role should still remains {string}")
	public void the_admin_role_should_still_remains(String string) {
		int roleSize = pom.getRoleColumn().size();
		for(int i=0;i<roleSize;i++) {
			String roleText = pom.getRoleColumn().get(i-1).getText();
			Assert.assertEquals(string, roleText);

	}
	}

	}