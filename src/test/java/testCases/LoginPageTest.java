package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;



public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;	

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority=1)
	public void loginTest() throws InterruptedException, IOException   {
		loginpageObj.enterUserName("demo@techfios.com");		
		Thread.sleep(2000);
		
		loginpageObj.enterPassword("abc123");
		Thread.sleep(2000);
		
		loginpageObj.clickSignInButton();
		
		takeScreenshotAtEndOfTest(driver);
	}
	

	@Test(priority=2)
	public void loginpageTitleTest() throws Exception {
		loginpageObj.enterUserName("demo@techfios.com");		
		Thread.sleep(2000);
		
		loginpageObj.enterPassword("abc123");
		Thread.sleep(2000);
		
		loginpageObj.clickSignInButton();
		
		String expectedTitle="Dashboard- iBilling";
		String actualTitle=loginpageObj.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	/*
	
	@Test(priority=3)
	public void loginDataFromMySqlDBTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		loginpageObj.enterUserName(DatabasePage.getData("username"));
		String uName=DatabasePage.getData("username");
		System.out.println("username: "+ uName);		
		Thread.sleep(2000);
		
		loginpageObj.enterPassword(DatabasePage.getData("password"));
		String pass=DatabasePage.getData("password");
		System.out.println("password: "+ pass);
		Thread.sleep(2000);
		loginpageObj.clickSignInButton();
		
		takeScreenshotAtEndOfTest(driver);
	}
	
	*/

	
	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}
	
	

}
