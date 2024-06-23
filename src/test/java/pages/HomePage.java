package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

public class HomePage {

    private WebDriver driver = null;
    WebDriverWait wait = null;
    WebDriverWait largeWait = null;
    Actions action = null;

    private By homePageLogoutButtonLocator = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");
    private By loginPageUsernameInputLocator = By.xpath("//input[@id='iusername']");
    private By loginPagePasswordInputLocator = By.xpath("//input[@id='ipassword']");

    private By homePageAccountSettingsButtonLocator = By.xpath("//a[@data-original-title='Account Settings']");
    private By accountSettingsPageConfirmMessageLocator = By.xpath("//div[@class='toast-message']");

    private By accountSettingsPageContractButtonLocator = By.xpath("//a[@id='user-set-salary-tab']");
    private By accountSettingsPageContractMenuLocator = By.xpath("//div[@id='user-set-salary']");
    private By accountSettingsPageContractMenuHeaderLocator = By.xpath("//span[normalize-space()='Set Contract']");
    private By accountSettingsPageContractMenuContractTabLocator = By.xpath("//a[@id='pills-contract-tab']");
    private By accountSettingsPageContractMenuAllowancesTabLocator = By.xpath("//a[@id='pills-allowances-tab']");
    private By accountSettingsPageContractMenuCommissionsTabLocator = By.xpath("//a[@id='pills-commissions-tab']");
    private By accountSettingsPageContractMenuStatutoryDeductionsTabLocator = By.xpath("//a[@id='pills-statutory-tab']");
    private By accountSettingsPageContractMenuReimbursementsTabLocator = By.xpath("//a[@id='pills-reimbursements-tab']");

    private By accountSettingsPageBasicInformationButtonLocator = By.xpath("//a[@id='user-set-basicinfo-tab']");
    private By accountSettingsPageBasicInformationMenuLocator = By.xpath("//div[@id='user-set-basicinfo']");
    private By accountSettingsPageBasicInformationMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Basic Information']");
    private By accountSettingsPageBasicInformationFirstnameInputLocator = By.xpath("//input[@placeholder='First Name']");
    private By accountSettingsPageBasicInformationLastnameInputLocator = By.xpath("//input[@placeholder='Last Name']");
    private By accountSettingsPageBasicInformationContactNumberInputLocator = By.xpath("//input[@name='contact_number']");
    private By accountSettingsPageBasicInformationUpdateProfileButtonLocator = By.xpath("//div[@id='user-set-basicinfo']//button[@type='submit']");

    private By accountSettingsPagePersonalInformationButtonLocator = By.xpath("//a[@id='user-set-information-tab']");
    private By accountSettingsPagePersonalInformationMenuLocator = By.xpath("//div[@id='user-set-information']");
    private By accountSettingsPagePersonalInformationMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Personal Information']");
    private By accountSettingsPagePersonalInformationMenuBioTabLocator = By.xpath("//a[@id='pills-bio-tab']");
    private By accountSettingsPagePersonalInformationMenuBioTextareaLocator = By.xpath("//textarea[@placeholder='Enter staff bio here..']");
    private By accountSettingsPagePersonalInformationMenuExperienceSelectLocator = By.xpath("//select[@name='experience']");
    private By accountSettingsPagePersonalInformationMenuUpdateBioButtonLocator = By.xpath("//form[@id='edit_bio']//button[@type='submit']");
    private By accountSettingsPagePersonalInformationMenuSocialProfileTabLocator = By.xpath("//a[@id='pills-profile-tab']");
    private By accountSettingsPagePersonalInformationMenuFacebookInputLocator = By.xpath("//input[@name='fb_profile']");
    private By accountSettingsPagePersonalInformationMenuTwitterInputLocator = By.xpath("//input[@name='twitter_profile']");
    private By accountSettingsPagePersonalInformationMenuGoogleInputLocator = By.xpath("//input[@name='gplus_profile']");
    private By accountSettingsPagePersonalInformationMenuLinkedinInputLocator = By.xpath("//input[@name='linkedin_profile']");
    private By accountSettingsPagePersonalInformationMenuUpdateSocialButtonLocator = By.xpath("//form[@id='edit_social']//button[@type='submit']");
    private By accountSettingsPagePersonalInformationMenuBankAccountTabLocator = By.xpath("//a[@id='pills-bank-tab']");
    private By accountSettingsPagePersonalInformationMenuAccountTitleInputLocator = By.xpath("//input[@placeholder='Account Title']");
    private By accountSettingsPagePersonalInformationMenuAccountNumberInputLocator = By.xpath("//input[@placeholder='Account Number']");
    private By accountSettingsPagePersonalInformationMenuBankNameInputLocator = By.xpath("//input[@placeholder='Bank Name']");
    private By accountSettingsPagePersonalInformationMenuIbanInputLocator = By.xpath("//input[@placeholder='IBAN']");
    private By accountSettingsPagePersonalInformationMenuSwiftCodeInputLocator = By.xpath("//input[@placeholder='Swift Code']");
    private By accountSettingsPagePersonalInformationMenuBankBranchTextareaLocator = By.xpath("//textarea[@placeholder='Bank Branch']");
    private By accountSettingsPagePersonalInformationMenuUpdateBankInfoButtonLocator = By.xpath("//form[@id='edit_bankinfo']//button[@type='submit']");
    private By accountSettingsPagePersonalInformationMenuEmergencyContactTabLocator = By.xpath("//a[@id='pills-contact-tab']");
    private By accountSettingsPagePersonalInformationMenuFullNameInputLocator = By.xpath("//input[@placeholder='Full Name']");
    private By accountSettingsPagePersonalInformationMenuContactNumberInputLocator = By.xpath("//input[@name='contact_phone_no']");
    private By accountSettingsPagePersonalInformationMenuEmailInputLocator = By.xpath("//input[@placeholder='Email']");
    private By accountSettingsPagePersonalInformationMenuAddressTextareaLocator = By.xpath("//textarea[@placeholder='Address']");
    private By accountSettingsPagePersonalInformationMenuUpdateContactButtonLocator = By.xpath("//form[@id='edit_contact']//button[@type='submit']");

    private By accountSettingsPageProfilePictureButtonLocator = By.xpath("//a[@id='user-set-picture-tab']");
    private By accountSettingsPageProfilePictureMenuLocator = By.xpath("//div[@id='user-set-picture']");
    private By accountSettingsPageProfilePictureMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Profile Picture']");
    private By accountSettingsPageProfilePictureMenuProfilePictureInputLocator = By.xpath("//input[@name='file']");
    private By accountSettingsPageProfilePictureMenuUpdatePictureButtonLocator = By.xpath("//div[@id='user-set-picture']//button[@type='submit']");

    private By accountSettingsPageAccountInformationButtonLocator = By.xpath("//a[@id='user-set-account-tab']");
    private By accountSettingsPageAccountInformationMenuLocator = By.xpath("//div[@id='user-set-account']");
    private By accountSettingsPageAccountInformationMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Account Information']");
    private By accountSettingsPageAccountInformationMenuUsernameInputLocator = By.xpath("//input[@placeholder='Username']");
    private By accountSettingsPageAccountInformationMenuAccountEmailInputLocator = By.xpath("//input[@placeholder='Account Email']");
    private By accountSettingsPageAccountInformationMenuSaveAccountInformationButtonLocator = By.xpath("//form[@id='edit_account']//button[@type='submit']");

    private By accountSettingsPageDocumentsButtonLocator = By.xpath("//span[@class='f-w-500'][normalize-space()='Documents']");
    private By accountSettingsPageDocumentsMenuLocator = By.xpath("//div[@id='user-set-document']");
    private By accountSettingsPageDocumentsMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Documents']");

