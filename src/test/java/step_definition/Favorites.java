package step_definition;

import base.Base_Class;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page_object_model.PomClass;

public class Favorites extends Base_Class {
	
	PomClass pom = new PomClass();
	int favoritesBefore;
	int favoritesFirst;
	
	@Given("the admin has signed in with the Infoez account")
	public void the_admin_has_signed_in_with_the_infoez_account() {
		driver.get("https://d2mojgetgp5xie.cloudfront.net/login");
		setText(pom.getEnterEmail(), "admin@infoez.com");
		setText(pom.getEnterPassword(), "Admin@123");
		button(pom.getClickSignIn());
		waitImpletic();
	}
	@Given("the admin is shown the landing page")
	public void the_admin_is_shown_the_landing_page() {
		visibleOfElement(pom.getUserPage());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://d2mojgetgp5xie.cloudfront.net/", currentUrl);
	}
	@When("the admin clicks the profile icon to reach the account menu")
	public void the_admin_clicks_the_profile_icon_to_reach_the_account_menu() throws InterruptedException {
		Thread.sleep(6000);
	    button(pom.getHeaderSignInBtn());
	}
	@When("the admin clicks Favorites in the account menu")
	public void the_admin_clicks_favorites_in_the_account_menu() {
	    button(pom.getClickFavorites());
	}
	@Then("the favorites page should be displayed")
	public void the_favorites_page_should_be_displayed() {
	    Assert.assertTrue("Favorites page is not displayed", pom.getPageHeader().isDisplayed());
	}
	
	@When("the admin notes the number of favorites")
	public void the_admin_notes_the_number_of_favorites() {
	     favoritesBefore = pom.getFavoritesList().size();
	    Assert.assertTrue("Favorities are not displayed", favoritesBefore>0);
	    System.out.println("Favorites count before adding new Favorite: "+ favoritesBefore);
	}
	@When("the admin favorites the first business from Explore")
	public void the_admin_favorites_the_first_business_from_explore() throws InterruptedException {
	    button(pom.getClickExplore());
	    Thread.sleep(3000);
	    visibleOfElement(pom.getFirstBusinessFavorites());
	    button(pom.getFirstBusinessFavorites());
	    Thread.sleep(8000);
	    
	}
	@When("the admin returns to the favorites page")
	public void the_admin_returns_to_the_favorites_page() {
		visibleOfElement(pom.getFavoriteHeader());
		pom.getFavoriteHeader().click();
		button(pom.getClickFavorites());
	}
	@Then("the favorites count should change by {int}")
	public void the_favorites_count_should_change_by(Integer int1) {
		int favoritesAfter = pom.getFavoritesList().size();
		System.out.println("Favorites after: " + favoritesAfter);
		Assert.assertEquals("Favorites count is not updated", favoritesBefore, favoritesAfter);
	}
	
	@When("the admin note the number of favorites")
	public void the_admin_note_the_number_of_favorites() {
		favoritesFirst = pom.getFavoritesList().size();
	    Assert.assertTrue("Favorities are not displayed", favoritesFirst>0);
	    System.out.println("Favorites count before adding new Favorite: "+ favoritesFirst);
	}
	@When("the admin removes the first favorite")
	public void the_admin_removes_the_first_favorite() throws InterruptedException {
	    button(pom.getRemoveFavorites());
	    Thread.sleep(3000);
	}
	@Then("the favorite count should change by {int}")
	public void the_favorite_count_should_change_by(Integer int1) {
		int favoritesAfter = pom.getFavoritesList().size();
		System.out.println("Favorites after: " + favoritesAfter);
		Assert.assertEquals("Favorites count is not updated after removed", favoritesFirst, favoritesAfter);
	}
	
	

}
