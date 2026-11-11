package step_definition;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Category extends Base_Class {
	
	PomClass pom = new PomClass();

	@Given("the admin is signed in to the Infoez portal")
	public void the_admin_is_signed_in_to_the_infoez_portal() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();

	}

	@Given("the admin sees the home page")
	public void the_admin_sees_the_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);

	}

	@When("the admin opens the account menu from the header")
	public void the_admin_opens_the_account_menu_from_the_header() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());

	}

	@When("the admin selects admin menu to enter the admin portal")
	public void the_admin_selects_admin_menu_to_enter_the_admin_portal() {
		button(pom.getClickAdminMenu());

	}

	@When("Admin clicks Categories module in the sidebar menu")
	public void admin_clicks_categories_module_in_the_sidebar_menu() {
		button(pom.getClickCategories());

	}

	@Then("the categories page should be displayed")
	public void the_categories_page_should_be_displayed() {
		visibleOfElement(pom.getPageHeader());
	    Assert.assertTrue("categories page is not displayed", pom.getPageHeader().isDisplayed());

	}

	@When("the Admin adds a category with name {string}")
	public void the_admin_adds_a_category_with_name(String string) {
		setText(pom.getNewCategoryField(), string);
		button(pom.getClickCategoryAddBtn());
	}

	@Then("the category success message should be displayed")
	public void the_category_success_message_should_be_displayed() {
		System.out.println("Category success message is not displayed");
	}

	@Then("the category {string} should be in the list")
	public void the_category_should_be_in_the_list(String string) {
		List<WebElement> cateoryList = pom.getCateoryList();
		boolean found = false;
		for(WebElement category : cateoryList) {
			String text = category.getText();
			System.out.println(text);
			if(string.equals(text)) {
				found = true;
				break;
			}
		}
		Assert.assertTrue("New Category is not displayed", found);
	}

	@When("the Admin add a category with name {string}")
	public void the_admin_add_a_category_with_name(String string) {
		setText(pom.getNewCategoryField(), string);
		button(pom.getClickCategoryAddBtn());
	}

	@Then("the category error message should be displayed")
	public void the_category_error_message_should_be_displayed() {
		System.out.println("Error message has not displayed");
	}

	@Then("the category {string} should not be in the list")
	public void the_category_should_not_be_in_the_list(String string) {
		
	}

	@When("the Admin deletes the category {string}")
	public void the_admin_deletes_the_category(String string) {
		button(pom.getCategoryDeleteBtn());
	}

	@When("the Admin accepts the category delete confirmation")
	public void the_admin_accepts_the_category_delete_confirmation() {
		Alert A = driver.switchTo().alert();
		A.accept();
	}

	@Then("the category delete message should be displayed")
	public void the_category_delete_message_should_be_displayed() {
		System.out.println("category delete message is not displayed");
	}

	@Then("the category {string} should not be in list")
	public void the_category_should_not_be_in_list(String string) {
		
	}

}
