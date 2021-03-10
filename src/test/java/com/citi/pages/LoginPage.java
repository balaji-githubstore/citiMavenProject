package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private By userLocator=By.id("authUser");
	private By passwordLocator=By.id("clearPass");
	private By languageLocator=By.name("languageChoice");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");
	
	private WebDriver driver;
	//driver --> update the driver through construtor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(userLocator).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void selectLanaguageByText(String language)
	{
		Select selectLanguage=new Select(driver.findElement(languageLocator));
		selectLanguage.selectByVisibleText(language);	
	}

	public void clickOnLogin()
	{
		driver.findElement(loginLocator).click();	
	}
	
	public String getErrorMessage()
	{
		return driver.findElement(errorLocator).getText();
	}
}





