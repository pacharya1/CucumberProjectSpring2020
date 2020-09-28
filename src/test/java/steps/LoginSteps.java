package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.BasePage;
import page.DashBoardPage;
import page.LoginPage;
import util.Assertion;
import util.BrowserFactory;
import util.Database;

public class LoginSteps extends BasePage {

	WebDriver driver;
	LoginPage login;
	DashBoardPage dashboardpage;
	Database database;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.init();
		login = PageFactory.initElements(driver, LoginPage.class);
		dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
	
	}
	@Given("^I am on Techfios site$")
	public void i_am_on_Techfios_site() {
	    	
	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		login.enterUserName(Database.get("username"));
		login.enterPassword(Database.get("password"));
		Thread.sleep(3000);
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String username, String password) throws Throwable {
		login.enterUserName("username");		
		login.enterPassword("password");
		screenShot (driver,"C:\\Users\\ajayk\\Desktop\\test\\screenshot.jpj");
		
		
	}

	@When("^I click on sign in button$")
	public void i_click_on_sign_in_button() throws Throwable {
		login.clickSignInButton();

	}

	@Then("^Dashboard page should display$")
	public void dashboard_page_should_display() throws Throwable {
		String expected = "Dashboard- iBilling";
		Assertion.equals("Wrong Page Displayed", dashboardpage.getPageTitle(), expected);
	}

	@After
	public static void afterRun() {
		BrowserFactory.tearDown();
	}

}
