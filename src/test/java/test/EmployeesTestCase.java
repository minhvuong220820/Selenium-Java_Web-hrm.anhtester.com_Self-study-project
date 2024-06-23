package test;

import base.Initiation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class EmployeesTestCase extends Initiation {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    EmployeesPage employeesPage;

    @BeforeClass
    public void beforeTest() {
        driver = Setup("chrome");
    }

    @Test
    public void testViewEmployeesSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.viewEmployeesSection();
    }

    @Test
    public void testSearchInEmployeesSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.searchInEmployeesSection(10, "0 @");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
