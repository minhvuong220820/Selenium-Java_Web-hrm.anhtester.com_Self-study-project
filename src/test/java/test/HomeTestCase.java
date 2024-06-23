package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Initiation;
import pages.HomePage;
import pages.LoginPage;

public class HomeTestCase extends Initiation {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void beforeTest() {
        driver = Setup("chrome");
    }

    @Test
    public void testLogoutSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.logoutSuccess();
    }

    @Test
    public void testNavigateToAccountSettingsPage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAccountSettingsPage();
    }

    @Test
    public void testViewContractMenuContractTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewContractMenuContractTab();
    }

    @Test
    public void testViewContractMenuAllowancesTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewContractMenuAllowancesTab();
    }

    @Test
    public void testViewContractMenuCommissionsTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewContractMenuCommissionsTab();
    }

    @Test
    public void testViewContractMenuStatutoryDeductionsTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewContractMenuStatutoryDeductionsTab();
    }

    @Test
    public void testViewContractMenuReimbursementsTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewContractMenuReimbursementsTab();
    }

    @Test
    public void testViewBasicInformation() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewBasicInformation();
    }

    @Test
    public void testEditBasicInformationSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editBasicInformationSuccess("Admin", "Example", "0123456789");
    }

    @Test
    public void testEditBasicInformationFailEmptyFirstname() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editBasicInformationFailEmptyFirstname("", "Example", "0123456789");
    }

    @Test
    public void testEditBasicInformationFailEmptyLastname() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editBasicInformationFailEmptyLastname("Admin", "", "0123456789");
    }

    @Test
    public void testEditBasicInformationFailEmptyContactNumber() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editBasicInformationFailEmptyContactNumber("Admin", "Example", "");
    }

    @Test
    public void testViewPersonalInformationMenuBioTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewPersonalInformationMenuBioTab();
    }

    @Test
    public void testEditPersonalInformationBioSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBioSuccess("test bio", "3 years");
    }

    @Test
    public void testEditPersonalInformationBioFailEmptyBio() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBioFailEmptyBio("", "6 years");
    }

    @Test
    public void testViewPersonalInformationMenuSocialProfileTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewPersonalInformationMenuSocialProfileTab();
    }

    @Test
    public void testEditPersonalInformationSocialProfileSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationSocialProfileSuccess("fb", "tw", "gp", "li");
    }

    @Test
    public void testViewPersonalInformationMenuBankAccountTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewPersonalInformationMenuBankAccountTab();
    }

    @Test
    public void testEditPersonalInformationBankAccountSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountSuccess("title", "number", "bankName", "iban", "swiftCode", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptyAccountTitle() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptyAccountTitle("", "number", "bankName", "iban", "swiftCode", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptyAccountNumber() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptyAccountNumber("title", "", "bankName", "iban", "swiftCode", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptyBankName() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptyBankName("title", "number", "", "iban", "swiftCode", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptyIban() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptyIban("title", "number", "bankName", "", "swiftCode", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptySwiftCode() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptySwiftCode("title", "number", "bankName", "iban", "", "bankBranch");
    }

    @Test
    public void testEditPersonalInformationBankAccountFailEmptyBankBranch() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationBankAccountFailEmptyBankBranch("title", "number", "bankName", "iban", "swiftCode", "");
    }

    @Test
    public void testViewPersonalInformationMenuEmergencyContactTab() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewPersonalInformationMenuEmergencyContactTab();
    }

    @Test
    public void testEditPersonalInformationEmergencyContactSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationEmergencyContactSuccess("fullName", "contactNumber", "email", "address");
    }

    @Test
    public void testEditPersonalInformationEmergencyContactFailEmptyFullName() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationEmergencyContactFailEmptyFullName("", "contactNumber", "email", "address");
    }

    @Test
    public void testEditPersonalInformationEmergencyContactFailEmptyContactNumber() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationEmergencyContactFailEmptyContactNumber("fullName", "", "email", "address");
    }

    @Test
    public void testEditPersonalInformationEmergencyContactFailEmptyEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationEmergencyContactFailEmptyEmail("fullName", "contactNumber", "", "address");
    }

    @Test
    public void testEditPersonalInformationEmergencyContactFailEmptyAddress() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editPersonalInformationEmergencyContactFailEmptyAddress("fullName", "contactNumber", "email", "");
    }

    @Test
    public void testUpdateProfilePictureSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.updateProfilePictureSuccess("1.jpg");
    }

    @Test
    public void testUpdateProfilePictureFailEmptyFile() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.updateProfilePictureFailEmptyFile();
    }

    @Test
    public void testUpdateProfilePictureFailNotImageFile() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.updateProfilePictureFailNotImageFile("a.txt");
    }

    @Test
    public void testUpdateProfilePictureFailImageSizeTooLarge() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.updateProfilePictureFailImageSizeTooLarge("57mb.gif");
    }

    @Test
    public void testViewAccountInformation() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewAccountInformation();
    }

    @Test
    public void testEditAccountInformationSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editAccountInformationSuccess("admin_example", "admin@example.com");
    }

    @Test
    public void testEditAccountInformationFailEmptyUsername() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editAccountInformationFailEmptyUsername("", "admin@example.com");
    }

    @Test
    public void testEditAccountInformationFailEmptyAccountEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editAccountInformationFailEmptyAccountEmail("admin_example", "");
    }

    @Test
    public void testEditAccountInformationFailInvalidEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.editAccountInformationFailInvalidEmail("admin_example", "123");
    }

    @Test
    public void testViewDocumentsMenu() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewDocumentsMenu();
    }

    @Test
    public void testViewChangePasswordMenu() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewChangePasswordMenu();
    }

    @Test
    public void testChangePasswordSuccess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.changePasswordSuccess("123456", "123456");
    }

    @Test
    public void testChangePasswordFailEmptyNewPassword() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.changePasswordFailEmptyNewPassword("", "123456");
    }

    @Test
    public void testChangePasswordFailEmptyRepeatNewPassword() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.changePasswordFailEmptyRepeatNewPassword("123456", "");
    }

    @Test
    public void testChangePasswordFailNewPasswordNotMatchRepeatNewPassword() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.changePasswordFailNewPasswordNotMatchRepeatNewPassword("123456", "abcdef");
    }

    @Test
    public void testChangePasswordFailNewPasswordTooShort() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.changePasswordFailNewPasswordTooShort("123", "123456");
    }

    @Test
    public void testViewTodoList() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.viewTodoListPage();
    }

    @Test
    public void testAddTask() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.addTaskSuccess("4uh8324fhy34784");
    }

    @Test
    public void testAddTaskFailEmptyTask() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.addTaskFailEmptyTask("");
    }

    @Test
    public void testCheckTask() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.checkTask("36");
    }

    @Test
    public void testUncheckTask() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.uncheckTask("36");
    }

    @Test
    public void testDeleteTask() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.deleteTask("39");
    }

    @Test
    public void testTestAutoCheckIn() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.AutoCheckIn();
    }

    @Test
    public void testTestAutoCheckOut() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.AutoCheckOut();
    }

    @Test
    public void testNavigateToAttendancePage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToAttendancePage();
    }

    @Test
    public void testNavigateToProjectsPage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToProjectsPage();
    }

    @Test
    public void testNavigateToEmployeesPage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToEmployeesPage();
    }

    @AfterClass
    public void afterTest() throws Exception {
        Close();
    }
}
