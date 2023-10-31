package tn.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hard_Soft_Assertions {
	
	@Test
	public void sampleMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		SoftAssert softAssert = new SoftAssert();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Your StoreA";
		
		softAssert.assertEquals(actualTitle, expectedTitle);
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://tutorialsninja.com/demo/a";
		
		softAssert.assertEquals(actualURL, expectedURL);
		
		driver.findElement(By.name("search")).sendKeys("HP",Keys.ENTER);
		
		assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		driver.quit();
		softAssert.assertAll();
		
	}

}
