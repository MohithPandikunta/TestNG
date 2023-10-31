package tn.TestNG;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionTrue {
	
	@Test
	public void sampleMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.name("search")).sendKeys("Bike", Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		driver.quit();
		
	}
	

}
