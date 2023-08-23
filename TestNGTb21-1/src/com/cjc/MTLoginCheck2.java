package com.cjc;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MTLoginCheck2
{

	WebDriver driver;

	@BeforeSuite
	public void openBrowser()
	{
		System.out.println("This is Selenium");
		System.setProperty("webdriver.chrome.driver", "D:\\DestopData\\BATCH Details\\Testing Batch\\TB-21-B\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("This is Before Suite Annotation");
	}

	@BeforeTest
	@Parameters("url")
	public void enterUrl(String ur)
	{
		driver.get(ur);
		System.out.println("This is Before Test Annotation");
	}

	@BeforeClass
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
		System.out.println("This is Before Class");
	}

	@BeforeMethod
	public void getCookiesDetails()
	{
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Total No of Cookies"+cookies.size());
		System.out.println("This is BeforeMethod Annotation");
	}

	@Test
	@Parameters({"uname","pass"})
	public void alogincheck(String un,String pss) throws InterruptedException
	{
		System.out.println("LoginCheck");
		System.out.println("Enter Username");
		WebElement us=driver.findElement(By.name("userName"));

		us.sendKeys(un);
		System.out.println("Enter Password");
		WebElement ps=driver.findElement(By.name("password"));

		ps.sendKeys(pss);

		driver.findElement(By.name("submit")).click();

		System.out.println("This is Test Method");

		driver.navigate().back();

		//Thread.sleep(2000);
		//us.clear();
		//	ps.clear();
	}

	@Test
	@Parameters({"uname1","pass1"})
	public void alogincheck1(String un,String pss) throws InterruptedException
	{
		System.out.println("LoginCheck");
		System.out.println("Enter Username");
		WebElement us=driver.findElement(By.name("userName"));

		us.sendKeys(un);
		System.out.println("Enter Password");
		WebElement ps=driver.findElement(By.name("password"));

		ps.sendKeys(pss);

		driver.findElement(By.name("submit")).click();

		System.out.println("This is Test Method");

		driver.navigate().back();

		//Thread.sleep(2000);
		//us.clear();
		//	ps.clear();
	}

	
	/*
	 * @Test public void bflightBooking() { System.out.println("Login Success");
	 * driver.findElement(By.xpath(
	 * "/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a"
	 * )).click(); System.out.println("Flight Booking"); }
	 */





	@AfterMethod
	public void captureSc() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("D:\\DestopData\\BATCH Details\\Testing Batch\\TB_21\\Sc"));
		System.out.println("This is After Method");
	}

	@AfterClass
	public void deleteCookies()
	{
		System.out.println("Delete Cookies");
		System.out.println("After Class");
	}

	@AfterTest
	public void dbClose()
	{
		System.out.println("DB Close");
		System.out.println("After Test");
	}

	@AfterSuite
	public void closeBrowser()
	{
		//	driver.close();
		System.out.println("After Suite");
	}

	/*
	 * @DataProvider public Object[][] getData() { return new Object[][] { new
	 * Object[] {"QQQQ","qqqq"}, new Object[] {"AAAA","aaaa"}, new
	 * Object[]{"ZZZZ","zzzz"} }; }
	 */





}
