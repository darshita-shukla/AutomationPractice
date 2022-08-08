package utils;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Parent {
	WebDriver drive;

	public Parent(WebDriver drive) {
		this.drive = drive;
	}

	public WebElement elementCss(String token) {
		return drive.findElement(By.cssSelector(token));
	}


}
