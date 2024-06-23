package pages;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}
