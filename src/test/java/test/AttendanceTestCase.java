package test;

import base.Initiation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AttendancePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AttendanceTestCase extends Initiation {
    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AttendancePage attendancePage;

    @BeforeClass
    public void beforeTest() {
        driver = Setup("chrome");
    }

    @Test
    public void testViewAttendanceSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.viewAttendanceSection();
    }

    @Test
    public void testSearchAttendance() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.searchAttendanceInAttendanceSection("");
    }

    @Test
    public void testViewManualAttendanceSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.viewManualAttendanceSection();
    }

    @Test
    public void testFilterAttendanceInManualAttendanceSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.filterAttendanceInManualAttendanceSection(10, "06-12-2000");
    }

    @Test
    public void testSearchInManualAttendanceSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.searchInManualAttendanceSection(10, "8:0 6-12-2023 pm 00:");
    }

    @Test
    public void testDeleteAttendanceInManualAttendanceSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.deleteAttendanceInManualAttendanceSection(10, "04-06-2024");
    }

    @Test
    public void testViewMonthlyReportSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.viewMonthlyReportSection();
    }

    @Test
    public void testViewAttendanceReportByMonth() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.viewAttendanceReportByMonth("12-2023");
    }

    @Test
    public void testViewOvertimeRequestSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.viewOvertimeRequestSection();
    }

    @Test
    public void testSearchInOvertimeRequestSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.searchInOvertimeRequestSection(10, "12-2023 am pm pen 8:0");
    }

    @Test
    public void testDeleteRequestInOvertimeRequestSection() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
        attendancePage = new AttendancePage(driver);
        attendancePage.deleteRequestInOvertimeRequestSection(10, "-12 pen 0:0 6:4");
    }

    @AfterClass
    public void afterTest() throws Exception {
        Close();
    }
}
