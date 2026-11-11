package page_object_model;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base_Class;

public class PomClass extends Base_Class {
	
	public PomClass() {
		PageFactory.initElements(driver, this);
	}
	
	//login
	@FindBy(xpath = "//div[@class='flex items-center gap-2']/button[1]")
	private WebElement headerSignInBtn;
	
	

	@FindBy(xpath = "//input[@id = 'email']")
	private WebElement enterEmail;
	
	@FindBy(id = "password")
	private WebElement enterPassword;
	
	@FindBy(xpath = "(//button[text()='Sign in'])[2]")
	private WebElement clickSignIn;
	
	@FindBy(xpath = "//*[contains(text(),'Welcome back!')]")
	private WebElement welcomeToast;
	
	@FindBy(xpath = "//div[text()='Invalid credentials']")
	private WebElement InvalidToast;

	public WebElement getHeaderSignInBtn() {
		return headerSignInBtn;
	}

	public WebElement getInvalidToast() {
		return InvalidToast;
	}

	public WebElement getEnterEmail() {
		return enterEmail;
	}

	public String setEnterEmail() {
		//clickSignIn.click();
		//this.enterEmail = enterEmail;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].validationMessage;", getEnterEmail());
		
	}

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	public WebElement getClickSignIn() {
		return clickSignIn;
	}

	public WebElement getWelcomeToast() {
		return welcomeToast;
	}
	
	//User
	@FindBy(xpath = "(//span[normalize-space()='IA'])[2]")
	private WebElement clickProfileBtn;
	
	@FindBy(xpath = "//div[text()='Admin']")
	private WebElement clickAdminMenu;
	
	@FindBy(xpath = "//a[text()='Users']")
	private WebElement clickUserSideBar;
	
	@FindBy(xpath = "//div[contains(@class,'mt-6 rounded')]")
	private WebElement userTable;
	
	@FindBy(xpath = "//div[contains(@class,'mt-6 rounded')]/div/div")
	private List<WebElement> userTableHeader;
	
	@FindBy(xpath = "//div[text()='Role updated']")
	private WebElement roleUpdate;
	
	@FindBy(xpath = "//button[@role='combobox']")
	private List<WebElement> roleColumn;
	
	@FindBy(xpath = "//div[contains(@class,'mt-6 rounded')]//div[div[2]]/div[position()=2]")
	private List<WebElement> emailColumn;
	
	@FindBy(xpath = "//div[contains(@class,'mt-6 rounded')]//div[div[4]]/button")
	private List<WebElement> userDeleteBtn;
	
	@FindBy(xpath = "//div[@role='menu']")
	private WebElement menuSection;
	
	@FindBy(xpath = "//div[contains(@class,'mt-6 rounded')]/div[1]/div")
	private List<WebElement> tableHeader;
	
	@FindBy(xpath = "//div[text()='Find Local · Choose Better']")
	private WebElement userPage;
	
	@FindBy(xpath = "//span[text()='customer']")
	private WebElement selectCustomer;
	
	@FindBy(xpath = "//span[text()='business_owner']")
	private WebElement selectBussinessOwner;
	
	@FindBy(xpath = "//span[text()='admin']")
	private WebElement selectAdmin;
	
	public WebElement getSelectAdmin() {
		return selectAdmin;
	}

	@FindBy(xpath = "//div[normalize-space() = 'Karthick']/following-sibling::*//button[@role='combobox']")
	private WebElement tableRoleSelect;
	
	@FindBy(xpath = "//div[normalize-space() = 'Infoez Admin']/following-sibling::*//button[@role='combobox']")
	private WebElement tableAdminSelect;



	public WebElement getTableAdminSelect() {
		return tableAdminSelect;
	}

	public void setTableAdminSelect(WebElement tableAdminSelect) {
		this.tableAdminSelect = tableAdminSelect;
	}

	public WebElement getTableRoleSelect() {
		return tableRoleSelect;
	}