    private By accountSettingsPageChangePasswordButtonLocator = By.xpath("//span[@class='f-w-500'][normalize-space()='Change Password']");
    private By accountSettingsPageChangePasswordMenuLocator = By.xpath("//div[@id='user-set-password']");
    private By accountSettingsPageChangePasswordMenuHeaderLocator = By.xpath("//span[@class='p-l-5'][normalize-space()='Change Password']");
    private By accountSettingsPageChangePasswordMenuCurrentPasswordInputLocator = By.xpath("//input[@placeholder='Current password']");
    private By accountSettingsPageChangePasswordMenuNewPasswordInputLocator = By.xpath("//input[@placeholder='New password']");
    private By accountSettingsPageChangePasswordMenuRepeatNewPasswordInputLocator = By.xpath("//input[@placeholder='Repeat new password']");
    private By accountSettingsPageChangePasswordMenuChangePasswordButtonLocator = By.xpath("//button[@class='btn btn-danger ladda-button']");

    private By homePageTodoListButtonLocator = By.xpath("//a[@class='pc-head-link mr-0']");
    private By todoListPageConfirmMessageLocator = By.xpath("//div[@class='toast-message']");

    private By todoListPageHeaderLocator = By.xpath("//h5[normalize-space()='Todo items']");
    private By todoListPageTaskInputLocator = By.xpath("//input[@placeholder='Create your task list...']");
    private By todoListPageAddTaskButtonLocator = By.xpath("//button[@class='btn waves-effect waves-light btn-secondary btn-icon ladda-button']");
    private By todoListPageListTaskLocator = By.xpath("//div[@class='new-task']//div[@class='to-do-list mb-3']");

    private By homePageClockInButtonLocator = By.xpath("//button[normalize-space()='Clock IN']");
    private By homePageClockOutButtonLocator = By.xpath("//button[normalize-space()='Clock OUT']");

    private By homePageAttendanceButtonLocator = By.xpath("//span[normalize-space()='Attendance']");
    private By homePageProjectsButtonLocator = By.xpath("//span[normalize-space()='Projects']");
    private By homePageEmployeesButtonLocator = By.xpath("//span[normalize-space()='Employees']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.largeWait = new WebDriverWait(driver, Duration.ofSeconds(100));
        this.action = new Actions(driver);
    }

    public void clickLogoutButton() {
        WebElement homePageLogoutButton = driver.findElement(homePageLogoutButtonLocator);

        action.moveToElement(homePageLogoutButton);

        assertTrue(homePageLogoutButton.isDisplayed(), "Logout Button ko duoc hien thi.");

        homePageLogoutButton.click();
    }

    public void logoutSuccess() throws Exception {
        clickLogoutButton();

        Thread.sleep(Duration.ofSeconds(1));

        WebElement loginPageUsernameInput = driver.findElement(loginPageUsernameInputLocator);
        WebElement loginPagePasswordInput = driver.findElement(loginPagePasswordInputLocator);

        assertTrue(loginPageUsernameInput.isDisplayed(), "Username input ko duoc hien thi.");
        assertTrue(loginPagePasswordInput.isDisplayed(), "Password input ko duoc hien thi.");
        assertEquals(driver.getTitle(), "HRM | Anh Tester Demo | Log in", "Trang hien tai ko phai trang Login Page.");
    }

    public void clickAccountSettingsButton() throws Exception {
        WebElement homePageAccountSettingsButton = driver.findElement(homePageAccountSettingsButtonLocator);

        assertTrue(homePageAccountSettingsButton.isDisplayed(), "Account Settings Button ko duoc hien thi.");

        homePageAccountSettingsButton.click();
    }

    public void navigateToAccountSettingsPage() throws Exception {
        clickAccountSettingsButton();

        Thread.sleep(Duration.ofSeconds(1));

        assertEquals(driver.getTitle(), "Account Settings | HRM | Anh Tester Demo");
    }

    public void clickContractButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageContractButton = driver.findElement(accountSettingsPageContractButtonLocator);

        assertTrue(accountSettingsPageContractButton.isDisplayed(), "Contract Button ko duoc hien thi.");

