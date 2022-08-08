package tests;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.deque.html.axecore.providers.FileAxeScriptProvider;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;

import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonSearchResultsPage;
import utils.Parent;

public class AmazonTest {
	WebDriver drive;
	String scriptUrl;
	Parent obj;
	AmazonHomePage homePage;
	AmazonSearchResultsPage searchPage;
	AmazonProductPage productPage;
	AmazonCartPage cartPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\darshita.shukla\\eclipse-workspace\\AutomationPractice\\src\\test\\resources\\drivers\\chromedriver.exe");
		drive = new ChromeDriver();
		obj = new Parent(drive);
		homePage = new AmazonHomePage(drive);
		searchPage = new AmazonSearchResultsPage(drive);
		productPage = new AmazonProductPage(drive);
		cartPage = new AmazonCartPage(drive);
		drive.get("https://www.amazon.in/");
		drive.manage().window().maximize();
		initVars();
	}

	private void initVars() {
		scriptUrl = "src/test/resources/axe.min.js";
	}

	@Test
	public void Step01_VerifyUserisOnAmazonHomePage() throws Exception {
		homePage.verifyHomePage();
		axeTest("AmazonHomePageViolations");
	}

	@Test
	public void Step02_SearchAndNavigateToSearchResultsPage() {
		homePage.enterText("Bottle");
		homePage.clickSearchButton();
	}

	@Test
	public void Step03_VerifyUserisOnSearchResultsPage() throws Exception {
		searchPage.verifySearchResult();
		axeTest("AmazonSearchResultsPageViolations");
	}

	@Test
	public void Step04_NavigateToProduct() {
		searchPage.navigateToProduct();
	}

	@Test
	public void Step05_VerifyProductPage() throws Exception {
		Set<String> windows=drive.getWindowHandles();
		Iterator<String> i=windows.iterator();
		String window;
		while(i.hasNext()) {
			window=i.next();
			drive.switchTo().window(window);
		}
		productPage.verifyProductPage();
		axeTest("AmazonProductPageViolations");
	}

	@Test
	public void Step06_NavigateAndVerifyCartPage() throws Exception {
		productPage.navigateToCart();
		cartPage.verifyCartPage();
		axeTest("AmazonCartPageViolations");
	}
	public void axeTest(String pageName) throws Exception {
		AxeBuilder builder=new AxeBuilder();
		Results response = builder.analyze(drive);
		List<Rule> violations = response.getViolations();
		if (violations.size() == 0)
			System.out.println("No violations");
		else {
			AxeReporter.writeResultsToTextFile(pageName, violations);
		}

	}
}
