package com.citi.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.pages.DashboardPage;
import com.citi.pages.LoginPage;

public class DemoTest1 {

	// admin,pass
	// bala, bala123
	// john,john123
	// king,king123
	// {{"admin","pass"},{"bala","bala123"},{"john","john123"}}

	@DataProvider
	public Object[][] data() {
		Object[][] main = new Object[4][2];
		// i-->3 (how many testcase)
		// j-->2 (how many parameter)
		main[0][0] = "admin";
		main[0][1] = "pass";

		main[1][0] = "bala";
		main[1][1] = "bala123";

		main[2][0] = "john";
		main[2][1] = "john123";

		main[3][0] = "king";
		main[3][1] = "king123";

		return main;
	}

	@Test(dataProvider = "data")
	public void validTest(String user, String pass) {
		System.out.println(user + pass);
	}
	
	@DataProvider(parallel = true)
	public Object[][] validCredentialData1()
	{
		Object[][] main=new Object[2][4];
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="accountant";
		main[1][1]="accountant";
		main[1][2]="English (Indian)";
		main[1][3]="OpenEMR";
		
		return main;
		
	}

	@Test(dataProvider = "validCredentialData1")
	public void validCredentialTest1(String username, String password, String language, String expectedValue) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/b/openemr/index.php");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanaguageByText(language);
		login.clickOnLogin();

		DashboardPage dashboard = new DashboardPage(driver);

		Assert.assertEquals(dashboard.getCurrenTitle(), expectedValue);
	}
	
//	@Test()
//	public void testDemo1() throws InterruptedException
//	{
//		Thread.sleep(6000);
//		System.out.println("hhhh");
//	}
//	
//	@Test(dependsOnMethods = "")
//	public void testDemo2() throws InterruptedException
//	{
//		Thread.sleep(6000);
//		System.out.println("hhhh");
//	}
	@Test()
	public void testDemo1() throws InterruptedException
	{
		Reporter.log("testdem1 started");
		Assert.fail();
		System.out.println("hhhh");
	}
	
	@Test(dependsOnMethods = "testDemo1",alwaysRun = true)
	public void testDemo2() throws InterruptedException
	{
		Reporter.log("testdem2 started");
		//Thread.sleep(6000);
		System.out.println("hhhh");
		Reporter.log("testdem started");
	}
}
