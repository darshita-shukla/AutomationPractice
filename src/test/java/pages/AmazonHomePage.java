package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonHomePage extends utils.Parent {

	public AmazonHomePage(WebDriver drive) {
		super(drive);
	}

	public void verifyHomePage() {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(elementCss("input[aria-label='Search']").isDisplayed());
	}

	public void enterText(String product) {
		elementCss("input[aria-label='Search']").sendKeys(product);
	}

	public void clickSearchButton() {
		elementCss("#nav-search-submit-button").click();
	}
}
