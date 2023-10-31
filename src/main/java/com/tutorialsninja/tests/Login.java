package com.tutorialsninja.tests;

import java.sql.Date;
import java.sql.DriverManager;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Login {
	
	@Test (priority = 1)
	public void VerifyLoginWithValidCredentials() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); //Lanch Chrome Browser
		driver.manage().window().maximize(); //Maximize browser window
		driver.get("https://tutorialsninja.com/demo/");//Application URL is open in the chrome
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("mohith77reddy@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Mohith@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	
	@Test (priority = 2)
	public void VerifyLoginWithInvalidCredentials() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); //Lanch Chrome Browser
		driver.manage().window().maximize(); //Maximize browser window
		driver.get("https://tutorialsninja.com/demo/");//Application URL is open in the chrome
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Mohith@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		driver.quit();
		
	}
	
	public String generateEmailTimeStamp() {
		Date date = new Date(0);
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
		
	}
	
}
