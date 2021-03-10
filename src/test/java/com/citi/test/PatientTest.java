package com.citi.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.WebDriverWrapper;
import com.citi.pages.DashboardPage;
import com.citi.pages.LoginPage;
import com.citi.utilities.ExcelUtils;

public class PatientTest extends WebDriverWrapper {
	
	@DataProvider
	public Object[][] addPatientData() throws IOException
	{
		Object[][] main= ExcelUtils.getSheetIntoObjectArray("testdata/openemrdata.xlsx", "addPatientData");
		return main;
	}
	@Test(dataProvider = "addPatientData")
	public void addPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String gender,String expectedValue)
	{
		LoginPage login =new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanaguageByText("English (Indian)");
		login.clickOnLogin();
		
		//add the patient
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.mouseHoverOnPatientClient();
		
		driver.findElement(By.xpath("//*[text()='Patients']")).click();
		
		//make sure added patient detail is present -- assertion
		}
}

