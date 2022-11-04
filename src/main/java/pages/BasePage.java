package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	int i = RAND(555);
	
	
	public void SELECT(WebElement Welement, String visibiletext) {
		Select sel = new Select(Welement);
		sel.selectByVisibleText(visibiletext);
	}

	public int RAND(int i) {
		Random rnd = new Random();
		int dom = rnd.nextInt(i);
		return dom;
	}
	public void WaitForElement(WebDriver driver, int TimeBySecond, WebElement ElementName) {
		WebDriverWait wait = new WebDriverWait(driver, TimeBySecond);
		wait.until(ExpectedConditions.visibilityOf(ElementName));
		
	}
 
}
