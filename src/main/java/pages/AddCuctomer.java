package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCuctomer extends BasePage {

	WebDriver driver;

	public AddCuctomer(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement customer;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement add;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement name;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement company;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement email;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement phone;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement address;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement city;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement state;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement zip;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement country;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement save;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement smr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement list;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")
	WebElement popup_ok;
//	@FindBy(how = How.XPATH, using = "//tbody/tr/td[7]/a[@class='btn btn-danger btn-xs cdelete']")
//	WebElement delete;
// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	
	public void custom() {
		customer.click();
	}

	public void adding() {
		add.click();
	}
	String generatedName;               //deal with naming and VerifyEntredName
	public void naming(String name1) {
		 generatedName = name1 + i;
		name.sendKeys(generatedName);
		
	}

	public void companing(String company1) {
		company.sendKeys(company1);
	}

	public void emailing(String email1) {
		email.sendKeys(email1 + i);
	}

	public void phoneing(String phone1) {
		phone.sendKeys(phone1 + i);
	}

	public void addressing(String address1) {
		address.sendKeys(address1);
	}

	public void citing(String city1) {
		city.sendKeys(city1);
	}

	public void stating(String state1) {
		state.sendKeys(state1);
	}

	public void ziping(String zip1) {
		zip.sendKeys(zip1);
	}

	public void countring(String country1) {
		country.sendKeys(country1);
	}

	public void saving() {
		save.click();
	}

	// instead to call summuray do reverse engenering by
//	public void Sumuary() {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOf(summary));
//		WaitForElement(driver, 5, summary):
//	}
	// creating custom method in BasePage
	public void Sumary() {
		WaitForElement(driver, 5, smr);
		Assert.assertEquals(smr.getText(), "Summary", "wrong page");
	}

	public void Listing() {
		list.click();
	}
	
	// tbody/tr[1]/td[3],   // tbody/tr[2]/td[3]
	
	// tbody/tr[i]/td[3]
	// tbody/tr[i]/td[7]/a[@class='btn btn-danger btn-xs cdelete']
	String beforeXpath = "//tbody/tr[";  //beforeXpath +i+ afterXpath = EnterdName
	String afterXpath = "]/td[3]";
    String afterXpathDelete = "]/td[7]/a[@class='btn btn-danger btn-xs cdelete']"; //beforeXpath +i+ afterXpathDelete = deletingName
	public void VerifyEntredName() {
		for (int i = 1; i <= 10; i++) {
			// instead driver.findElement(By.xpath("//tbody/tr[i]/td[3]")); using global
			// Sting before and after
			String EnterdName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			//enterdname is local, generatedname global variable 
			System.out.println(EnterdName);
			Assert.assertEquals(EnterdName, generatedName, "name dosen't exist!!");
			break;
		}
		
	}
	public void deletedNameEntred() {
		for (int i = 1; i <= 10; i++) {
			String EnterdName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
		  if(EnterdName.contains(generatedName)) {
			  System.out.println("this name exist already!!");
			  driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click(); // delete button
		  }
		  break;
		}
		}
					
		public void deliting() {
			popup_ok.click();
		
	}

//instead to create select and random class  create inheritance from base_page//////////////////////
//	public void SELECT(WebElement Welement, String visibiletext) {
//		Select sel = new Select(Welement);
//		sel.selectByVisibleText(visibiletext);
//	}
//
//	public int RAND(int i) {
//		Random rnd = new Random();
//		int dom = rnd.nextInt(i);
//		return dom;
//	}
}
