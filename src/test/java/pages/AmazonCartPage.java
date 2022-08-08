package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonCartPage extends utils.Parent {

	public AmazonCartPage(WebDriver drive) {
		super(drive);
	}

	public void verifyCartPage() {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(elementCss(".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold").isDisplayed());
	}
}
