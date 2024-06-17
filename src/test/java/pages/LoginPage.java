package pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    WebDriverWait wait;

    private By loginPageUsernameInputLocator = By.xpath("//input[@id='iusername']");
    private By loginPagePasswordInputLocator = By.xpath("//input[@id='ipassword']");
    private By loginPageForgotPasswordLinkLocator = By.xpath("//span[normalize-space()='Forgot password?']");
    private By loginPageLoginButtonLocator = By.xpath("//button[@type='submit']");
    private By loginPageLoginSuccessConfirmLocator = By.xpath("//h2[@id='swal2-title']");
    private By loginPageLoginFailConfirmLocator = By.xpath("//div[@class='toast-message']");
    private By loginPageResetPasswordInputLocator = By.xpath("//input[@placeholder='Email address']");
    private By loginPageResetPasswordButtonLocator = By.xpath("//button[@type='submit']");
    private By loginPageRememberPasswordLinkLocator = By.xpath("//a[normalize-space()='Click here']");
    private By loginPageResetPasswordFailConfirmLocator = By.xpath("//div[@class='toast-message']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void navigateToLoginPage() {
        driver.get("https://hrm.anhtester.com/erp/login");

        assertEquals(driver.getTitle(), "HRM | Anh Tester Demo | Log in", "Trang hien tai ko phai trang Login Page.");
    }

    public void enterUsername(String username) {
        WebElement loginPageUsernameInput = driver.findElement(loginPageUsernameInputLocator);

        assertTrue(loginPageUsernameInput.isDisplayed(), "Username Input ko duoc hien thi.");
        assertTrue(loginPageUsernameInput.isEnabled(), "Username Input ko the tuong tac.");

        loginPageUsernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement loginPagePasswordInput = driver.findElement(loginPagePasswordInputLocator);

        assertTrue(loginPagePasswordInput.isDisplayed(), "Password Input ko duoc hien thi.");
        assertTrue(loginPagePasswordInput.isEnabled(), "Password Input ko the tuong tac.");

        loginPagePasswordInput.sendKeys(password);
    }

    public void clickForgotPassword() {
        WebElement loginPageForgotPasswordLink = driver.findElement(loginPageForgotPasswordLinkLocator);

        assertTrue(loginPageForgotPasswordLink.isDisplayed(), "Forgot Password Link ko duoc hien thi.");

        loginPageForgotPasswordLink.click();
    }

    public void clickLoginButton() {
        WebElement loginPageLoginButton = driver.findElement(loginPageLoginButtonLocator);

        assertTrue(loginPageLoginButton.isDisplayed(), "Login Button ko duoc hien thi.");
        assertTrue(loginPageLoginButton.isEnabled(), "Login Button ko the tuong tac.");

        loginPageLoginButton.click();
    }

    public void loginSuccess(String username, String password) throws Exception {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        WebElement loginPageLoginSuccessConfirm = driver.findElement(loginPageLoginSuccessConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginSuccessConfirm));

        assertTrue(loginPageLoginSuccessConfirm.getText().contains("Logged In Successfully."), "Login success confirm ko dc hien thi.");

        Thread.sleep(Duration.ofSeconds(3));

        assertTrue(driver.getTitle().contains("Home | HRM | Anh Tester Demo"), "Chua chuyen huong den trang Home.");
    }

    public void loginFailEmptyUsername(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        WebElement loginPageLoginFailConfirm = driver.findElement(loginPageLoginFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginFailConfirm));

        assertTrue(loginPageLoginFailConfirm.getText().contains("The username field is required."), "Login fail confirm ko dc hien thi.");
    }

    public void loginFailEmptyPassword(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        WebElement loginPageLoginFailConfirm = driver.findElement(loginPageLoginFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginFailConfirm));

        assertTrue(loginPageLoginFailConfirm.getText().contains("The password field is required."), "Login fail confirm ko dc hien thi.");
    }

    public void loginFailShortPassword(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        WebElement loginPageLoginFailConfirm = driver.findElement(loginPageLoginFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginFailConfirm));

        assertTrue(loginPageLoginFailConfirm.getText().contains("Your password is too short, minimum 6 characters required."), "Login fail confirm ko dc hien thi.");
    }

    public void loginFailInvalidCredentials(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        WebElement loginPageLoginFailConfirm = driver.findElement(loginPageLoginFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginFailConfirm));

        assertTrue(loginPageLoginFailConfirm.getText().contains("Invalid Login Credentials."), "Login fail confirm ko dc hien thi.");
    }

    public void navigateToResetPasswordPage() {
        navigateToLoginPage();
        clickForgotPassword();

        assertEquals(driver.getTitle(), "xin_lock_user", "Trang hien tai ko phai trang Reset password.");
    }

    public void enterEmail(String email) {
        WebElement loginPageResetPasswordInput = driver.findElement(loginPageResetPasswordInputLocator);

        assertTrue(loginPageResetPasswordInput.isDisplayed(), "Email Input ko duoc hien thi.");
        assertTrue(loginPageResetPasswordInput.isEnabled(), "Email Input ko the tuong tac.");

        loginPageResetPasswordInput.sendKeys(email);
    }

    public void clickResetPasswordButton() {
        WebElement loginPageResetPasswordButton = driver.findElement(loginPageResetPasswordButtonLocator);

        assertTrue(loginPageResetPasswordButton.isDisplayed(), "ResetPassword Button ko duoc hien thi.");
        assertTrue(loginPageResetPasswordButton.isEnabled(), "ResetPassword Button ko the tuong tac.");

        loginPageResetPasswordButton.click();
    }

    public void clickRememberPassword() {
        WebElement loginPageRememberPasswordLink = driver.findElement(loginPageRememberPasswordLinkLocator);

        assertTrue(loginPageRememberPasswordLink.isDisplayed(), "RememberPassword Link ko duoc hien thi.");

        loginPageRememberPasswordLink.click();
    }

    public void resetPasswordSuccess(String email) {
        navigateToResetPasswordPage();
        enterEmail(email);
        clickResetPasswordButton();

        WebElement loginPageResetPasswordFailConfirm = driver.findElement(loginPageResetPasswordFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageResetPasswordFailConfirm));

        assertTrue(loginPageResetPasswordFailConfirm.getText().contains("Main.xin_error_msg_not"), "Reset password success confirm ko dc hien thi.");
    }

    public void resetPasswordFailEmptyEmail(String email) {
        navigateToResetPasswordPage();
        enterEmail(email);
        clickResetPasswordButton();

        WebElement loginPageResetPasswordFailConfirm = driver.findElement(loginPageResetPasswordFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageResetPasswordFailConfirm));

        assertTrue(loginPageResetPasswordFailConfirm.getText().contains("The email field is required."), "Reset password fail confirm ko dc hien thi.");
    }

    public void resetPasswordFailInvalidEmail(String email) {
        navigateToResetPasswordPage();
        enterEmail(email);
        clickResetPasswordButton();

        WebElement loginPageResetPasswordFailConfirm = driver.findElement(loginPageResetPasswordFailConfirmLocator);
        wait.until(ExpectedConditions.visibilityOf(loginPageResetPasswordFailConfirm));

        assertTrue(loginPageResetPasswordFailConfirm.getText().contains("The email field must contain a valid email address."), "Reset password fail confirm ko dc hien thi.");
    }

    public void resetPasswordBackToLoginPage() {
        navigateToResetPasswordPage();
        clickRememberPassword();

        assertEquals(driver.getTitle(), "HRM | Anh Tester Demo | Log in", "Trang hien tai ko phai trang Login Page.");
    }
}