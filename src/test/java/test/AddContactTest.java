package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

    WebDriver driver;
    ExcelReader exlRead=new ExcelReader("testData\\TF_TestData (2).xlsx");
    String username=exlRead.getCellData("LoginInfo", "UserName",2);
	String password=exlRead.getCellData("LoginInfo", "Password",2);
	String dashboardValidation="Dashboard";
	String fullname=exlRead.getCellData("AddContactInfo","FullName", 2);
	String companyName=exlRead.getCellData("AddContactInfo","CompanyName", 2);
	String email=exlRead.getCellData("AddContactInfo","Email", 2);
	String phone=exlRead.getCellData("AddContactInfo","Phone", 2);
	String address=exlRead.getCellData("AddContactInfo","Address", 2);
	String city=exlRead.getCellData("AddContactInfo","City", 2);
	String state=exlRead.getCellData("AddContactInfo","State", 2);
	String zip=exlRead.getCellData("AddContactInfo","Zip", 2);
	String country=exlRead.getCellData("AddContactInfo","Country", 2);

	
	@Test
	public void userShouldBeAbleToAddCustomer()
	{
		driver=BrowserFactory.init();		

		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		DashboardPage dashboardpage=PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardValidation);
		dashboardpage.clickCustomers();
		dashboardpage.cliskaddCustomer();
		
		AddContactPage addcontactpage=PageFactory.initElements(driver, AddContactPage.class);
		addcontactpage.insertFullName(fullname);
		addcontactpage.selectCompany(companyName);
		addcontactpage.insertEmail(email);
		addcontactpage.insertPhone(phone);
		addcontactpage.insertAddress(address);
		addcontactpage.insertCity(city);
		addcontactpage.insertState(state);
		addcontactpage.insertZip(zip);
		addcontactpage.insertCountry(country);
		addcontactpage.clickSave();
	}
}
 