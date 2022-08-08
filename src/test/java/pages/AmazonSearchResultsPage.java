package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonSearchResultsPage extends utils.Parent {

	public AmazonSearchResultsPage(WebDriver drive) {
		super(drive);
	}

	public void verifySearchResult() {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(elementCss(".a-color-state.a-text-bold").isDisplayed());
	}

	public void navigateToProduct() {
		elementCss("a[class*='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
				.click();
	}

}
