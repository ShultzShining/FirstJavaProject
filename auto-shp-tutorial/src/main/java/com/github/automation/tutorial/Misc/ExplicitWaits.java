package com.github.automation.tutorial.Misc;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaits {
	private static WebDriver driver;
	
	@BeforeClass
	public void setup(){
		driver= new FirefoxDriver();
		
	}
	
	/*@AfterClass
	public void tearDown(){
		driver.close();
		driver.quit();
	}*/
	
	@BeforeMethod
	public void openHomepage(){
		String url="http://naukri.com";
		driver.get(url);
	}
	
	@Test
	public void TestExample() throws IOException{
		
		/*
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		WebElement element= driver.findElement(By.xpath("//p[text()='WebDriver']"));
		
		Boolean flag= element.isDisplayed();
		
		if(flag){
			System.out.println("Element is displayed");
		}
		else{
			System.out.println("Element is not displayed");
		}
		
	*/
		//File upload
		//WebElement E1= driver.findElement(By.xpath(".//*[contains(@type,'file')"));
		//E1.sendKeys("C:/Users/shashi.prasad/Downloads/23695_pets_vertical_store_dogs_small_tile_8._CB312176604.jpg");
		
		//driver.findElement(By.id("uploadifive-file_upload")).click();
		//Auto it
		
		//Runtime.getRuntime().exec("C:/Users/shashi.prasad/Desktop/fileUpload.exe");
		
		
		
		//multiple windows handling
		String WindowTitle= getCurrentWindowTitle();
		String mainWindow= getMainWindowHandle(driver);
		
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue("Windows title is not matching", WindowTitle.contains("Jobs- Recruitment"));
		
	}
		public String getCurrentWindowTitle(){
			String WindowTitle= driver.getTitle();
			return WindowTitle;
			
				
		}
		
		public String getMainWindowHandle(WebDriver driver){
			return driver.getWindowHandle();
			
		}
		
		public boolean closeAllOtherWindows(String openWindowHandle){
			Set<String> allWindowsHandles= driver.getWindowHandles();
			for(String currentWindowhandle: allWindowsHandles){
				if(!currentWindowhandle.equals(openWindowHandle)){
					driver.switchTo().window(currentWindowhandle);
					driver.close();
				}
			}
			
			driver.switchTo().window(openWindowHandle);
			if(driver.getWindowHandles().size()==1){
				return true;
			}
			else{
				return false;
			}
		}
		
		
	}


