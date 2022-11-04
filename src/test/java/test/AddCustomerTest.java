package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddCuctomer;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserFactory;

public class AddCustomerTest {

	// 1.Global variables
	WebDriver driver;

	String UserName = null;
	String PassWord = null;
	String FullName = null;
	String CompanyName = null;
	String Email = null;
	String Phone = null;
	String Address = null;
	String City = null;
	String Country = null;
	String state = null;
	String Zip = null;

	@Test
	@Parameters({ "username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "city", "Country", "state", "Zip"}) // should declared accordingly as placed in method parameters
											// "username" = A, "password" = B
	public void loginTest1(String username, String password, String FullName, String CompanyName, String Email, String Phone, String Address, String city, String Country, String state, String Zip) throws InterruptedException { // regression test : test specific fonctionality
		driver = BrowserFactory.inut();
		LoginPage Pagex = PageFactory.initElements(driver, LoginPage.class);

		Pagex.enterUN(username);
		Pagex.enterPW(password);
		Pagex.clickLG();

		DashboardPage pgx = PageFactory.initElements(driver, DashboardPage.class);
		pgx.dashboard("DashBoard", "DashBoard", "title not found");

		AddCuctomer fil = PageFactory.initElements(driver, AddCuctomer.class);
		fil.custom();
		fil.adding();
		fil.naming(FullName);
		fil.companing(CompanyName);
		fil.emailing(Email);
	    fil.phoneing(Phone);
		fil.addressing(Address);
		fil.citing(city);
		fil.stating(state);
		fil.ziping(Zip);
		fil.countring(Country);
		fil.saving();
		fil.Sumary();
		fil.Listing();
		Thread.sleep(2000);
		fil.VerifyEntredName();
		Thread.sleep(2000);
		fil.deletedNameEntred();
		Thread.sleep(2000);
		fil.deliting();
	}  
	   
}
