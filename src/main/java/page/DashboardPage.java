package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement dashboardHeaderElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement customertElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement addCustomerElement;
	//@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement listCustomerElement;
	
	public void validateDashboardPage(String expextedText)
	{
		//Assert.assertEquals(dashboardHeaderElement.getText(),"Dashboard", "Page not found");
		Assert.assertEquals(dashboardHeaderElement.getText(),expextedText, "Page not found");
	}
	
	public void clickCustomers()
	{
		customertElement.click();
	}
	
	public void cliskaddCustomer()
	{
		addCustomerElement.click();
	}
}
