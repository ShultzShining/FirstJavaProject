package com.github.automation.tutorial.Misc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.sun.jna.platform.FileUtils;
import com.thoughtworks.selenium.Wait;

public class Practice {

	private static WebDriver driver;
	
	
	
	@BeforeTest
	
	public void setUp() throws Exception{
		
		driver= new FirefoxDriver();
		
		
		
	}
	
	@AfterTest
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	
	public void test() throws FileNotFoundException{
		
		//driver.get("http://www.amazon.in");
		
		//Read data from a excel file
		String Filename= "C:/Users/shashi.prasad/Desktop/Login functionality.xlsx";
		File file = new File(Filename);
		FileInputStream fis= new FileInputStream(file);
		String FileExtensionName= Filename.substring(Filename.indexOf("."));
		
		Workbook workbook= null;
		if(FileExtensionName.equals(".xlsx")){
			workbook= new XSSFWorkbook();
		}else{
			workbook=new HSSFWorkbook();
		}
		
		Sheet sheet= workbook.getSheet("Test Cases");
		
		int RowCount= sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0;i<RowCount+1;i++){
			Row row= sheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++){
				System.out.println(row.getCell(j).getStringCellValue()+ "||");
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
