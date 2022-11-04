package test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginTest {

	// 1.Global variables
	WebDriver driver;
	String UserName = null;                  
	String PassWord = null;              
	@Test
	@Parameters({"username", "password"}) // should declared accordingly as placed in method parameters    
	public void loginTest1(String username, String password) { // smoke test
		driver = BrowserFactory.inut(); 
		LoginPage Pagex = PageFactory.initElements(driver, LoginPage.class);  // evoking constructor (LoginPage.class)																// LoginPage
		
		Pagex.enterUN(username);
		Pagex.enterPW(password);
		Pagex.clickLG();
	

		DashboardPage pgx = PageFactory.initElements(driver, DashboardPage.class);
		pgx.dashboard("DashBoard", "DashBoard", "title not found");

        BrowserFactory.tearDown();
	}	
}
