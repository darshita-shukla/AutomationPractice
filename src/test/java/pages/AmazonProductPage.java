package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonProductPage extends utils.Parent {

	public AmazonProductPage(WebDriver drive) {
		super(drive);
	}

	public void verifyProductPage() {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(elementCss("#productTitle").isDisplayed());
	}

	public void navigateToCart() {
		elementCss("#add-to-cart-button").click();
	}
}
