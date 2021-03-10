package com.citi.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.WebDriverWrapper;
import com.citi.pages.DashboardPage;
import com.citi.pages.LoginPage;
import com.citi.utilities.ExcelUtils;
	
public class LoginTest extends WebDriverWrapper {
	@DataProvider
	public Object[][] validCredentialData()
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
	
	@Test(dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedValue)
	{
		
		LoginPage login=new LoginPage(driver);	
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanaguageByText(language);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		
		Assert.assertEquals(dashboard.getCurrenTitle(), expectedValue);
	}
	
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException
	{
		Object[][] main= ExcelUtils.getSheetIntoObjectArray("testdata/openemrdata.xlsx", "invalidCredentialData");
		return main;
	}
	
	@Test(dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String language,String expectedValue)
	{
		LoginPage login=new LoginPage(driver);	
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanaguageByText(language);
		login.clickOnLogin();

		Assert.assertTrue(login.getErrorMessage().contains(expectedValue));
	}
}