	public void setTableRoleSelect(WebElement tableRoleSelect) {
		this.tableRoleSelect = tableRoleSelect;
	}

	public WebElement getSelectCustomer() {
		return selectCustomer;
	}

	public WebElement getSelectBussinessOwner() {
		return selectBussinessOwner;
	}

	public WebElement getUserPage() {
		return userPage;
	}

	public List<WebElement> getTableHeader() {
		return tableHeader;
	}

	public void setTableHeader(List<WebElement> tableHeader) {
		this.tableHeader = tableHeader;
	}

	public WebElement getMenuSection() {
		return menuSection;
	}

	public WebElement getClickProfileBtn() {
		return clickProfileBtn;
	}

	public WebElement getClickAdminMenu() {
		return clickAdminMenu;
	}

	public WebElement getClickUserSideBar() {
		return clickUserSideBar;
	}

	public WebElement getUserTable() {
		return userTable;
	}

	public List<WebElement> getUserTableHeader() {
		return userTableHeader;
	}

	public List<WebElement> getRoleColumn() {
		return roleColumn;
	}

	public WebElement getRoleUpdate() {
		return roleUpdate;
	}


	public List<WebElement> getEmailColumn() {
		return emailColumn;
	}

	public List<WebElement> getUserDeleteBtn() {
		return userDeleteBtn;
	}
//	
//	private String rowXpath(String email) {
//		return "//div[contains(@class,'mt-6 rounded')]//div[div[normalize-space()='\"+email+\"']]";
//		
//	}
//	
//	public WebElement getDeleteBtn(String email) {
//		return driver.findElement(By.xpath(rowXpath(email)+ "/button"));
//		
//	}
	
	public WebElement getDeletePopUp() {
		return deletePopUp;
	}

	

	@FindBy(xpath = "//div[text()='Deleted']")
	private WebElement deletePopUp;
	
	
	//notification page
	@FindBy(xpath = "//div[text()='Notifications']")
	private WebElement clickNotification;
	
	@FindBy(xpath = "//div[contains(@class,\"rounded-xl border p-4\")]")
	private List<WebElement> notificationList;
	
	@FindBy(xpath = "//button[text()='Mark all read']")
	private WebElement markAllReadbtn;
	
	@FindBy(xpath = "(//button[contains(@class,\"text-xs text-primary hover:underline\")])[1]")
	private WebElement markRead;

	public WebElement getMarkRead() {
		return markRead;
	}

	public WebElement getClickNotification() {
		return clickNotification;
	}

	public List<WebElement> getNotificationList() {
		return notificationList;
	}

	public WebElement getMarkAllReadbtn() {
		return markAllReadbtn;
	}
	
	//claimPage
	@FindBy(xpath = "//a[text()='Claims']")
	private WebElement clickClaim;
	
	@FindBy(xpath = "//div[contains(@class,'rounded-2xl')][1]")
	private WebElement claimList;
	
	@FindBy(xpath = "(//div[contains(@class,'mt-3 flex gap-2')])[1]")
	private WebElement claimStatus;
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[2]")
	private WebElement claimBusiness;
	
	@FindBy(xpath = "(//button[text()='Approve'])[1]")
	private WebElement clickApprove;
	
	public WebElement getClickApprove() {
		return clickApprove;
	}

	@FindBy(tagName = "h1")
	private WebElement claimPage;

	public WebElement getClaimPage() {
		return claimPage;
	}

	public WebElement getClickClaim() {
		return clickClaim;
	}

	public WebElement getClaimList() {
		return claimList;
	}

	public WebElement getClaimStatus() {
		return claimStatus;
	}

	public WebElement getClaimBusiness() {
		return claimBusiness;
	}
	
	@FindBy(xpath = "(//button[text()='Approve'])[1]")
	private WebElement clickApproval;
	
