package page;

import org.openqa.selenium.By;

//import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactPage extends BasePage{

	WebDriver driver;
	
	 public AddContactPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"account\"]") WebElement fullNameElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"cid\"]") WebElement companyElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"email\"]") WebElement emailElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"phone\"]") WebElement phoneElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"address\"]") WebElement addressElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"city\"]") WebElement cityElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"state\"]") WebElement stateElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"zip\"]") WebElement zipElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"country\"]") WebElement countryElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"submit\"]") WebElement saveElement;
	
	String insertedName;
	
	public void insertFullName(String fullname)
	{
		insertedName=fullname + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
	}
	public void selectCompany(String companyName)
	{
		selectFromDropdown(companyElement, companyName);
	}
	public void insertEmail(String email)
	{
		emailElement.sendKeys(generateRandomNum(99) + email);
	}
	public void insertPhone(String phone)
	{
		phoneElement.sendKeys(generateRandomNum(99)+ phone);
	}
	public void insertAddress(String address)
	{
		addressElement.sendKeys(address);
	}
	public void insertCity(String city)
	{
		cityElement.sendKeys(city);
	}
    public void insertState(String state)
    {
    	stateElement.sendKeys(state);
    }
    
    public void insertZip(String zip)
    {
    	zipElement.sendKeys(zip);
    }
    public void insertCountry(String country)
    {
       	selectFromDropdown(countryElement, country);
    }
    public void clickSave()
    {
    	saveElement.click();
    }
    
  //tbody/tr[1]/td[3]/a
    
    String beforeXpath="//tbody/tr[";
    String afterXpath="]/td[3]/a";
    public void validateInsertdName()
    {
    	for(int i=1;i<=10;i++)
    	{
    		String actualName=driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
    		System.out.println(actualName);
    		Assert.assertEquals(actualName, insertedName,"name is not found");
    	}
    }
}

