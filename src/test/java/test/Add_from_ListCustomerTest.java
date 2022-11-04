package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddCuctomer;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserFactory;

public class Add_from_ListCustomerTest extends BasePage{

	// 1.Global variables
		WebDriver driver;

		@Test
		@Parameters({ "username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "city", "Country", "state", "Zip"})  
									
		public void AddFromListCustomer(String username, String password, String FullName, String CompanyName, String Email, String Phone, String Address, String city, String Country, String state, String Zip) throws InterruptedException { 
			driver = BrowserFactory.inut();
			LoginPage Pagex = PageFactory.initElements(driver, LoginPage.class);

			Pagex.enterUN(username);
			Pagex.enterPW(password);
			Pagex.clickLG();

			DashboardPage pgx = PageFactory.initElements(driver, DashboardPage.class);
			pgx.dashboard("Contacts", "Contacts", "title not found");
			

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

