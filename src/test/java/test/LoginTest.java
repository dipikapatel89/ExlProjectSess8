package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	
	ExcelReader exlRead=new ExcelReader("testData\\TF_TestData (2).xlsx");
	String username=exlRead.getCellData("LoginInfo", "UserName",2);
	String password=exlRead.getCellData("LoginInfo", "Password",2);
	String dashboardValidation="Dashboard";
	
	@Test
	public void validUserShouldBeAbleToLogin()
	{
		driver=BrowserFactory.init();
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		//create object of dashboard page and call method
		DashboardPage dashboardpage=PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardValidation);
		
		BrowserFactory.tearDown();
	}
	
}
