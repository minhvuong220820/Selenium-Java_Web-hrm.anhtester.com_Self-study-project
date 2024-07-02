package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmployeesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait largeWait;
    private Actions action;

    private By employeesSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[1]");
    private By employeesSectionTableLocator = By.xpath("//table[@id='xin_table']");

    private By itemsPerPageSelectLocator = By.xpath("//select[@name='xin_table_length']");
    private By dataTableInfoLocator = By.xpath("//div[@id='xin_table_info']");
    private By dataTableNextPageButtonLocator = By.xpath("//a[normalize-space()='Next']");
    private By employeesSectionSearchInputLocator = By.xpath("//input[@type='search']");

    private By employeesPageConfirmMessageLocator = By.xpath("//div[@class='toast-message']");

    private By employeesSectionAddNewButtonLocator = By.xpath("//a[normalize-space()='Add New']");
    private By employeesSectionAddNewEmployeeFormLocator = By.xpath("//div[@id='add_form']");
    private By employeesSectionAddNewEmployeeFormFirstNameInputLocator = By.xpath("//input[@placeholder='First Name']");
    private By employeesSectionAddNewEmployeeFormLastNameInputLocator = By.xpath("//input[@placeholder='Last Name']");
    private By employeesSectionAddNewEmployeeFormEmployeeIDInputLocator = By.xpath("//input[@placeholder='Employee ID']");
    private By employeesSectionAddNewEmployeeFormContactNumberLocator = By.xpath("//input[@placeholder='Contact Number']");
    private By employeesSectionAddNewEmployeeFormGenderSelectorLocator = By.xpath("//select[@name='gender']");
    private By employeesSectionAddNewEmployeeFormEmailInputLocator = By.xpath("//input[@placeholder='Email']");
    private By employeesSectionAddNewEmployeeFormUserNameInputLocator = By.xpath("//input[@placeholder='Username']");
    private By employeesSectionAddNewEmployeeFormPasswordInputLocator = By.xpath("//input[@placeholder='Password']");
    private By employeesSectionAddNewEmployeeFormOfficeShiftSelectorLocator = By.xpath("//select[@name='office_shift_id']");
    private By employeesSectionAddNewEmployeeFormRoleSelectorLocator = By.xpath("//select[@name='role']");
    private By employeesSectionAddNewEmployeeFormDepartmentSelectorLocator = By.xpath("//select[@id='department_id']");
    private By employeesSectionAddNewEmployeeFormDesignationSelectorLocator = By.xpath("//select[@name='designation_id']");
    private By employeesSectionAddNewEmployeeFormBasicSalaryInputLocator = By.xpath("//input[@placeholder='Gross Salary']");
    private By employeesSectionAddNewEmployeeFormHourlyRateInputLocator = By.xpath("//input[@placeholder='Hourly Rate']");
    private By employeesSectionAddNewEmployeeFormProfilePictureInputLocator = By.xpath("//input[@name='file']");
    private By employeesSectionAddNewEmployeeFormSaveButtonLocator = By.xpath("//div[@class='card-footer text-right']//button[@type='submit']");

    public EmployeesPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.largeWait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public void viewEmployeesSection() throws Exception {
        WebElement employeesSection = driver.findElement(employeesSectionLocator);
        assertTrue(employeesSection.isDisplayed(), "Employees section ko duoc hien thi.");
        employeesSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertTrue(driver.getTitle().contains("Employees | HRM | Anh Tester Demo"), "Title hien thi sai.");
        WebElement employeesSectionTable = driver.findElement(employeesSectionTableLocator);
        assertTrue(employeesSectionTable.isDisplayed(), "Employees section table ko duoc hien thi.");
    }

    public void verifyDataInTableByQuery(int itemsPerPage, String query) throws Exception {
        int numberOfColumn;
        List<WebElement> listColumn = driver.findElements(By.xpath("//tbody//tr[1]//td"));
        numberOfColumn = listColumn.size();
        boolean verifyData = false;

        if (numberOfColumn == 1){
            assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td")).getText(), "No records available", "Search result hien thi sai.");
        }
        else {
            Select itemsPerPageSelect = new Select(driver.findElement(itemsPerPageSelectLocator));
            itemsPerPageSelect.selectByVisibleText(String.valueOf(itemsPerPage));
            WebElement dataTableInfo = driver.findElement(dataTableInfoLocator);
            String[] dataTableInfoArray = dataTableInfo.getText().split(" ");
            int totalRecords = Integer.parseInt(dataTableInfoArray[5]);
            System.out.println("totalRecords: " + totalRecords);
            int recentRecord = 0;
            double resultOfDevide = Math.ceil((double) totalRecords / itemsPerPage);
            int totalPages = Double.valueOf(resultOfDevide).intValue();
            System.out.println("totalPages: " + totalPages);
            WebElement dataTableNextPageButton = driver.findElement(dataTableNextPageButtonLocator);
            String[] querySplitBySpace = query.split(" ");
            for(int i = 1; i <= totalPages; i++) {
                for(int j = 1; j <= itemsPerPage; j++) {
                    recentRecord += 1;
                    System.out.println("recentRecord: " + recentRecord);
                    if(recentRecord <= totalRecords) {
                        for(int k = 1; k <= numberOfColumn; k++) {
                            for(int l = 0; l < querySplitBySpace.length; l++) {
                                if (driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[" + k + "]")).getText().toLowerCase().contains(querySplitBySpace[l].toLowerCase())) {
                                    verifyData = true;
                                    System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " co chua query " + querySplitBySpace[l]);
                                }
                                else {
                                    System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " khong chua query " + querySplitBySpace[l]);
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Khong ton tai record thu " + recentRecord + ", tong so record trong bang la " + totalRecords);
                        break;
                    }
                }
                if(i < totalPages) {
                    action.moveToElement(dataTableNextPageButton);
                    dataTableNextPageButton.click();
                    System.out.println("Sang trang " + (i+1));
                    dataTableNextPageButton = driver.findElement(dataTableNextPageButtonLocator);
                }
            }
            assertTrue(verifyData, "Search result hien thi sai.");
        }
    }

    public void searchInEmployeesSection (int itemsPerPage, String query) throws Exception {
        viewEmployeesSection();

        WebElement employeesSectionSearchInput = driver.findElement(employeesSectionSearchInputLocator);
        employeesSectionSearchInput.sendKeys(query);

        Thread.sleep(Duration.ofSeconds(1));

        verifyDataInTableByQuery(itemsPerPage, query);
    }

    public void clickAddNewButton() {
        WebElement employeesSectionAddNewButton = driver.findElement(employeesSectionAddNewButtonLocator);
        employeesSectionAddNewButton.click();

        WebElement employeesSectionAddNewEmployeeForm = driver.findElement(employeesSectionAddNewEmployeeFormLocator);
        assertTrue(employeesSectionAddNewEmployeeForm.isDisplayed(), "Add new employee form ko duoc hien thi.");
    }

    public void enterFirstName(String firstName) {
        WebElement employeesSectionAddNewEmployeeFormFirstNameInput = driver.findElement(employeesSectionAddNewEmployeeFormFirstNameInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormFirstNameInput.isDisplayed(), "First name input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormFirstNameInput.isEnabled(), "First name input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormFirstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement employeesSectionAddNewEmployeeFormLastNameInput = driver.findElement(employeesSectionAddNewEmployeeFormLastNameInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormLastNameInput.isDisplayed(), "Last name input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormLastNameInput.isEnabled(), "Last name input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormLastNameInput.sendKeys(lastName);
    }

    public void clearAndEnterEmployeeID(String employeeID) {
        WebElement employeesSectionAddNewEmployeeFormEmployeeIDInput = driver.findElement(employeesSectionAddNewEmployeeFormEmployeeIDInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormEmployeeIDInput.isDisplayed(), "Employee ID input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormEmployeeIDInput.isEnabled(), "Employee ID input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormEmployeeIDInput.clear();
        employeesSectionAddNewEmployeeFormEmployeeIDInput.sendKeys(employeeID);
    }

    public void enterContactNumber(String contactNumber) {
        WebElement employeesSectionAddNewEmployeeFormContactNumber = driver.findElement(employeesSectionAddNewEmployeeFormContactNumberLocator);
        assertTrue(employeesSectionAddNewEmployeeFormContactNumber.isDisplayed(), "Contact number input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormContactNumber.isEnabled(), "Contact number input ko the tuong tac.");
        employeesSectionAddNewEmployeeFormContactNumber.sendKeys(contactNumber);
    }

    public void selectGender(String gender) {
        Select employeesSectionAddNewEmployeeFormGenderSelector = new Select(driver.findElement(employeesSectionAddNewEmployeeFormGenderSelectorLocator));
        try{
            employeesSectionAddNewEmployeeFormGenderSelector.selectByVisibleText(gender);
        }
        catch(Exception e){
            System.out.println("Gioi tinh khong ton tai.");
        }
    }

    public void enterEmailInput(String email) {
        WebElement employeesSectionAddNewEmployeeFormEmailInput = driver.findElement(employeesSectionAddNewEmployeeFormEmailInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormEmailInput.isDisplayed(), "Email input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormEmailInput.isEnabled(), "Email input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormEmailInput.sendKeys(email);
    }

    public void enterUserNameInput(String username) {
        WebElement employeesSectionAddNewEmployeeFormUserNameInput = driver.findElement(employeesSectionAddNewEmployeeFormUserNameInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormUserNameInput.isDisplayed(), "Username input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormUserNameInput.isEnabled(), "Username input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormUserNameInput.sendKeys(username);
    }

    public void enterPasswordInput(String password) {
        WebElement employeesSectionAddNewEmployeeFormPasswordInput = driver.findElement(employeesSectionAddNewEmployeeFormPasswordInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormPasswordInput.isDisplayed(), "Password input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormPasswordInput.isEnabled(), "Password input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormPasswordInput.sendKeys(password);
    }

    public void selectOfficeShift(String officeShift) {
        Select employeesSectionAddNewEmployeeFormOfficeShiftSelector = new Select(driver.findElement(employeesSectionAddNewEmployeeFormOfficeShiftSelectorLocator));
        try{
            employeesSectionAddNewEmployeeFormOfficeShiftSelector.selectByVisibleText(officeShift);
        }
        catch(Exception e){
            System.out.println("Office Shift ko ton tai.");
        }
    }

    public void selectRole(String role) {
        Select employeesSectionAddNewEmployeeFormRoleSelector = new Select(driver.findElement(employeesSectionAddNewEmployeeFormRoleSelectorLocator));
        try{
            employeesSectionAddNewEmployeeFormRoleSelector.selectByVisibleText(role);
        }
        catch(Exception e){
            System.out.println("Role ko ton tai.");
        }
    }

    public void selectDepartment(String department) {
        Select employeesSectionAddNewEmployeeFormDepartmentSelector = new Select(driver.findElement(employeesSectionAddNewEmployeeFormDepartmentSelectorLocator));
        try{
            employeesSectionAddNewEmployeeFormDepartmentSelector.selectByVisibleText(department);
        }
        catch(Exception e){
            System.out.println("Department ko ton tai.");
        }
    }

    public void selectDesignation(String designation) {
        Select employeesSectionAddNewEmployeeFormDesignationSelector = new Select(driver.findElement(employeesSectionAddNewEmployeeFormDesignationSelectorLocator));
        try{
            employeesSectionAddNewEmployeeFormDesignationSelector.selectByVisibleText(designation);
        }
        catch(Exception e){
            System.out.println("Designation ko ton tai.");
        }
    }

    public void clearAndEnterBasicSalary(String basicSalary) {
        WebElement employeesSectionAddNewEmployeeFormBasicSalaryInput = driver.findElement(employeesSectionAddNewEmployeeFormBasicSalaryInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormBasicSalaryInput.isDisplayed(), "Basic salary input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormBasicSalaryInput.isEnabled(), "Basic salary input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormBasicSalaryInput.clear();
        employeesSectionAddNewEmployeeFormBasicSalaryInput.sendKeys(basicSalary);
    }

    public void clearAndEnterHourlyRate(String hourlyRate) {
        WebElement employeesSectionAddNewEmployeeFormHourlyRateInput = driver.findElement(employeesSectionAddNewEmployeeFormHourlyRateInputLocator);
        assertTrue(employeesSectionAddNewEmployeeFormHourlyRateInput.isDisplayed(), "Hourly rate input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormHourlyRateInput.isEnabled(), "Hourly rate input khong the tuong tac.");
        employeesSectionAddNewEmployeeFormHourlyRateInput.clear();
        employeesSectionAddNewEmployeeFormHourlyRateInput.sendKeys(hourlyRate);
    }

    public void enterProfilePicture(String profilePicture) {
        WebElement employeesSectionAddNewEmployeeFormProfilePictureInput = driver.findElement(employeesSectionAddNewEmployeeFormProfilePictureInputLocator);
        action.moveToElement(employeesSectionAddNewEmployeeFormProfilePictureInput).perform();
        //assertTrue(employeesSectionAddNewEmployeeFormProfilePictureInput.isDisplayed(), "Profile picture input ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormProfilePictureInput.isEnabled(), "Profile picture input khong the tuong tac.");
        try {
            employeesSectionAddNewEmployeeFormProfilePictureInput.sendKeys(System.getProperty("user.dir") + "/src/test/java/resource/" + profilePicture);
        }
        catch (Exception e) {
            System.out.println("File ko ton tai.");
        }
    }

    public void clickSaveButton() {
        WebElement employeesSectionAddNewEmployeeFormSaveButton = driver.findElement(employeesSectionAddNewEmployeeFormSaveButtonLocator);
        action.moveToElement(employeesSectionAddNewEmployeeFormSaveButton).perform();
        assertTrue(employeesSectionAddNewEmployeeFormSaveButton.isDisplayed(), "Save button ko duoc hien thi.");
        assertTrue(employeesSectionAddNewEmployeeFormSaveButton.isEnabled(), "Save button ko the tuong tac.");
        employeesSectionAddNewEmployeeFormSaveButton.click();
    }

    public void verifyConfirmMessage(String confirmMessage) {
        largeWait.until(ExpectedConditions.visibilityOfElementLocated(employeesPageConfirmMessageLocator));
        WebElement employeesPageConfirmMessage = driver.findElement(employeesPageConfirmMessageLocator);
        assertEquals(employeesPageConfirmMessage.getText(), confirmMessage, "Add new employee confirm hien thi sai.");
    }

    public void addNewEmployee(String firstName, String lastName, String employeeID, String contactNumber, String gender, String email, String username, String password, String officeShift, String role, String department, String designation, String basicSalary, String hourlyRate, String profilePicture, String confirmMessage) throws Exception {
        viewEmployeesSection();
        clickAddNewButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        clearAndEnterEmployeeID(employeeID);
        enterContactNumber(contactNumber);
        selectGender(gender);
        enterEmailInput(email);
        enterUserNameInput(username);
        enterPasswordInput(password);
        selectOfficeShift(officeShift);
        selectRole(role);
        selectDepartment(department);
        Thread.sleep(200);
        selectDesignation(designation);
        clearAndEnterBasicSalary(basicSalary);
        clearAndEnterHourlyRate(hourlyRate);
        enterProfilePicture(profilePicture);
        clickSaveButton();
        verifyConfirmMessage(confirmMessage);

    }
}
