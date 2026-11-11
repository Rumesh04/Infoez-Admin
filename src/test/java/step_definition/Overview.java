package step_definition;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.Base_Class;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Overview extends Base_Class{
	
	PomClass pom = new PomClass();
	String pendingCount;
	String userCount;
	String businessCount;
	String verifiedCount;
	String reviewCount;
	String claimsCount;
	String enquiriesCount;
	
	@Given("the admin logged in to the infoez portal")
	public void the_admin_logged_in_to_the_infoez_portal() throws InterruptedException {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/");
		button(pom.getHeaderSignInBtn());
		Thread.sleep(5000);
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("Admin is on the user page")
	public void admin_is_on_the_user_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("Admin clicks Account menu in the header section")
	public void admin_clicks_account_menu_in_the_header_section() throws InterruptedException {
		Thread.sleep(5000);
		visibleOfElement(pom.getClickProfileBtn());
		pom.getClickProfileBtn().click();
		Assert.assertTrue("Admin Menu section is not displayed", pom.getMenuSection().isDisplayed());
	}
	@When("clicks admin menu in the section to Navigate to the admin page")
	public void clicks_admin_menu_in_the_section_to_navigate_to_the_admin_page() {
		button(pom.getClickAdminMenu());
	}
	
//	@Then("the following KPI cards should be displayed")
//	public void the_following_kpi_cards_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
//		List<String> expectedCards = dataTable.asList();
//	    List<WebElement> actualCards = pom.getKpiCards();
//	    
//	    for(String expectedCard : expectedCards) {
//	    	System.out.println(expectedCard);
//	    	boolean found = false;
//	    	for(WebElement actualCard : actualCards) {
//	    	String cardText = actualCard.getText();
//	    	System.out.println(cardText);
//	    	if(cardText.contains(expectedCard)) {
//	    		System.out.println("KPI card displayed"+ expectedCard);
//	    		found = true;
//	    		break;
//	    	}
//	    }
//	    Assert.assertTrue("KPI card is not displayed", found);
//	    }
//	}
	
	@Then("the following {string} cards should be displayed")
	public void the_following_cards_should_be_displayed(String string) {
		List<WebElement> cards = pom.getKpiCards();
		boolean found = false;
		for(WebElement card : cards) {
			String cardText = card.getText();
			if(cardText.equalsIgnoreCase(string)) {
				System.out.println("KPI card displayed"+ cardText);
				found = true;
			}
		}
		Assert.assertTrue("KPI card is not displayed", found);
	}
	
	@When("the admin notes the {string} value")
	public void the_admin_notes_the_value(String string) {
	    pendingCount = pom.getPendingCount().getText();
	    System.out.println(pendingCount);
	}
	@When("the admin opens the pending page")
	public void the_admin_opens_the_pending_page() {
	    button(pom.getPendingSideBar());
	}
	@Then("the Total number of pending listed should match the card value")
	public void the_total_number_of_pending_listed_should_match_the_card_value() {
	    Assert.assertEquals(pendingCount, pom.getPendingList().size());
	}
	
	@When("the admin notes the user {string} value")
	public void the_admin_notes_the_user_value(String string) {
	     userCount = pom.getUsersCount().getText();
	     System.out.println(userCount);
	}
	@When("the admin opens the User page")
	public void the_admin_opens_the_user_page() {
	    button(pom.getUsersSideBar());
	}
	@Then("the Total number of User listed should match the card value")
	public void the_total_number_of_user_listed_should_match_the_card_value() {
		Assert.assertEquals(userCount, pom.getUsersList().size());
	}
	
	@When("the admin notes the Businesses {string} value")
	public void the_admin_notes_the_businesses_value(String string) {
	     businessCount = pom.getBusinessCount().getText();
	}
	@When("the admin opens the Businesses page")
	public void the_admin_opens_the_businesses_page() {
	    button(pom.getBusinessSideBar());
	}
	@Then("the Total number of Businesses listed should match the card value")
	public void the_total_number_of_businesses_listed_should_match_the_card_value() {
		Assert.assertEquals(businessCount, pom.getBusinessList().size());
	}
	
	@When("the admin notes the Verified {string} value")
	public void the_admin_notes_the_verified_value(String string) {
	    verifiedCount = pom.getVerifiedCount().getText();
	    System.out.println(verifiedCount);
	}
	@When("the admin open the Businesses page")
	public void the_admin_open_the_businesses_page() {
		button(pom.getBusinessSideBar());
	}
	@Then("the Total number of Verified listed should match the card value")
	public void the_total_number_of_verified_listed_should_match_the_card_value() {
		Assert.assertEquals(verifiedCount, pom.getVerifiedBadgesList().size());
	}
	
	@When("the admin notes the Reviews {string} value")
	public void the_admin_notes_the_reviews_value(String string) {
	    String reviewCount = pom.getReviewsCount().getText();
	    System.out.println(reviewCount);
	}
	@When("the admin opens the business page")
	public void the_admin_opens_the_business_page() {
		throw new PendingException("No admin Reviews list page is available to compare with the Reviews card");
	}
	@Then("the Total number of Reviews listed should match the card value")
	public void the_total_number_of_reviews_listed_should_match_the_card_value() {
		throw new PendingException("No admin Reviews list page is available to compare with the Reviews card");
	}
	
	@When("the admin notes the Pending claims {string} value")
	public void the_admin_notes_the_pending_claims_value(String string) {
	    claimsCount = pom.getClaimsCount().getText();
	}
	@When("the admin opens the Claims page")
	public void the_admin_opens_the_claims_page() {
	    button(pom.getClaimsSideBar());
	}
	@Then("the Total number of pending claims listed should match the card value")
	public void the_total_number_of_pending_claims_listed_should_match_the_card_value() {
		Assert.assertEquals(claimsCount, pom.getClaimsList().size());
	}
	
	@When("the admin notes the Enquiries {string} value")
	public void the_admin_notes_the_enquiries_value(String string) {
	    String enquiriesCount = pom.getEnquiriesCount().getText();
	    System.out.println(enquiriesCount);
	}
	@When("the admin opens the Enquiries page")
	public void the_admin_opens_the_enquiries_page() {
		throw new PendingException("No admin Enquiries list page is available to compare with the Enquiries card");
	}
	@Then("the Total number of Enquiries listed should match the card value")
	public void the_total_number_of_enquiries_listed_should_match_the_card_value() {
		throw new PendingException("No admin Enquiries list page is available to compare with the Enquiries card");
	}

}
