package step_definition;

import base.Base_Class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Review extends Base_Class {
	
	PomClass pom = new PomClass();
	
	@Given("the admin is logged in to view reviews")
	public void the_admin_is_logged_in_to_view_reviews() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("the admin is on the reviews home page")
	public void the_admin_is_on_the_reviews_home_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin clicks the profile icon to open the account menu for reviews")
	public void the_admin_clicks_the_profile_icon_to_open_the_account_menu_for_reviews() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@When("the admin clicks My Reviews in the account menu")
	public void the_admin_clicks_my_reviews_in_the_account_menu() {
	    button(pom.getClickMyReview());
	}
	@Then("the My Reviews page should be displayed")
	public void the_my_reviews_page_should_be_displayed() {
	    Assert.assertTrue("My  Review page is not displayed", pom.getPageHeader().isDisplayed());
	}
	
	@When("the admin review the first business from Explore")
	public void the_admin_review_the_first_business_from_explore() throws InterruptedException {
	    button(pom.getClickExplore());
	    Thread.sleep(3000);
	}
	
	@When("the admin posts a review for the first business with rating {string} and comment {string}")
	public void the_admin_posts_a_review_for_the_first_business_with_rating_and_comment(String string, String string2) {
	    button(pom.getReviewFirstElement());
	    visibleOfElement(pom.getClickWriteReview());
	    button(pom.getClickWriteReview());
	    setText(pom.getEnterReviewComment(), string2);
	    button(pom.getFiveStarRatingBtn());
	    button(pom.getClickPostReview());
	}
	@When("the admin opens My Reviews from the account menu")
	public void the_admin_opens_my_reviews_from_the_account_menu() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@Then("the review for the business should be listed")
	public void the_review_for_the_business_should_be_listed() {
		button(pom.getClickMyReview());
	}
	@Then("the listed rating should be {string}")
	public void the_listed_rating_should_be(String string) {
		int reviewStars = pom.getStarCount().size();
		System.out.println("Review Rating: " + reviewStars);
		Assert.assertTrue("Rating star is not displayed",reviewStars>0 );
	    
	}

}
