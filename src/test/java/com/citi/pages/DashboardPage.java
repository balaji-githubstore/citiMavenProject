package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getCurrenTitle()
	{
		return driver.getTitle().trim();
	}
	
	public void mouseHoverOnPatientClient()
	{
		Actions action=new Actions(driver);
		action
		.moveToElement(driver.findElement(By.xpath("//*[text()='Patient/Client']")))
		.perform();
	}
}
