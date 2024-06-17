package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Initiation;
import pages.LoginPage;

public class LoginTestCase extends Initiation{

	private WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeClass
	public void beforeTest() {
		driver = Setup("chrome");
	}
	
	@Test
	public void testLoginSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
	}
	
	@Test
	public void testLoginFailEmptyUsername() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginFailEmptyUsername("", "123456");
	}
	
	@Test
	public void testLoginFailEmptyPassword() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginFailEmptyPassword("admin_example", "");
	}
	
	@Test
	public void testLoginFailShortPassword() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginFailShortPassword("admin_example", "1");
	}
	
	@Test
	public void testLoginFailInvalidCredentials() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginFailInvalidCredentials("asdqwe", "abc123");
	}
	
	@Test
	public void testNavigateToResetPasswordPage() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.navigateToResetPasswordPage();
	}
	
	@Test
	public void testResetPasswordSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.resetPasswordSuccess("a@a.com");
	}
	
	@Test
	public void testResetPasswordFailEmptyEmail() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.resetPasswordFailEmptyEmail("");
	}
	
	@Test
	public void testResetPasswordFailInvalidEmail() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.resetPasswordFailInvalidEmail("asdqwe123");
	}
	
	@Test
	public void testResetPasswordBackToLoginPage() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.resetPasswordBackToLoginPage();
	}
	
	@AfterClass
	public void afterTest() throws Exception {
		Close();
	}
	
}