	@FindBy(xpath = "//div[text()='Approved']")
	private WebElement approvalPopup;
	
	@FindBy(xpath = "(//a[text()='View proof →'])[1]")
	private WebElement viewProof;

	public WebElement getClickApproval() {
		return clickApproval;
	}

	public WebElement getApprovalPopup() {
		return approvalPopup;
	}

	public WebElement getViewProof() {
		return viewProof;
	}
	
	@FindBy(xpath = "//div[text()='Rejected']")
	private WebElement rejectedPopup;
	
	@FindBy(xpath = "(//button[text()='Reject'])[1]")
	private WebElement clickReject;

	public WebElement getRejectedPopup() {
		return rejectedPopup;
	}

	public WebElement getClickReject() {
		return clickReject;
	}
	
	//KPI cards
	@FindBy(xpath = "//div[contains(@class,'rounded-2xl')]/div[1]")
	private List<WebElement> kpiCards;

	public List<WebElement> getKpiCards() {
		return kpiCards;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[2]//div/following::div[1]")
	private WebElement pendingCount;
	
	@FindBy(xpath = "//a[@data-testid='admin-nav-pending']")
	private WebElement pendingSideBar;
	
	@FindBy(xpath = "//div[@class=\"rounded-2xl border border-border bg-card p-5 flex gap-4\"]")
	private List<WebElement> pendingList;

	public WebElement getPendingSideBar() {
		return pendingSideBar;
	}

	public List<WebElement> getPendingList() {
		return pendingList;
	}

	public WebElement getPendingCount() {
		return pendingCount;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[3]//div/following::div[1]")
	private WebElement usersCount;
	
	@FindBy(xpath = "//a[@data-testid='admin-nav-users']")
	private WebElement usersSideBar;
	
	@FindBy(xpath = "//div[contains(@class,'grid grid-cols-[1.5fr_2fr_1fr_1fr_auto] items-center')]")
	private List<WebElement> usersList;

	public WebElement getUsersCount() {
		return usersCount;
	}

	public WebElement getUsersSideBar() {
		return usersSideBar;
	}

	public List<WebElement> getUsersList() {
		return usersList;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[4]//div/following::div[1]")
	private WebElement businessCount;
	
	@FindBy(xpath = "//a[@data-testid='admin-nav-businesses']")
	private WebElement businessSideBar;
	
	@FindBy(xpath = "//div[contains(@class,'rounded-2xl border border-border')]")
	private List<WebElement> businessList;

	public WebElement getBusinessCount() {
		return businessCount;
	}

	public WebElement getBusinessSideBar() {
		return businessSideBar;
	}

	public List<WebElement> getBusinessList() {
		return businessList;
	}
	
	@FindBy(xpath = "//div[text()='Verified']")
	private List<WebElement> verifiedBadgesList;
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[5]//div/following::div[1]")
	private WebElement verifiedCount;

	public List<WebElement> getVerifiedBadgesList() {
		return verifiedBadgesList;
	}

	public WebElement getVerifiedCount() {
		return verifiedCount;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[6]//div/following::div[1]")
	private WebElement reviewsCount;

	public WebElement getReviewsCount() {
		return reviewsCount;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[8]//div/following::div[1]")
	private WebElement claimsCount;
	
	@FindBy(xpath = "//a[@data-testid='admin-nav-claims']")
	private WebElement claimsSideBar;
	
	public WebElement getClickOverview() {
		return clickOverview;
	}

	@FindBy(xpath = "//div[text()='pending']")
	private List<WebElement> claimsList;

	public WebElement getClaimsCount() {
		return claimsCount;
	}

	public WebElement getClaimsSideBar() {
		return claimsSideBar;
	}

	public List<WebElement> getClaimsList() {
		return claimsList;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'flex items-center justify-between')])[7]//div/following::div[1]")
	private WebElement enquiriesCount;

	public WebElement getEnquiriesCount() {
		return enquiriesCount;
	}
	
	//AccountMenu
	@FindBy(xpath = "//div[@role=\"menuitem\"]")
	private List<WebElement> adminMenuSection;
	
	public List<WebElement> getAdminMenuSection() {
		return adminMenuSection;
	}
	
	@FindBy(xpath = "//div[@data-testid='menu-logout']")
	private WebElement clickSignOut;
	
	@FindBy(xpath = "//button[@data-testid='header-signin-btn']")
	private WebElement signInHeader;

	public WebElement getClickSignOut() {
		return clickSignOut;
	}

	public WebElement getSignInHeader() {
		return signInHeader;
	}
	
	@FindBy(tagName = "h1")
	private WebElement pageHeader;

	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	//ProfilePage
	@FindBy(xpath = "//div[text()='Profile']")
	private WebElement clickProfile;

	public WebElement getClickProfile() {
		return clickProfile;
	}
	
	@FindBy(xpath = "//input[@data-testid='profile-name']")
	private WebElement profileEmailField;

	public WebElement getProfileEmailField() {
		return profileEmailField;
	}
	
	@FindBy(xpath = "//input[@data-testid='profile-name']")
	private WebElement profileNameField;
	
	@FindBy(xpath = "//button[text()='Save changes']")
	private WebElement clickSaveAndChange;

	public WebElement getProfileNameField() {
		return profileNameField;
	}

	public WebElement getClickSaveAndChange() {
		return clickSaveAndChange;
	}
	
	@FindBy(xpath = "//div[text()='Profile updated']")
	private WebElement savePopUp;

	public WebElement getSavePopUp() {
		return savePopUp;
	}
	
	//Favorites
	@FindBy(xpath = "//div[@data-testid='menu-favorites']")
	private WebElement clickFavorites;

	public WebElement getClickFavorites() {
		return clickFavorites;
	}
	
	@FindBy(xpath = "//button[contains(@aria-label,\"Toggle favorite\")]")
	private List<WebElement> favoritesList;
	
	@FindBy(xpath = "//a[text()='Explore']")
	private WebElement clickExplore;
	
	@FindBy(xpath = "(//button[contains(@aria-label,\"Toggle favorite\")])[1]")
	private WebElement firstBusinessFavorites;
	
	@FindBy(id = "radix-:r3:")
	private WebElement favoriteHeader;
	
	@FindBy(xpath = "(//button[@aria-label=\"Toggle favorite\"])[1]")
	private WebElement removeFavorites;

	public WebElement getRemoveFavorites() {
		return removeFavorites;
	}

	public WebElement getFavoriteHeader() {
		return favoriteHeader;
	}

	public List<WebElement> getFavoritesList() {
		return favoritesList;
	}

	public WebElement getClickExplore() {
		return clickExplore;
	}

	public WebElement getFirstBusinessFavorites() {
		return firstBusinessFavorites;
	}
	
	//pending
	@FindBy(xpath = "//a[@data-testid='admin-nav-pending']")
	private WebElement clickPending;
	
	@FindBy(xpath = "(//button[text()='Approve'])[1]")
	private WebElement pendingApprove;
	
	@FindBy(xpath = "(//button[text()='Reject'])[1]")
	private WebElement pendingReject;

	public WebElement getClickPending() {
		return clickPending;
	}

	public WebElement getPendingApprove() {
		return pendingApprove;
	}

	public WebElement getPendingReject() {
		return pendingReject;
	}
	
	@FindBy(xpath = "//div[contains(@class,'rounded-2xl border')]")
	private List<WebElement> pendingPageList;
	
	@FindBy(xpath = "//div[text()='Listing approved']")
	private WebElement pendingPopUp;

	public List<WebElement> getPendingPageList() {
		return pendingPageList;
	}

	public WebElement getPendingPopUp() {
		return pendingPopUp;
	}
	
	@FindBy(xpath = "//button[text()='Reject listing']")
	private WebElement rejectListingBtn;
	
	@FindBy(xpath = "//textarea[@data-testid=\"reject-reason-input\"]")
	private WebElement enterMessageInReject;
	
	@FindBy(xpath = "//div[text()='Listing rejected']")
	private WebElement rejectedPopUp;

	public WebElement getRejectListingBtn() {
		return rejectListingBtn;
	}

	public WebElement getEnterMessageInReject() {
		return enterMessageInReject;
	}

	public WebElement getRejectedPopUp() {
		return rejectedPopUp;
	}
	
	//category
	@FindBy(xpath = "//a[@data-testid='admin-nav-categories']")
	private WebElement clickCategories;

	public WebElement getClickCategories() {
		return clickCategories;
	}
	
	@FindBy(tagName = "input")
	private WebElement newCategoryField;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement clickCategoryAddBtn;
	
	@FindBy(xpath = "//div[@class='font-semibold']")
	private List<WebElement> cateoryList;

	public WebElement getNewCategoryField() {
		return newCategoryField;
	}

	public WebElement getClickCategoryAddBtn() {
		return clickCategoryAddBtn;
	}

	public List<WebElement> getCateoryList() {
		return cateoryList;
	}
	
	@FindBy(xpath = "//div[text()='QA Test Category']/following::button")
	private WebElement categoryDeleteBtn;

	public WebElement getCategoryDeleteBtn() {
		return categoryDeleteBtn;
	}
	
	//business
	@FindBy(xpath = "//a[@data-testid='admin-nav-businesses']")
	private WebElement clickBusiness;
	
	@FindBy(xpath = "//div[contains(@class,'rounded-2xl border')]")
	private List<WebElement> businessPageList;

	public WebElement getClickBusiness() {
		return clickBusiness;
	}

	public List<WebElement> getBusinessPageList() {
		return businessPageList;
	}
	
	@FindBy(xpath = "//a[@data-testid='admin-nav-overview']")
	private WebElement clickOverview;
	
	@FindBy(xpath = "(//button[contains(.,'Verif')])[1]")
	private WebElement VerifyToggleBtn;

	public WebElement getVerifyToggleBtn() {
		return VerifyToggleBtn;
	}
	
	
	//review
	@FindBy(xpath = "//div[@data-testid='menu-reviews']")
	private WebElement clickMyReview;

	public WebElement getClickMyReview() {
		return clickMyReview;
	}
	
	@FindBy(xpath = "(//a[contains(@class,'group relative flex flex-col rounded-2xl border')])[1]")
	private WebElement reviewFirstElement;
	
	@FindBy(xpath = "//button[text()='Write a review']")
	private WebElement clickWriteReview;
	
	@FindBy(xpath = "//textarea[@data-testid=\"review-comment\"]")
	private WebElement enterReviewComment;
	
	@FindBy(xpath = "//button[text()='Post review']")
	private WebElement clickPostReview;
	
	@FindBy(xpath = "//button[@data-testid='review-star-1']")
	private WebElement oneStarRatingBtn;
	
	@FindBy(xpath = "//button[@data-testid='review-star-5']")
	private WebElement fiveStarRatingBtn;

	public WebElement getReviewFirstElement() {
		return reviewFirstElement;
	}

	public WebElement getClickWriteReview() {
		return clickWriteReview;
	}

	public WebElement getEnterReviewComment() {
		return enterReviewComment;
	}

	public WebElement getClickPostReview() {
		return clickPostReview;
	}

	public WebElement getOneStarRatingBtn() {
		return oneStarRatingBtn;
	}

	public WebElement getFiveStarRatingBtn() {
		return fiveStarRatingBtn;
	}
	
	@FindBy(xpath = "//*[local-name()='svg' and contains(@class,'fill-amber-500')]")
	private List<WebElement> starCount;

	public List<WebElement> getStarCount() {
		return starCount;
	}

}