        accountSettingsPageContractButton.click();
    }

    public void verifyContractMenu() {
        WebElement accountSettingsPageContractMenu = driver.findElement(accountSettingsPageContractMenuLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageContractMenu));

        WebElement accountSettingsPageContractMenuHeader = driver.findElement(accountSettingsPageContractMenuHeaderLocator);

        assertTrue(accountSettingsPageContractMenuHeader.getText().contains("Set Contract"), "Contract Menu chua duoc hien thi.");
    }

    public void viewContractMenuContractTab() throws Exception {
        clickContractButton();
        verifyContractMenu();

        WebElement accountSettingsPageContractMenuContractTab = driver.findElement(accountSettingsPageContractMenuContractTabLocator);

        assertTrue(accountSettingsPageContractMenuContractTab.isDisplayed(), "Contract Tab ko duoc hien thi.");

        accountSettingsPageContractMenuContractTab.click();

        assertTrue(accountSettingsPageContractMenuContractTab.getAttribute("aria-selected").contains("true"), "Contract Tab chua duoc chon.");
    }

    public void viewContractMenuAllowancesTab() throws Exception {
        clickContractButton();
        verifyContractMenu();

        WebElement accountSettingsPageContractMenuAllowancesTab = driver.findElement(accountSettingsPageContractMenuAllowancesTabLocator);

        assertTrue(accountSettingsPageContractMenuAllowancesTab.isDisplayed(), "Allowances Tab ko duoc hien thi.");

        accountSettingsPageContractMenuAllowancesTab.click();

        assertTrue(accountSettingsPageContractMenuAllowancesTab.getAttribute("aria-selected").contains("true"), "Allowances Tab chua duoc chon.");
    }

    public void viewContractMenuCommissionsTab() throws Exception {
        clickContractButton();
        verifyContractMenu();

        WebElement accountSettingsPageContractMenuCommissionsTab = driver.findElement(accountSettingsPageContractMenuCommissionsTabLocator);

        assertTrue(accountSettingsPageContractMenuCommissionsTab.isDisplayed(), "Commissions Tab ko duoc hien thi.");

        accountSettingsPageContractMenuCommissionsTab.click();

        assertTrue(accountSettingsPageContractMenuCommissionsTab.getAttribute("aria-selected").contains("true"), "Commissions Tab chua duoc chon.");
    }

    public void viewContractMenuStatutoryDeductionsTab() throws Exception {
        clickContractButton();
        verifyContractMenu();

        WebElement accountSettingsPageContractMenuStatutoryDeductionsTab = driver.findElement(accountSettingsPageContractMenuStatutoryDeductionsTabLocator);

        assertTrue(accountSettingsPageContractMenuStatutoryDeductionsTab.isDisplayed(), "StatutoryDeductions Tab ko duoc hien thi.");

        accountSettingsPageContractMenuStatutoryDeductionsTab.click();

        assertTrue(accountSettingsPageContractMenuStatutoryDeductionsTab.getAttribute("aria-selected").contains("true"), "StatutoryDeductions Tab chua duoc chon.");
    }

    public void viewContractMenuReimbursementsTab() throws Exception {
        clickContractButton();
        verifyContractMenu();

        WebElement accountSettingsPageContractMenuReimbursementsTab = driver.findElement(accountSettingsPageContractMenuReimbursementsTabLocator);

        assertTrue(accountSettingsPageContractMenuReimbursementsTab.isDisplayed(), "Reimbursements Tab ko duoc hien thi.");

        accountSettingsPageContractMenuReimbursementsTab.click();

        assertTrue(accountSettingsPageContractMenuReimbursementsTab.getAttribute("aria-selected").contains("true"), "Reimbursements Tab chua duoc chon.");
    }

    public void clickBasicInformationButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageBasicInformationButton = driver.findElement(accountSettingsPageBasicInformationButtonLocator);

        assertTrue(accountSettingsPageBasicInformationButton.isDisplayed(), "Basic Information Button ko duoc hien thi.");

        accountSettingsPageBasicInformationButton.click();
    }

    public void viewBasicInformation() throws Exception {
        clickBasicInformationButton();

        WebElement accountSettingsPageBasicInformationMenu = driver.findElement(accountSettingsPageBasicInformationMenuLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageBasicInformationMenu));

        WebElement accountSettingsPageBasicInformationMenuHeader = driver.findElement(accountSettingsPageBasicInformationMenuHeaderLocator);

        assertTrue(accountSettingsPageBasicInformationMenuHeader.getText().contains("Basic Information"), "Basic Information Menu chua duoc hien thi.");
    }

    public void clearAndEnterFirstnameInput(String firstname) {
        WebElement accountSettingsPageBasicInformationFirstnameInput = driver.findElement(accountSettingsPageBasicInformationFirstnameInputLocator);

        assertTrue(accountSettingsPageBasicInformationFirstnameInput.isDisplayed(), "Firstname Input ko duoc hien thi.");
        assertTrue(accountSettingsPageBasicInformationFirstnameInput.isEnabled(), "Firstname Input ko the tuong tac.");

        accountSettingsPageBasicInformationFirstnameInput.clear();
        accountSettingsPageBasicInformationFirstnameInput.sendKeys(firstname);
    }

    public void clearAndEnterLastnameInput(String lastname) {
        WebElement accountSettingsPageBasicInformationLastnameInput = driver.findElement(accountSettingsPageBasicInformationLastnameInputLocator);

        assertTrue(accountSettingsPageBasicInformationLastnameInput.isDisplayed(), "Lastname Input ko duoc hien thi.");
        assertTrue(accountSettingsPageBasicInformationLastnameInput.isEnabled(), "Lastname Input ko the tuong tac.");

        accountSettingsPageBasicInformationLastnameInput.clear();
        accountSettingsPageBasicInformationLastnameInput.sendKeys(lastname);
    }

    public void clearAndEnterContactNumberInput(String contactNumber) {
        WebElement accountSettingsPageBasicInformationContactNumberInput = driver.findElement(accountSettingsPageBasicInformationContactNumberInputLocator);

        assertTrue(accountSettingsPageBasicInformationContactNumberInput.isDisplayed(), "Contact Number Input ko duoc hien thi.");
        assertTrue(accountSettingsPageBasicInformationContactNumberInput.isEnabled(), "Contact Number Input ko the tuong tac.");

        accountSettingsPageBasicInformationContactNumberInput.clear();
        accountSettingsPageBasicInformationContactNumberInput.sendKeys(contactNumber);
    }

    public void clickUpdateProfileButton() {
        WebElement accountSettingsPageBasicInformationUpdateProfileButton = driver.findElement(accountSettingsPageBasicInformationUpdateProfileButtonLocator);

        action.moveToElement(accountSettingsPageBasicInformationUpdateProfileButton);

        assertTrue(accountSettingsPageBasicInformationUpdateProfileButton.isDisplayed(), "Update Profile Button ko duoc hien thi.");
        assertTrue(accountSettingsPageBasicInformationUpdateProfileButton.isEnabled(), "Update Profile Button ko the tuong tac.");

        accountSettingsPageBasicInformationUpdateProfileButton.click();
    }

    public void editBasicInformationSuccess(String firstname, String lastname, String contactNumber) throws Exception {
        viewBasicInformation();
        clearAndEnterFirstnameInput(firstname);
        clearAndEnterLastnameInput(lastname);
        clearAndEnterContactNumberInput(contactNumber);
        clickUpdateProfileButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Employee basic info updated."), "Edit Basic Information success confirm ko dc hien thi.");
    }

    public void editBasicInformationFailEmptyFirstname(String firstname, String lastname, String contactNumber) throws Exception {
        viewBasicInformation();
        clearAndEnterFirstnameInput(firstname);
        clearAndEnterLastnameInput(lastname);
        clearAndEnterContactNumberInput(contactNumber);
        clickUpdateProfileButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The first name field is required."), "Edit Basic Information fail confirm ko dc hien thi.");
    }

    public void editBasicInformationFailEmptyLastname(String firstname, String lastname, String contactNumber) throws Exception {
        viewBasicInformation();
        clearAndEnterFirstnameInput(firstname);
        clearAndEnterLastnameInput(lastname);
        clearAndEnterContactNumberInput(contactNumber);
        clickUpdateProfileButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The last name field is required."), "Edit Basic Information fail confirm ko dc hien thi.");
    }

    public void editBasicInformationFailEmptyContactNumber(String firstname, String lastname, String contactNumber) throws Exception {
        viewBasicInformation();
        clearAndEnterFirstnameInput(firstname);
        clearAndEnterLastnameInput(lastname);
        clearAndEnterContactNumberInput(contactNumber);
        clickUpdateProfileButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The contact number field is required."), "Edit Basic Information fail confirm ko dc hien thi.");
    }

    public void clickPersonalInformationButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPagePersonalInformationButton = driver.findElement(accountSettingsPagePersonalInformationButtonLocator);

        assertTrue(accountSettingsPagePersonalInformationButton.isDisplayed(), "Personal Information Button ko duoc hien thi.");

        accountSettingsPagePersonalInformationButton.click();
    }

    public void verifyPersonalInformationMenu() {
        WebElement accountSettingsPagePersonalInformationMenu = driver.findElement(accountSettingsPagePersonalInformationMenuLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPagePersonalInformationMenu));

        WebElement accountSettingsPagePersonalInformationMenuHeader = driver.findElement(accountSettingsPagePersonalInformationMenuHeaderLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuHeader.getText().contains("Personal Information"), "Personal Information Menu chua duoc hien thi.");
    }

    public void viewPersonalInformationMenuBioTab() throws Exception {
        clickPersonalInformationButton();
        verifyPersonalInformationMenu();

        WebElement accountSettingsPagePersonalInformationMenuBioTab = driver.findElement(accountSettingsPagePersonalInformationMenuBioTabLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuBioTab.isDisplayed(), "Bio tab ko duoc hien thi.");

        accountSettingsPagePersonalInformationMenuBioTab.click();

        //assertTrue(accountSettingsPagePersonalInformationMenuBioTab.getAttribute("aria-selected").contains("true"), "Bio Tab chua duoc chon.");
    }

    public void clearAndEnterBioTextarea(String bio) {
        WebElement accountSettingsPagePersonalInformationMenuBioTextarea = driver.findElement(accountSettingsPagePersonalInformationMenuBioTextareaLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuBioTextarea.isDisplayed(), "Bio textarea ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuBioTextarea.isEnabled(), "Bio textarea ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuBioTextarea.clear();
        accountSettingsPagePersonalInformationMenuBioTextarea.sendKeys(bio);
    }

    public void chooseExperience(String experience) {
        WebElement accountSettingsPagePersonalInformationMenuExperienceSelect = driver.findElement(accountSettingsPagePersonalInformationMenuExperienceSelectLocator);
        Select selectExperience = new Select(accountSettingsPagePersonalInformationMenuExperienceSelect);
        selectExperience.selectByVisibleText(experience);
    }

    public void clickUpdateBioButton() {
        WebElement accountSettingsPagePersonalInformationMenuUpdateBioButton = driver.findElement(accountSettingsPagePersonalInformationMenuUpdateBioButtonLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuUpdateBioButton.isDisplayed(), "Update Bio button ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuUpdateBioButton.isEnabled(), "Update Bio button ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuUpdateBioButton.click();
    }

    public void editPersonalInformationBioSuccess(String bio, String experience) throws Exception {
        viewPersonalInformationMenuBioTab();
        clearAndEnterBioTextarea(bio);
        chooseExperience(experience);
        clickUpdateBioButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Bio updated."), "Edit Personal Information Bio success confirm ko dc hien thi.");
    }

    public void editPersonalInformationBioFailEmptyBio(String bio, String experience) throws Exception {
        viewPersonalInformationMenuBioTab();
        clearAndEnterBioTextarea(bio);
        chooseExperience(experience);
        clickUpdateBioButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The bio field is required."), "Edit Personal Information Bio fail confirm ko dc hien thi.");
    }

    public void viewPersonalInformationMenuSocialProfileTab() throws Exception {
        clickPersonalInformationButton();
        verifyPersonalInformationMenu();

        WebElement accountSettingsPagePersonalInformationMenuSocialProfileTab = driver.findElement(accountSettingsPagePersonalInformationMenuSocialProfileTabLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuSocialProfileTab.isDisplayed(), "Social Profile tab ko duoc hien thi.");

        accountSettingsPagePersonalInformationMenuSocialProfileTab.click();

        assertTrue(accountSettingsPagePersonalInformationMenuSocialProfileTab.getAttribute("aria-selected").contains("true"), "Social Profile Tab chua duoc chon.");

        Thread.sleep(Duration.ofSeconds(1));
    }

    public void clearAndEnterFacebookInput(String facebook) {
        WebElement accountSettingsPagePersonalInformationMenuFacebookInput = driver.findElement(accountSettingsPagePersonalInformationMenuFacebookInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuFacebookInput.isDisplayed(), "Social Profile facebook input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuFacebookInput.isEnabled(), "Social Profile facebook input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuFacebookInput.clear();
        accountSettingsPagePersonalInformationMenuFacebookInput.sendKeys(facebook);
    }

    public void clearAndEnterTwitterInput(String twitter) {
        WebElement accountSettingsPagePersonalInformationMenuTwitterInput = driver.findElement(accountSettingsPagePersonalInformationMenuTwitterInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuTwitterInput.isDisplayed(), "Social Profile Twitter input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuTwitterInput.isEnabled(), "Social Profile Twitter input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuTwitterInput.clear();
        accountSettingsPagePersonalInformationMenuTwitterInput.sendKeys(twitter);
    }

    public void clearAndEnterGoogleInput(String google) {
        WebElement accountSettingsPagePersonalInformationMenuGoogleInput = driver.findElement(accountSettingsPagePersonalInformationMenuGoogleInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuGoogleInput.isDisplayed(), "Social Profile Google input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuGoogleInput.isEnabled(), "Social Profile Google input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuGoogleInput.clear();
        accountSettingsPagePersonalInformationMenuGoogleInput.sendKeys(google);
    }

    public void clearAndEnterLinkedinInput(String linkedin) {
        WebElement accountSettingsPagePersonalInformationMenuLinkedinInput = driver.findElement(accountSettingsPagePersonalInformationMenuLinkedinInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuLinkedinInput.isDisplayed(), "Social Profile Linkedin input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuLinkedinInput.isEnabled(), "Social Profile Linkedin input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuLinkedinInput.clear();
        accountSettingsPagePersonalInformationMenuLinkedinInput.sendKeys(linkedin);
    }

    public void clickUpdateSocialButton() {
        WebElement accountSettingsPagePersonalInformationMenuUpdateSocialButton = driver.findElement(accountSettingsPagePersonalInformationMenuUpdateSocialButtonLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuUpdateSocialButton.isDisplayed(), "Update Social button ko hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuUpdateSocialButton.isEnabled(), "Update Social button ko the tuong tac.");

        action.moveToElement(accountSettingsPagePersonalInformationMenuUpdateSocialButton);
        accountSettingsPagePersonalInformationMenuUpdateSocialButton.click();
    }

    public void editPersonalInformationSocialProfileSuccess(String facebook, String twitter, String google, String linkedin) throws Exception {
        viewPersonalInformationMenuSocialProfileTab();
        clearAndEnterFacebookInput(facebook);
        clearAndEnterTwitterInput(twitter);
        clearAndEnterGoogleInput(google);
        clearAndEnterLinkedinInput(linkedin);
        clickUpdateSocialButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Social information updated."), "Edit Personal Information Social Profile success confirm ko dc hien thi.");
    }

    public void viewPersonalInformationMenuBankAccountTab() throws Exception {
        clickPersonalInformationButton();
        verifyPersonalInformationMenu();

        WebElement accountSettingsPagePersonalInformationMenuBankAccountTab = driver.findElement(accountSettingsPagePersonalInformationMenuBankAccountTabLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuBankAccountTab.isDisplayed(), "Bank Account tab ko duoc hien thi.");

        accountSettingsPagePersonalInformationMenuBankAccountTab.click();

        assertTrue(accountSettingsPagePersonalInformationMenuBankAccountTab.getAttribute("aria-selected").contains("true"), "Bank Account Tab chua duoc chon.");

        Thread.sleep(Duration.ofSeconds(1));
    }

    public void clearAndEnterAccountTitleInput(String accountTitle) {
        WebElement accountSettingsPagePersonalInformationMenuAccountTitleInput = driver.findElement(accountSettingsPagePersonalInformationMenuAccountTitleInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuAccountTitleInput.isDisplayed(), "Account title input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuAccountTitleInput.isEnabled(), "Account title input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuAccountTitleInput.clear();
        accountSettingsPagePersonalInformationMenuAccountTitleInput.sendKeys(accountTitle);
    }

    public void clearAndEnterAccountNumberInput(String accountNumber) {
        WebElement accountSettingsPagePersonalInformationMenuAccountNumberInput = driver.findElement(accountSettingsPagePersonalInformationMenuAccountNumberInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuAccountNumberInput.isDisplayed(), "Account number input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuAccountNumberInput.isEnabled(), "Account number input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuAccountNumberInput.clear();
        accountSettingsPagePersonalInformationMenuAccountNumberInput.sendKeys(accountNumber);
    }

    public void clearAndEnterBankNameInput(String bankName) {
        WebElement accountSettingsPagePersonalInformationMenuBankNameInput = driver.findElement(accountSettingsPagePersonalInformationMenuBankNameInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuBankNameInput.isDisplayed(), "Bank name input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuBankNameInput.isEnabled(), "Bank name input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuBankNameInput.clear();
        accountSettingsPagePersonalInformationMenuBankNameInput.sendKeys(bankName);
    }

    public void clearAndEnterIbanInput(String iban) {
        WebElement accountSettingsPagePersonalInformationMenuIbanInput = driver.findElement(accountSettingsPagePersonalInformationMenuIbanInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuIbanInput.isDisplayed(), "Iban input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuIbanInput.isEnabled(), "Iban input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuIbanInput.clear();
        accountSettingsPagePersonalInformationMenuIbanInput.sendKeys(iban);
    }

    public void clearAndEnterSwiftCodeInput(String swiftCode) {
        WebElement accountSettingsPagePersonalInformationMenuSwiftCodeInput = driver.findElement(accountSettingsPagePersonalInformationMenuSwiftCodeInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuSwiftCodeInput.isDisplayed(), "Swift Code input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuSwiftCodeInput.isEnabled(), "Swift Code input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuSwiftCodeInput.clear();
        accountSettingsPagePersonalInformationMenuSwiftCodeInput.sendKeys(swiftCode);
    }

    public void clearAndEnterBankBranchTextarea(String bankBranch) {
        WebElement accountSettingsPagePersonalInformationMenuBankBranchTextarea = driver.findElement(accountSettingsPagePersonalInformationMenuBankBranchTextareaLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuBankBranchTextarea.isDisplayed(), "Bank Branch Textarea ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuBankBranchTextarea.isEnabled(), "Bank Branch Textarea ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuBankBranchTextarea.clear();
        accountSettingsPagePersonalInformationMenuBankBranchTextarea.sendKeys(bankBranch);
    }

    public void clickUpdateBankInfoButton() {
        WebElement accountSettingsPagePersonalInformationMenuUpdateBankInfoButton = driver.findElement(accountSettingsPagePersonalInformationMenuUpdateBankInfoButtonLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuUpdateBankInfoButton.isDisplayed(), "Update bank info button ko hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuUpdateBankInfoButton.isEnabled(), "Update bank info button ko the tuong tac.");

        action.moveToElement(accountSettingsPagePersonalInformationMenuUpdateBankInfoButton);
        accountSettingsPagePersonalInformationMenuUpdateBankInfoButton.click();
    }

    public void editPersonalInformationBankAccountSuccess(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Bank account updated."), "Edit Personal Information Bank Account success confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptyAccountTitle(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The account_title field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptyAccountNumber(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The account_number field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptyBankName(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The bank_name field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptyIban(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The iban field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptySwiftCode(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The swift_code field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationBankAccountFailEmptyBankBranch(String accountTitle, String accountNumber, String bankName, String iban, String swiftCode, String bankBranch) throws Exception {
        viewPersonalInformationMenuBankAccountTab();
        clearAndEnterAccountTitleInput(accountTitle);
        clearAndEnterAccountNumberInput(accountNumber);
        clearAndEnterBankNameInput(bankName);
        clearAndEnterIbanInput(iban);
        clearAndEnterSwiftCodeInput(swiftCode);
        clearAndEnterBankBranchTextarea(bankBranch);
        clickUpdateBankInfoButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The bank_branch field is required."), "Edit Personal Information Bank Account fail confirm ko dc hien thi.");
    }

    public void viewPersonalInformationMenuEmergencyContactTab() throws Exception {
        clickPersonalInformationButton();
        verifyPersonalInformationMenu();

        WebElement accountSettingsPagePersonalInformationMenuEmergencyConntactTab = driver.findElement(accountSettingsPagePersonalInformationMenuEmergencyContactTabLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuEmergencyConntactTab.isDisplayed(), "Emergency contact tab ko duoc hien thi.");

        accountSettingsPagePersonalInformationMenuEmergencyConntactTab.click();

        assertTrue(accountSettingsPagePersonalInformationMenuEmergencyConntactTab.getAttribute("aria-selected").contains("true"), "Emergency contact Tab chua duoc chon.");

        Thread.sleep(Duration.ofSeconds(1));
    }

    public void clearAndEnterFullName(String fullName) {
        WebElement accountSettingsPagePersonalInformationMenuFullNameInput = driver.findElement(accountSettingsPagePersonalInformationMenuFullNameInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuFullNameInput.isDisplayed(), "Full name input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuFullNameInput.isEnabled(), "Full name input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuFullNameInput.clear();
        accountSettingsPagePersonalInformationMenuFullNameInput.sendKeys(fullName);
    }

    public void clearAndEnterContactNumber(String contactNumber) {
        WebElement accountSettingsPagePersonalInformationMenuContactNumberInput = driver.findElement(accountSettingsPagePersonalInformationMenuContactNumberInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuContactNumberInput.isDisplayed(), "Contact Number input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuContactNumberInput.isEnabled(), "Contact Number input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuContactNumberInput.clear();
        accountSettingsPagePersonalInformationMenuContactNumberInput.sendKeys(contactNumber);
    }

    public void clearAndEnterEmail(String email) {
        WebElement accountSettingsPagePersonalInformationMenuEmailInput = driver.findElement(accountSettingsPagePersonalInformationMenuEmailInputLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuEmailInput.isDisplayed(), "Email input ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuEmailInput.isEnabled(), "Email input ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuEmailInput.clear();
        accountSettingsPagePersonalInformationMenuEmailInput.sendKeys(email);
    }

    public void clearAndEnterAddress(String address) {
        WebElement accountSettingsPagePersonalInformationMenuAddressTextarea = driver.findElement(accountSettingsPagePersonalInformationMenuAddressTextareaLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuAddressTextarea.isDisplayed(), "Address textarea ko duoc hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuAddressTextarea.isEnabled(), "Address textarea ko the tuong tac.");

        accountSettingsPagePersonalInformationMenuAddressTextarea.clear();
        accountSettingsPagePersonalInformationMenuAddressTextarea.sendKeys(address);
    }

    public void clickUpdateContactButton() {
        WebElement accountSettingsPagePersonalInformationMenuUpdateContactButton = driver.findElement(accountSettingsPagePersonalInformationMenuUpdateContactButtonLocator);

        assertTrue(accountSettingsPagePersonalInformationMenuUpdateContactButton.isDisplayed(), "Update contact button ko hien thi.");
        assertTrue(accountSettingsPagePersonalInformationMenuUpdateContactButton.isEnabled(), "Update contact button ko the tuong tac.");

        action.moveToElement(accountSettingsPagePersonalInformationMenuUpdateContactButton);
        accountSettingsPagePersonalInformationMenuUpdateContactButton.click();
    }

    public void editPersonalInformationEmergencyContactSuccess(String fullName, String contactNumber, String email, String address) throws Exception {
        viewPersonalInformationMenuEmergencyContactTab();
        clearAndEnterFullName(fullName);
        clearAndEnterContactNumber(contactNumber);
        clearAndEnterEmail(email);
        clearAndEnterAddress(address);
        clickUpdateContactButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Emergency contact updated."), "Edit Personal Information Emergency Contact success confirm ko dc hien thi.");
    }

    public void editPersonalInformationEmergencyContactFailEmptyFullName(String fullName, String contactNumber, String email, String address) throws Exception {
        viewPersonalInformationMenuEmergencyContactTab();
        clearAndEnterFullName(fullName);
        clearAndEnterContactNumber(contactNumber);
        clearAndEnterEmail(email);
        clearAndEnterAddress(address);
        clickUpdateContactButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The full name field is required."), "Edit Personal Information Emergency Contact fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationEmergencyContactFailEmptyContactNumber(String fullName, String contactNumber, String email, String address) throws Exception {
        viewPersonalInformationMenuEmergencyContactTab();
        clearAndEnterFullName(fullName);
        clearAndEnterContactNumber(contactNumber);
        clearAndEnterEmail(email);
        clearAndEnterAddress(address);
        clickUpdateContactButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The contact number field is required."), "Edit Personal Information Emergency Contact fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationEmergencyContactFailEmptyEmail(String fullName, String contactNumber, String email, String address) throws Exception {
        viewPersonalInformationMenuEmergencyContactTab();
        clearAndEnterFullName(fullName);
        clearAndEnterContactNumber(contactNumber);
        clearAndEnterEmail(email);
        clearAndEnterAddress(address);
        clickUpdateContactButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The contact_email field is required."), "Edit Personal Information Emergency Contact fail confirm ko dc hien thi.");
    }

    public void editPersonalInformationEmergencyContactFailEmptyAddress(String fullName, String contactNumber, String email, String address) throws Exception {
        viewPersonalInformationMenuEmergencyContactTab();
        clearAndEnterFullName(fullName);
        clearAndEnterContactNumber(contactNumber);
        clearAndEnterEmail(email);
        clearAndEnterAddress(address);
        clickUpdateContactButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));
        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The contact_address field is required."), "Edit Personal Information Emergency Contact fail confirm ko dc hien thi.");
    }

    public void clickProfilePictureButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageProfilePictureButton = driver.findElement(accountSettingsPageProfilePictureButtonLocator);

        assertTrue(accountSettingsPageProfilePictureButton.isDisplayed(), "Profile Picture Button ko duoc hien thi.");

        accountSettingsPageProfilePictureButton.click();
    }

    public void verifyProfilePictureMenu() {
        WebElement accountSettingsPageProfilePictureMenu = driver.findElement(accountSettingsPageProfilePictureMenuLocator);

        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageProfilePictureMenu));

        WebElement accountSettingsPageProfilePictureMenuHeader = driver.findElement(accountSettingsPageProfilePictureMenuHeaderLocator);

        assertTrue(accountSettingsPageProfilePictureMenuHeader.getText().contains("Profile Picture"), "Profile Picture Menu chua duoc hien thi.");
    }

    public void clickUpdatePictureButton() {
        WebElement accountSettingsPageProfilePictureMenuUpdatePictureButton = driver.findElement(accountSettingsPageProfilePictureMenuUpdatePictureButtonLocator);

        assertTrue(accountSettingsPageProfilePictureMenuUpdatePictureButton.isDisplayed(), "Update picture button ko hien thi.");
        assertTrue(accountSettingsPageProfilePictureMenuUpdatePictureButton.isEnabled(), "Update picture button ko the tuong tac.");

        action.moveToElement(accountSettingsPageProfilePictureMenuUpdatePictureButton);
        accountSettingsPageProfilePictureMenuUpdatePictureButton.click();
    }

    public void updateProfilePictureSuccess(String profilePicture) throws Exception {
        clickProfilePictureButton();
        verifyProfilePictureMenu();
        WebElement accountSettingsPageProfilePictureMenuProfilePictureInput = driver.findElement(accountSettingsPageProfilePictureMenuProfilePictureInputLocator);
        accountSettingsPageProfilePictureMenuProfilePictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/java/resource/" + profilePicture);
        clickUpdatePictureButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Basic Information updated."), "Edit Profile Picture success confirm ko dc hien thi.");
    }

    public void updateProfilePictureFailEmptyFile() throws Exception {
        clickProfilePictureButton();
        verifyProfilePictureMenu();
        clickUpdatePictureButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The profile picture field is required."), "Edit Profile Picture fail confirm ko dc hien thi.");
    }

    public void updateProfilePictureFailNotImageFile(String profilePicture) throws Exception {
        clickProfilePictureButton();
        verifyProfilePictureMenu();
        WebElement accountSettingsPageProfilePictureMenuProfilePictureInput = driver.findElement(accountSettingsPageProfilePictureMenuProfilePictureInputLocator);
        accountSettingsPageProfilePictureMenuProfilePictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/java/resource/" + profilePicture);
        clickUpdatePictureButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The profile picture field is required."), "Edit Profile Picture fail confirm ko dc hien thi.");
    }

    public void updateProfilePictureFailImageSizeTooLarge(String profilePicture) throws Exception {
        clickProfilePictureButton();
        verifyProfilePictureMenu();
        WebElement accountSettingsPageProfilePictureMenuProfilePictureInput = driver.findElement(accountSettingsPageProfilePictureMenuProfilePictureInputLocator);
        accountSettingsPageProfilePictureMenuProfilePictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/java/resource/" + profilePicture);
        clickUpdatePictureButton();

        largeWait.until(ExpectedConditions.visibilityOfElementLocated(accountSettingsPageConfirmMessageLocator));
        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The profile picture field is required."), "Edit Profile Picture fail confirm ko dc hien thi.");
    }

    public void clickAccountInformationButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageAccountInformationButton = driver.findElement(accountSettingsPageAccountInformationButtonLocator);

        assertTrue(accountSettingsPageAccountInformationButton.isDisplayed(), "Account Information Button ko duoc hien thi.");

        accountSettingsPageAccountInformationButton.click();
    }

    public void verifyAccountInformationMenu() {
        WebElement accountSettingsPageAccountInformationMenu = driver.findElement(accountSettingsPageAccountInformationMenuLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageAccountInformationMenu));

        WebElement accountSettingsPageAccountInformationMenuHeader = driver.findElement(accountSettingsPageAccountInformationMenuHeaderLocator);
        assertTrue(accountSettingsPageAccountInformationMenuHeader.getText().contains("Account Information"), "Account Information Menu chua duoc hien thi.");
    }

    public void viewAccountInformation() throws Exception {
        clickAccountInformationButton();
        verifyAccountInformationMenu();
    }

    public void clearAndEnterUsername(String username) {
        WebElement accountSettingsPageAccountInformationMenuUsernameInput = driver.findElement(accountSettingsPageAccountInformationMenuUsernameInputLocator);

        assertTrue(accountSettingsPageAccountInformationMenuUsernameInput.isDisplayed(), "Username input ko duoc hien thi.");
        assertTrue(accountSettingsPageAccountInformationMenuUsernameInput.isDisplayed(), "Username input ko the tuong tac.");

        accountSettingsPageAccountInformationMenuUsernameInput.clear();
        accountSettingsPageAccountInformationMenuUsernameInput.sendKeys(username);
    }

    public void clearAndEnterAccountEmail (String email) {
        WebElement accountSettingsPageAccountInformationMenuAccountEmailInput = driver.findElement(accountSettingsPageAccountInformationMenuAccountEmailInputLocator);

        assertTrue(accountSettingsPageAccountInformationMenuAccountEmailInput.isDisplayed(), "Account Email Input ko duoc hien thi.");
        assertTrue(accountSettingsPageAccountInformationMenuAccountEmailInput.isEnabled(), "Account Email Input ko the tuong tac.");

        accountSettingsPageAccountInformationMenuAccountEmailInput.clear();
        accountSettingsPageAccountInformationMenuAccountEmailInput.sendKeys(email);
    }

    public void clickSaveAccountInformationButton() {
        WebElement accountSettingsPageAccountInformationMenuSaveAccountInformationButton = driver.findElement(accountSettingsPageAccountInformationMenuSaveAccountInformationButtonLocator);

        assertTrue(accountSettingsPageAccountInformationMenuSaveAccountInformationButton.isDisplayed(), "Save Account Information Button ko duoc hien thi.");
        assertTrue(accountSettingsPageAccountInformationMenuSaveAccountInformationButton.isEnabled(), "Save Account Information Button ko the tuong tac.");

        action.moveToElement(accountSettingsPageAccountInformationMenuSaveAccountInformationButton);
        accountSettingsPageAccountInformationMenuSaveAccountInformationButton.click();
    }

    public void editAccountInformationSuccess(String username, String accountEmail) throws Exception {
        viewAccountInformation();
        clearAndEnterUsername(username);
        clearAndEnterAccountEmail(accountEmail);
        clickSaveAccountInformationButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Account information updated."), "Edit Account Information success confirm ko dc hien thi.");
    }

    public void editAccountInformationFailEmptyUsername(String username, String accountEmail) throws Exception {
        viewAccountInformation();
        clearAndEnterUsername(username);
        clearAndEnterAccountEmail(accountEmail);
        clickSaveAccountInformationButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The username field is required."), "Edit Account Information fail confirm ko dc hien thi.");
    }

    public void editAccountInformationFailEmptyAccountEmail(String username, String accountEmail) throws Exception {
        viewAccountInformation();
        clearAndEnterUsername(username);
        clearAndEnterAccountEmail(accountEmail);
        clickSaveAccountInformationButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The email field is required."), "Edit Account Information fail confirm ko dc hien thi.");
    }

    public void editAccountInformationFailInvalidEmail(String username, String accountEmail) throws Exception {
        viewAccountInformation();
        clearAndEnterUsername(username);
        clearAndEnterAccountEmail(accountEmail);
        clickSaveAccountInformationButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The email field must contain a valid email address."), "Edit Account Information fail confirm ko dc hien thi.");
    }

    public void clickDocumentsButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageDocumentsButton = driver.findElement(accountSettingsPageDocumentsButtonLocator);

        assertTrue(accountSettingsPageDocumentsButton.isDisplayed(), "Documents Button ko duoc hien thi.");

        accountSettingsPageDocumentsButton.click();
    }

    public void verifyDocumentsMenu() {
        WebElement accountSettingsPageDocumentsMenu = driver.findElement(accountSettingsPageDocumentsMenuLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageDocumentsMenu));

        WebElement accountSettingsPageDocumentsMenuHeader = driver.findElement(accountSettingsPageDocumentsMenuHeaderLocator);
        assertTrue(accountSettingsPageDocumentsMenuHeader.getText().contains("Documents"), "Documents Menu chua duoc hien thi.");
    }

    public void viewDocumentsMenu() throws Exception {
        clickDocumentsButton();
        verifyDocumentsMenu();
    }

    public void clickChangePasswordButton() throws Exception {
        navigateToAccountSettingsPage();

        WebElement accountSettingsPageChangePasswordButton = driver.findElement(accountSettingsPageChangePasswordButtonLocator);

        assertTrue(accountSettingsPageChangePasswordButton.isDisplayed(), "Change Password Button ko duoc hien thi.");

        accountSettingsPageChangePasswordButton.click();
    }

    public void verifyChangePasswordMenu() {
        WebElement accountSettingsPageChangePasswordMenu = driver.findElement(accountSettingsPageChangePasswordMenuLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageChangePasswordMenu));

        WebElement accountSettingsPageChangePasswordMenuHeader = driver.findElement(accountSettingsPageChangePasswordMenuHeaderLocator);
        assertTrue(accountSettingsPageChangePasswordMenuHeader.getText().contains("Change Password"), "Change Password Menu chua duoc hien thi.");

        WebElement accountSettingsPageChangePasswordMenuCurrentPasswordInput = driver.findElement(accountSettingsPageChangePasswordMenuCurrentPasswordInputLocator);
        assertTrue(accountSettingsPageChangePasswordMenuCurrentPasswordInput.isDisplayed(), "Current Password Input ko duoc hien thi.");
        assertEquals(accountSettingsPageChangePasswordMenuCurrentPasswordInput.getAttribute("readonly"), "true", "Current Password Input co the tuong tac.");
    }

    public void viewChangePasswordMenu() throws Exception {
        clickChangePasswordButton();
        verifyChangePasswordMenu();
    }

    public void clearAndEnterNewPassword(String newPassword) throws Exception {
        WebElement accountSettingsPageChangePasswordMenuNewPasswordInput = driver.findElement(accountSettingsPageChangePasswordMenuNewPasswordInputLocator);

        assertTrue(accountSettingsPageChangePasswordMenuNewPasswordInput.isDisplayed(), "New Password Input ko duoc hien thi.");
        assertTrue(accountSettingsPageChangePasswordMenuNewPasswordInput.isEnabled(), "New Password Input ko the tuong tac.");

        accountSettingsPageChangePasswordMenuNewPasswordInput.clear();
        accountSettingsPageChangePasswordMenuNewPasswordInput.sendKeys(newPassword);
    }

    public void clearAndEnterRepeatNewPassword(String repeatNewPassword) throws Exception {
        WebElement accountSettingsPageChangePasswordMenuRepeatNewPasswordInput = driver.findElement(accountSettingsPageChangePasswordMenuRepeatNewPasswordInputLocator);

        assertTrue(accountSettingsPageChangePasswordMenuRepeatNewPasswordInput.isDisplayed(), "Repeat New Password Input ko duoc hien thi.");
        assertTrue(accountSettingsPageChangePasswordMenuRepeatNewPasswordInput.isEnabled(), "Repeat New Password Input ko the tuong tac.");

        accountSettingsPageChangePasswordMenuRepeatNewPasswordInput.clear();
        accountSettingsPageChangePasswordMenuRepeatNewPasswordInput.sendKeys(repeatNewPassword);
    }

    public void clickConfirmChangePasswordButton() {
        WebElement accountSettingsPageChangePasswordMenuChangePasswordButton = driver.findElement(accountSettingsPageChangePasswordMenuChangePasswordButtonLocator);

        assertTrue(accountSettingsPageChangePasswordMenuChangePasswordButton.isDisplayed(), "Change Password Button ko duoc hien thi.");
        assertTrue(accountSettingsPageChangePasswordMenuChangePasswordButton.isEnabled(), "Change Password Button ko the tuong tac.");

        accountSettingsPageChangePasswordMenuChangePasswordButton.click();
    }

    public void changePasswordSuccess(String newPassword, String repeatNewPassword) throws Exception {
        viewChangePasswordMenu();
        clearAndEnterNewPassword(newPassword);
        clearAndEnterRepeatNewPassword(repeatNewPassword);
        clickConfirmChangePasswordButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Your new password has been updated. Next time you can login with new password."), "Change Password success confirm ko dc hien thi.");
    }

    public void changePasswordFailEmptyNewPassword(String newPassword, String repeatNewPassword) throws Exception {
        viewChangePasswordMenu();
        clearAndEnterNewPassword(newPassword);
        clearAndEnterRepeatNewPassword(repeatNewPassword);
        clickConfirmChangePasswordButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The new password field is required."), "Change Password fail confirm ko dc hien thi.");
    }

    public void changePasswordFailEmptyRepeatNewPassword(String newPassword, String repeatNewPassword) throws Exception {
        viewChangePasswordMenu();
        clearAndEnterNewPassword(newPassword);
        clearAndEnterRepeatNewPassword(repeatNewPassword);
        clickConfirmChangePasswordButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The confirm password field is required."), "Change Password fail confirm ko dc hien thi.");
    }

    public void changePasswordFailNewPasswordNotMatchRepeatNewPassword(String newPassword, String repeatNewPassword) throws Exception {
        viewChangePasswordMenu();
        clearAndEnterNewPassword(newPassword);
        clearAndEnterRepeatNewPassword(repeatNewPassword);
        clickConfirmChangePasswordButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("The repeat password does not match with new password!!"), "Change Password fail confirm ko dc hien thi.");
    }

    public void changePasswordFailNewPasswordTooShort(String newPassword, String repeatNewPassword) throws Exception {
        viewChangePasswordMenu();
        clearAndEnterNewPassword(newPassword);
        clearAndEnterRepeatNewPassword(repeatNewPassword);
        clickConfirmChangePasswordButton();

        WebElement accountSettingsPageConfirmMessage = driver.findElement(accountSettingsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(accountSettingsPageConfirmMessage));

        assertTrue(accountSettingsPageConfirmMessage.getText().contains("Your password is too short. It should be minimum 6 characters"), "Change Password fail confirm ko dc hien thi.");
    }

    public void clickTodoListButton() {
        WebElement homePageTodoListButton = driver.findElement(homePageTodoListButtonLocator);

        assertTrue(homePageTodoListButton.isDisplayed(), "Todo List Button ko duoc hien thi.");

        homePageTodoListButton.click();
    }

    public void navigateToTodoListPage() throws InterruptedException {
        clickTodoListButton();

        Thread.sleep(Duration.ofSeconds(1));

        assertEquals(driver.getTitle(), "Todo items | HRM | Anh Tester Demo");
    }

    public void verifyTodoListPage() throws Exception {
        WebElement todoListPageHeader = driver.findElement(todoListPageHeaderLocator);
        assertTrue(todoListPageHeader.getText().contains("Todo items"), "Todo List Page Header chua duoc hien thi.");
    }

    public void viewTodoListPage() throws Exception {
        navigateToTodoListPage();
        verifyTodoListPage();
    }

    public void clearAndEnterTask(String task) {
        WebElement todoListPageTodoInput = driver.findElement(todoListPageTaskInputLocator);

        assertTrue(todoListPageTodoInput.isDisplayed(), "Task Input ko duoc hien thi.");
        assertTrue(todoListPageTodoInput.isEnabled(), "Task Input ko the tuong tac.");

        todoListPageTodoInput.clear();
        todoListPageTodoInput.sendKeys(task);
    }

    public void clickAddTaskButton() {
        WebElement todoListPageAddTaskButton = driver.findElement(todoListPageAddTaskButtonLocator);

        assertTrue(todoListPageAddTaskButton.isDisplayed(), "Add Task Button ko duoc hien thi.");
        assertTrue(todoListPageAddTaskButton.isEnabled(), "Add Task Button ko the tuong tac.");

        todoListPageAddTaskButton.click();
    }

    public void addTaskSuccess(String task) throws Exception {
        viewTodoListPage();
        clearAndEnterTask(task);
        clickAddTaskButton();

        Thread.sleep(Duration.ofSeconds(5));

        List<WebElement> todoListPageListTask = driver.findElements(todoListPageListTaskLocator);
        System.out.print(todoListPageListTask.size());
        assertTrue(driver.findElement(By.xpath("//div[@class='new-task']//div[" + todoListPageListTask.size() + "]//div[1]//label//span")).getText().contains(task) , "Add Task fail.");
    }

    public void addTaskFailEmptyTask(String task) throws Exception {
        viewTodoListPage();
        clearAndEnterTask(task);
        clickAddTaskButton();

        WebElement todoListPageConfirmMessage = driver.findElement(todoListPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(todoListPageConfirmMessage));

        assertTrue(todoListPageConfirmMessage.getText().contains("The Item field is required."), "Add Task fail confirm ko dc hien thi.");
    }

    public void checkTask(String taskID) throws Exception {
        viewTodoListPage();

        List<WebElement> todoListPageListTask = driver.findElements(todoListPageListTaskLocator);
        for(int i = 1; i <= todoListPageListTask.size(); i++) {
            WebElement taskCheckBoxInput = driver.findElement(By.xpath("//div[@class='new-task']//div[" + i + "]//div[1]//label//input"));
            WebElement taskCheckBoxSpan = driver.findElement(By.xpath("//div[@class='new-task']//div[" + i + "]//div[1]//label//span"));

            if(taskCheckBoxInput.isSelected()) {
                System.out.println("Checkbox " + i + " da duoc chon.");
                System.out.println("Khong lam gi va tinh la testcase pass vi khong the check 1 checkbox da duoc check.");
                System.out.println("----");
            }
            else {
                System.out.println("Checkbox " + i + " chua duoc chon.");
                if(taskCheckBoxInput.getAttribute("data-field-id").equals(taskID)) {
                    System.out.println("Checkbox " + i + " co id giong voi task id da truyen vao.");
                    System.out.println("Thuc hien check vao checkbox " + i + ".");
                    action.moveToElement(taskCheckBoxSpan);
                    taskCheckBoxSpan.click();

                    WebElement todoListPageConfirmMessage = driver.findElement(todoListPageConfirmMessageLocator);
                    wait.until(ExpectedConditions.visibilityOf(todoListPageConfirmMessage));

                    assertTrue(todoListPageConfirmMessage.getText().contains("Item updated."), "Check task success confirm message ko duoc hien thi.");
                }
                else {
                    System.out.println("Checkbox " + i + " khong co id giong voi task id da truyen vao.");
                    System.out.println("Task ID truyen vao: " + taskID);
                    System.out.println("ID checkbox " + i + ": " + taskCheckBoxInput.getAttribute("data-field-id"));
                }
                System.out.println("----");
            }
        }
    }

    public void uncheckTask(String taskID) throws Exception {
        viewTodoListPage();

        List<WebElement> todoListPageListTask = driver.findElements(todoListPageListTaskLocator);
        for(int i = 1; i <= todoListPageListTask.size(); i++) {
            WebElement taskCheckBoxInput = driver.findElement(By.xpath("//div[@class='new-task']//div[" + i + "]//div[1]//label//input"));
            WebElement taskCheckBoxSpan = driver.findElement(By.xpath("//div[@class='new-task']//div[" + i + "]//div[1]//label//span"));

            if(!taskCheckBoxInput.isSelected()) {
                System.out.println("Checkbox " + i + " chua duoc chon.");
                System.out.println("Khong lam gi va tinh la testcase pass vi khong the uncheck 1 checkbox khong duoc check.");
                System.out.println("----");
            }
            else {
                System.out.println("Checkbox " + i + " da duoc chon.");
                if(taskCheckBoxInput.getAttribute("data-field-id").equals(taskID)) {
                    System.out.println("Checkbox " + i + " co id giong voi task id da truyen vao.");
                    System.out.println("Thuc hien uncheck vao checkbox " + i + ".");
                    action.moveToElement(taskCheckBoxSpan);
                    taskCheckBoxSpan.click();

                    WebElement todoListPageConfirmMessage = driver.findElement(todoListPageConfirmMessageLocator);
                    wait.until(ExpectedConditions.visibilityOf(todoListPageConfirmMessage));

                    assertTrue(todoListPageConfirmMessage.getText().contains("Item updated."), "Uncheck task success confirm message ko duoc hien thi.");
                }
                else {
                    System.out.println("Checkbox " + i + " khong co id giong voi task id da truyen vao.");
                    System.out.println("Task ID truyen vao: " + taskID);
                    System.out.println("ID checkbox " + i + ": " + taskCheckBoxInput.getAttribute("data-field-id"));
                }
                System.out.println("----");
            }
        }
    }

    public void deleteTask(String taskID) throws Exception {
        viewTodoListPage();

        WebElement deleteTaskButton = null;
        try {
            deleteTaskButton = driver.findElement(By.xpath("//a[@data-fieldid='" + taskID + "']"));
            action.moveToElement(deleteTaskButton);
            deleteTaskButton.click();

            WebElement todoListPageConfirmMessage = driver.findElement(todoListPageConfirmMessageLocator);
            wait.until(ExpectedConditions.visibilityOf(todoListPageConfirmMessage));

            assertTrue(todoListPageConfirmMessage.getText().contains("Item deleted."), "Delete task success confirm message ko duoc hien thi.");
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Task khong ton tai.");
        }
    }


    public void AutoCheckIn() throws Exception {
        WebElement homePageClockInButton = driver.findElement(homePageClockInButtonLocator);

        if(Objects.equals(homePageClockInButton.getAttribute("disabled"), "true")) {
            System.out.println("Button Clock In da duoc click.");
            System.out.println("Khong lam gi va tinh la testcase pass vi button Clock In da duoc click truoc do nhung chua click button Clock Out.");
        }
        else {
            assertTrue(homePageClockInButton.isDisplayed(), "Button Clock In ko duoc hien thi.");
            assertTrue(homePageClockInButton.isEnabled(), "Button Clock In ko the tuong tac.");

            homePageClockInButton.click();
        }
    }

    public void AutoCheckOut() throws Exception {
        WebElement homePageClockOutButton = driver.findElement(homePageClockOutButtonLocator);

        if(Objects.equals(homePageClockOutButton.getAttribute("disabled"), "true")) {
            System.out.println("Button Clock Out da duoc click.");
            System.out.println("Khong lam gi va tinh la testcase pass vi button Clock Out da duoc click truoc do nhung chua click button Clock In.");
        }
        else {
            assertTrue(homePageClockOutButton.isDisplayed(), "Button Clock Out ko duoc hien thi.");
            assertTrue(homePageClockOutButton.isEnabled(), "Button Clock Out ko the tuong tac.");

            homePageClockOutButton.click();
        }
    }

    public void navigateToAttendancePage() throws Exception {
        WebElement homePageAttendanceButton = driver.findElement(homePageAttendanceButtonLocator);

        assertTrue(homePageAttendanceButton.isDisplayed(), "Button Attendance ko duoc hien thi.");

        homePageAttendanceButton.click();

        Thread.sleep(Duration.ofSeconds(1));

        assertTrue(driver.getTitle().contains("Attendance | HRM | Anh Tester Demo"), "Chuyen huong den trang attendance that bai.");
    }

    public void navigateToProjectsPage() throws Exception {
        WebElement homePageProjectsButton = driver.findElement(homePageProjectsButtonLocator);

        assertTrue(homePageProjectsButton.isDisplayed(), "Button Project ko duoc hien thi.");

        homePageProjectsButton.click();

        Thread.sleep(Duration.ofSeconds(1));

        assertTrue(driver.getTitle().contains("Projects | HRM | Anh Tester Demo"), "Chuyen huong den trang projects that bai.");
    }

    public void navigateToEmployeesPage() throws Exception {
        WebElement homePageEmployeesButton = driver.findElement(homePageEmployeesButtonLocator);

        assertTrue(homePageEmployeesButton.isDisplayed(), "Button Employees ko duoc hien thi.");

        homePageEmployeesButton.click();

        Thread.sleep(Duration.ofSeconds(1));

        assertTrue(driver.getTitle().contains("Employees | HRM | Anh Tester Demo"), "Chuyen huong den trang employees that bai.");
    }
}
