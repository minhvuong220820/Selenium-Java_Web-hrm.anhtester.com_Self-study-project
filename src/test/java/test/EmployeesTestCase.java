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

    @Test
    public void testAddNewEmployeeSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "1", "Male", "a1@r.com", "qwe123!", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "2.jpg", "Employee added.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyFirstName() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("", "last name", "?", "1", "Male", "a2@r.com", "qwe123!", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The first name field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyLastName() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "", "?", "1", "Male", "a3@r.com", "qwe123!", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The last name field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyEmployeeID() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "", "1", "Male", "a4@r.com", "qwe123!", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The employee id field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyContactNumber() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "", "Male", "a5@r.com", "qwe123", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The contact number field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "", "qwe123", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The email field is required.");
    }

    @Test
    public void testAddNewEmployeeFailInvalidEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "asd!@#", "qwe123", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The email field must contain a valid email address.");
    }

    @Test
    public void testAddNewEmployeeFailEmailExisted() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a1@r.com", "qwe123", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "This email already exist. Please choose another email.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyUsername() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a6@r.com", "", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The username field is required.");
    }

    @Test
    public void testAddNewEmployeeFailUsernameTooShort() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a7@r.com", "@", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "Your username is too short, minimum 6 characters required.");
    }

    @Test
    public void testAddNewEmployeeFailUsernameExisted() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "admin_example", "123456", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "This username already exist. Please choose another username.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyPassword() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The password field is required.");
    }

    @Test
    public void testAddNewEmployeeFailPasswordTooShort() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*", "1", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "Your password is too short, minimum 6 characters required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyOfficeShift() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "", "Admin Demo", "Manager", "Test Leader", "1000", "10", "3.jpg", "The office shift field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyRole() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "", "Manager", "Test Leader", "1000", "10", "3.jpg", "The staff role field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyDepartment() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "", "Test Leader", "1000", "10", "3.jpg", "The department field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyDesignation() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "", "1000", "10", "3.jpg", "The designation field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyBasicSalary() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "Software Tester", "", "10", "3.jpg", "The basic salary field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyHourlyRate() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "Software Tester", "123030", "", "3.jpg", "The hourly rate field is required.");
    }

    @Test
    public void testAddNewEmployeeFailEmptyProfilePicture() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "Software Tester", "123030", "100", "?", "The profile picture field is required.");
    }

    @Test
    public void testAddNewEmployeeFailNotImageFile() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "Software Tester", "123030", "100", "a.txt", "The profile picture field is required.");
    }

    @Test
    public void testAddNewEmployeeFailProfilePictureFileSizeTooLarge() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
        employeesPage = new EmployeesPage(driver);
        employeesPage.addNewEmployee("first name", "last name", "?", "0", "Male", "a8@r.com", "asdzxc", "*****1", "2", "Admin Demo", "QA", "Software Tester", "123030", "100", "57mb.gif", "The profile picture field is required.");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
