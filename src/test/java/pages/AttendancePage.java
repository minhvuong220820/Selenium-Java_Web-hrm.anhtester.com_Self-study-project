package pages;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AttendancePage {
    private WebDriver driver;
    WebDriverWait wait;
    Actions action;

    private By attendanceSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[1]");
    private By attendanceSectionTitleLocator = By.xpath("//h5[normalize-space()='Daily Attendace Report']");
    private By attendanceSectionSearchInputLocator = By.xpath("//input[@type='search']");

    private By manualAttendanceSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[2]");
    private By manualAttendanceSectionFilterAttendanceInputLocator = By.xpath("//input[@id='attendance_date']");
    private By manualAttendanceSectionFilterAttendanceFilterButtonLocator = By.xpath("//div[@class='card-footer text-right']//button[@type='submit']");
    private By CalendarLocator = By.xpath("//div[@class='dtp-content']");
    private By CalendarPresentMonthLocator = By.xpath("//div[@class='dtp-actual-month p80']");
    private By CalendarPreviousMonthButtonLocator = By.xpath("//a[@class='dtp-select-month-before']");
    private By CalendarNextMonthButtonLocator = By.xpath("//a[@class='dtp-select-month-after']");
    private By CalendarPresentYearLocator = By.xpath("//div[@class='dtp-actual-year p80']");
    private By CalendarPreviousYearButtonLocator = By.xpath("//a[@class='dtp-select-year-before']");
    private By CalendarNextYearButtonLocator = By.xpath("//a[@class='dtp-select-year-after']");
    private By CalendarPresentDayLocator = By.xpath("//div[@class='dtp-actual-num']");
    private By CalendarOkButtonLocator = By.xpath("//button[normalize-space()='OK']");
    private By itemsPerPageSelectLocator = By.xpath("//select[@name='xin_table_length']");
    private By dataTableInfoLocator = By.xpath("//div[@id='xin_table_info']");
    private By dataTableNextPageButtonLocator = By.xpath("//a[normalize-space()='Next']");
    private By manualAttendanceSectionSearchInputLocator = By.xpath("//input[@type='search']");
    private By manualAttendanceSectionDeleteAttendanceButtonLocator = By.xpath("//i[@class='feather icon-trash-2']");
    private By manualAttendanceSectionDeleteAttendanceDialogLocator = By.xpath("//div[@class='modal fade show delete-modal']//div[@class='modal-content']");
    private By manualAttendanceSectionDeleteAttendanceDialogConfirmButtonLocator = By.xpath("//div[@class='modal-footer']//button[@type='submit']");

    private By attendancePageConfirmMessageLocator = By.xpath("//div[@class='toast-message']");

    private By MonthlyReportSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[3]");
    private By MonthlyReportSectionSelectMonthInputLocator = By.xpath("//input[@placeholder='Select Month']");
    private By MonthlyReportSectionCalendarLocator = By.xpath("//div[@id='ui-datepicker-div']");
    private By MonthlyReportSectionCalendarMonthSelectorLocator = By.xpath("//select[@class='ui-datepicker-month']");
    private By MonthlyReportSectionCalendarYearSelectorLocator = By.xpath("//select[@class='ui-datepicker-year']");
    private By MonthlyReportSectionCalendarDoneButtonLocator = By.xpath("//button[normalize-space()='Done']");
    private By MonthlyReportSectionSearchButtonLocator = By.xpath("//div[@class='col']//button[@type='submit']");
    private By dateOfReportLocator = By.xpath("//h4//strong");

    private By OverTimeRequestSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[4]");
    private By OverTimeRequestSectionSearchInputLocator = By.xpath("//input[@type='search']");
    private By OverTimeRequestSectionDeleteAttendanceButtonLocator = By.xpath("//i[@class='feather icon-trash-2']");
    private By OverTimeRequestSectionDeleteAttendanceDialogLocator = By.xpath("//div[@class='modal fade show delete-modal']//div[@class='modal-content']");
    private By OverTimeRequestSectionDeleteAttendanceDialogConfirmButtonLocator = By.xpath("//div[@class='modal-footer']//button[@type='submit']");


    public AttendancePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void viewAttendanceSection () throws Exception {
        WebElement attendanceSection = driver.findElement(attendanceSectionLocator);
        attendanceSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertEquals(driver.getTitle(), "Attendance | HRM | Anh Tester Demo");
        WebElement attendanceSectionTitle = driver.findElement(attendanceSectionTitleLocator);
        assertEquals(attendanceSectionTitle.getText(), "Daily Attendace Report");
    }

    public void searchAttendanceInAttendanceSection (String query) {
        WebElement attendanceSectionSearchInput = driver.findElement(attendanceSectionSearchInputLocator);
        attendanceSectionSearchInput.sendKeys(query);

        int numberOfColumn;
        List<WebElement> listColumn = driver.findElements(By.xpath("//tr[@class='odd']//td"));
        numberOfColumn = listColumn.size();
        boolean verifyData = false;

        if (numberOfColumn == 1){
            assertEquals(driver.findElement(By.xpath("//tr[@class='odd']//td")).getText(), "No records available", "Search result hien thi sai.");
            System.out.println("Khong co ket qua tim kiem voi tu khoa " + query);
        }
        else {
            for (int i = 1; i <= numberOfColumn; i++) {
                if (driver.findElement(By.xpath("//tr[@class='odd']//td[" + i + "]")).getText().toLowerCase().contains(query.toLowerCase())) {
                    verifyData = true;
                    System.out.println("Trong ket qua tim kiem, cot thu " + i + " co chua query " + query);
                }
                else {
                    System.out.println("Trong ket qua tim kiem, cot thu " + i + " khong chua query " + query);
                }
            }
            assertTrue(verifyData, "Search result hien thi sai.");
        }
    }

    public void viewManualAttendanceSection () throws Exception {
        WebElement manualAttendanceSection = driver.findElement(manualAttendanceSectionLocator);
        manualAttendanceSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertEquals(driver.getTitle(), "Manual Attendance | HRM | Anh Tester Demo");
    }

    public void setDateInCalendar(String date) throws Exception {
        String[] arrayOfDate = date.split("-");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarLocator));

        WebElement CalendarPresentYear = driver.findElement(CalendarPresentYearLocator);
        WebElement CalendarPreviousYearButton = driver.findElement(CalendarPreviousYearButtonLocator);
        WebElement CalendarNextYearButton = driver.findElement(CalendarNextYearButtonLocator);
        int yearOfDate = Integer.parseInt(arrayOfDate[2]);
        int yearOfPresentYear = Integer.parseInt(CalendarPresentYear.getText());
        if(yearOfPresentYear > yearOfDate) {
            while (yearOfPresentYear > yearOfDate) {
                CalendarPreviousYearButton.click();
                yearOfPresentYear = Integer.parseInt(CalendarPresentYear.getText());
                Thread.sleep(500);
            }
        } else if (yearOfPresentYear < yearOfDate) {
            while (yearOfPresentYear < yearOfDate) {
                CalendarNextYearButton.click();
                yearOfPresentYear = Integer.parseInt(CalendarPresentYear.getText());
                Thread.sleep(500);
            }
        }
        else {
            System.out.println("Nam hien tai tren calender " + yearOfPresentYear + " = nam nhap vao " + yearOfDate);
            Thread.sleep(500);
        }

        WebElement CalendarPresentMonth = driver.findElement(CalendarPresentMonthLocator);
        WebElement CalendarPreviousMonthButton = driver.findElement(CalendarPreviousMonthButtonLocator);
        WebElement CalendarNextMonthButton = driver.findElement(CalendarNextMonthButtonLocator);

        int monthOfDate = Integer.parseInt(arrayOfDate[1]);
        String presentMonth = CalendarPresentMonth.getText();
        int monthOfPresentMonth = 0;
        switch (presentMonth) {
            case "JAN":
                monthOfPresentMonth = 1;
                break;
            case "FEB":
                monthOfPresentMonth = 2;
                break;
            case "MAR":
                monthOfPresentMonth = 3;
                break;
            case "APR":
                monthOfPresentMonth = 4;
                break;
            case "MAY":
                monthOfPresentMonth = 5;
                break;
            case "JUN":
                monthOfPresentMonth = 6;
                break;
            case "JUL":
                monthOfPresentMonth = 7;
                break;
            case "AUG":
                monthOfPresentMonth = 8;
                break;
            case "SEP":
                monthOfPresentMonth = 9;
                break;
            case "OCT":
                monthOfPresentMonth = 10;
                break;
            case "NOV":
                monthOfPresentMonth = 11;
                break;
            case "DEC":
                monthOfPresentMonth = 12;
                break;
            default:
                System.out.println("Thang ko ton tai.");
                break;
        }
        if (monthOfPresentMonth > monthOfDate) {
            while (monthOfPresentMonth > monthOfDate) {
                CalendarPreviousMonthButton.click();
                monthOfPresentMonth -= 1;
                Thread.sleep(500);
            }
        } else if (monthOfPresentMonth < monthOfDate) {
            while (monthOfPresentMonth < monthOfDate) {
                CalendarNextMonthButton.click();
                monthOfPresentMonth += 1;
                Thread.sleep(500);
            }
        }
        else {
            System.out.println("Thang hien tai tren calender " + monthOfPresentMonth + " = thang nhap vao " + monthOfDate);
            Thread.sleep(500);
        }

        int dayOfDate = Integer.parseInt(arrayOfDate[0]);
        WebElement CalendarPresentDay = driver.findElement(CalendarPresentDayLocator);
        if(dayOfDate == Integer.parseInt(CalendarPresentDay.getText())) {
            System.out.println("Ngay hien tai tren calender " + CalendarPresentDay.getText() + " = ngay nhap vao " + dayOfDate);
        }
        else {
            driver.findElement(By.xpath("//a[@class='dtp-select-day'][normalize-space()='" + arrayOfDate[0] + "']")).click();
            assertEquals(arrayOfDate[0], CalendarPresentDay.getText(), "Ngay hien tai tren calender khong dung.");
        }

        Thread.sleep(Duration.ofSeconds(1));

        WebElement CalendarOkButton = driver.findElement(CalendarOkButtonLocator);
        CalendarOkButton.click();
    }

    public void verifyDataInTableByDate(int itemsPerPage, String date) throws Exception {
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
            for(int i = 1; i <= totalPages; i++) {
                for(int j = 1; j <= itemsPerPage; j++) {
                    recentRecord += 1;
                    System.out.println("recentRecord: " + recentRecord);
                    if(recentRecord <= totalRecords) {
                        for(int k = 1; k <= numberOfColumn; k++) {
                            if (driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[" + k + "]")).getText().toLowerCase().contains(date.toLowerCase())) {
                                verifyData = true;
                                System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " co chua date " + date);
                            }
                            else {
                                System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " khong chua date " + date);
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

    public void filterAttendanceInManualAttendanceSection (int itemsPerPage, String date) throws Exception {
        viewManualAttendanceSection();

        WebElement manualAttendanceSectionFilterAttendanceInput = driver.findElement(manualAttendanceSectionFilterAttendanceInputLocator);
        manualAttendanceSectionFilterAttendanceInput.click();

        Thread.sleep(Duration.ofSeconds(1));

        setDateInCalendar(date);

        WebElement manualAttendanceSectionFilterAttendanceFilterButton = driver.findElement(manualAttendanceSectionFilterAttendanceFilterButtonLocator);
        manualAttendanceSectionFilterAttendanceFilterButton.click();

        Thread.sleep(Duration.ofSeconds(1));

        verifyDataInTableByDate(itemsPerPage, date);
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
            String[] querySplitByLine = null;

            for(int i = 0; i < querySplitBySpace.length; i++) {
                querySplitByLine = ArrayUtils.addAll(querySplitByLine, querySplitBySpace[i].split("-"));
            }
            for(int i = 1; i <= totalPages; i++) {
                for(int j = 1; j <= itemsPerPage; j++) {
                    recentRecord += 1;
                    System.out.println("recentRecord: " + recentRecord);
                    if(recentRecord <= totalRecords) {
                        for(int k = 1; k <= numberOfColumn; k++) {
                            for(int l = 0; l < querySplitByLine.length; l++) {
                                if (driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[" + k + "]")).getText().toLowerCase().contains(querySplitByLine[l].toLowerCase())) {
                                    verifyData = true;
                                    System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " co chua query " + querySplitByLine[l]);
                                }
                                else {
                                    System.out.println("Trong ket qua tim kiem, hang thu " + j + " cot thu " + k + " khong chua query " + querySplitByLine[l]);
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

    public void searchInManualAttendanceSection (int itemsPerPage, String query) throws Exception {
        viewManualAttendanceSection();

        WebElement manualAttendanceSectionSearchInput = driver.findElement(manualAttendanceSectionSearchInputLocator);
        manualAttendanceSectionSearchInput.sendKeys(query);

        Thread.sleep(Duration.ofSeconds(1));

        verifyDataInTableByQuery(itemsPerPage, query);
    }

    public void deleteAttendanceInManualAttendanceSection (int itemsPerPage, String query) throws Exception {
        searchInManualAttendanceSection(itemsPerPage, query);

        action.moveToElement(driver.findElement(By.xpath("//tr[@class='odd']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(manualAttendanceSectionDeleteAttendanceButtonLocator));
        WebElement manualAttendanceSectionDeleteAttendanceButton = driver.findElement(manualAttendanceSectionDeleteAttendanceButtonLocator);
        manualAttendanceSectionDeleteAttendanceButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(manualAttendanceSectionDeleteAttendanceDialogLocator));
        WebElement manualAttendanceSectionDeleteAttendanceDialogConfirmButton = driver.findElement(manualAttendanceSectionDeleteAttendanceDialogConfirmButtonLocator);
        manualAttendanceSectionDeleteAttendanceDialogConfirmButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(attendancePageConfirmMessageLocator));
        WebElement attendancePageConfirmMessage = driver.findElement(attendancePageConfirmMessageLocator);
        assertEquals(attendancePageConfirmMessage.getText(), "Attendance deleted.", "Confirm message hien thi sai.");
    }

    public void viewMonthlyReportSection () throws Exception {
        WebElement MonthlyReportSection = driver.findElement(MonthlyReportSectionLocator);
        MonthlyReportSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertEquals(driver.getTitle(), "Monthly Report | HRM | Anh Tester Demo");
    }

    public void viewAttendanceReportByMonth(String date) throws Exception {
        viewMonthlyReportSection();

        WebElement MonthlyReportSectionSelectMonthInput = driver.findElement(MonthlyReportSectionSelectMonthInputLocator);
        MonthlyReportSectionSelectMonthInput.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MonthlyReportSectionCalendarLocator));

        String[] arrayOfDate = date.split("-");
        String monthOfReport = "";
        Select monthSelect = new Select(driver.findElement(MonthlyReportSectionCalendarMonthSelectorLocator));
        switch (Integer.parseInt(arrayOfDate[0])) {
            case 1:
                monthSelect.selectByVisibleText("Jan");
                monthOfReport = "JANUARY";
                break;
            case 2:
                monthSelect.selectByVisibleText("Feb");
                monthOfReport = "FEBRUARY";
                break;
            case 3:
                monthSelect.selectByVisibleText("Mar");
                monthOfReport = "MARCH";
                break;
            case 4:
                monthSelect.selectByVisibleText("Apr");
                monthOfReport = "APRIL";
                break;
            case 5:
                monthSelect.selectByVisibleText("May");
                monthOfReport = "MAY";
                break;
            case 6:
                monthSelect.selectByVisibleText("Jun");
                monthOfReport = "JUNE";
                break;
            case 7:
                monthSelect.selectByVisibleText("Jul");
                monthOfReport = "JULY";
                break;
            case 8:
                monthSelect.selectByVisibleText("Aug");
                monthOfReport = "AUGUST";
                break;
            case 9:
                monthSelect.selectByVisibleText("Sep");
                monthOfReport = "SEPTEMBER";
                break;
            case 10:
                monthSelect.selectByVisibleText("Oct");
                monthOfReport = "OCTOBER";
                break;
            case 11:
                monthSelect.selectByVisibleText("Nov");
                monthOfReport = "NOVEMBER";
                break;
            case 12:
                monthSelect.selectByVisibleText("Dec");
                monthOfReport = "DECEMBER";
                break;
            default:
                System.out.println("Khong ton tai thang " + arrayOfDate[0]);
                break;
        }

        Select yearSelect = new Select(driver.findElement(MonthlyReportSectionCalendarYearSelectorLocator));
        yearSelect.selectByVisibleText(arrayOfDate[1]);

        WebElement MonthlyReportSectionCalendarDoneButton = driver.findElement(MonthlyReportSectionCalendarDoneButtonLocator);
        MonthlyReportSectionCalendarDoneButton.click();

        String dashboardWindow = driver.getWindowHandle();

        WebElement MonthlyReportSectionSearchButton = driver.findElement(MonthlyReportSectionSearchButtonLocator);
        MonthlyReportSectionSearchButton.click();

        Set <String> setWindows = driver.getWindowHandles();

        for(String window : setWindows) {
            if(!window.equals(dashboardWindow)) {
                driver.switchTo().window(window);
                System.out.println("Da chuyen huong toi window: " + window);
            }
        }

        Thread.sleep(Duration.ofSeconds(2));

        WebElement dateOfReport = driver.findElement(dateOfReportLocator);
        assertEquals(dateOfReport.getText(), monthOfReport + ", " + arrayOfDate[1], "Date of report hien thi sai.");

        String formattedDateInReport = arrayOfDate[1] + "-" + arrayOfDate[0];
        List<WebElement> numberOfColumns = driver.findElements(By.xpath("//thead//tr//th"));
        List<WebElement> numberOfRows = driver.findElements(By.xpath("//tbody//tr"));

        for (int i = 1; i <= numberOfRows.size(); i++) {
            System.out.println("Hang thu " + i + ":");
            for (int j = 1; j <= numberOfColumns.size(); j++) {
                if(driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[" + j + "]")).getText().toLowerCase().contains(formattedDateInReport)) {
                    System.out.println("Trong bang report, hang thu " + i + " cot thu " + j + " co chua thang va nam da chon " + formattedDateInReport);
                }
                else {
                    System.out.println("Trong bang report, hang thu " + i + " cot thu " + j + " ko chua thang va nam da chon " + formattedDateInReport);
                }
            }
        }
    }

    public void viewOvertimeRequestSection () throws Exception {
        WebElement OverTimeRequestSection = driver.findElement(OverTimeRequestSectionLocator);
        OverTimeRequestSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertEquals(driver.getTitle(), "Overtime Request | HRM | Anh Tester Demo");
    }

    public void searchInOvertimeRequestSection (int itemsPerPage, String query) throws Exception {
        viewOvertimeRequestSection();

        WebElement OverTimeRequestSectionSearchInput = driver.findElement(OverTimeRequestSectionSearchInputLocator);
        OverTimeRequestSectionSearchInput.sendKeys(query);

        Thread.sleep(Duration.ofSeconds(1));

        verifyDataInTableByQuery(itemsPerPage, query);
    }

    public void deleteRequestInOvertimeRequestSection (int itemsPerPage, String query) throws Exception {
        searchInOvertimeRequestSection(itemsPerPage, query);

        action.moveToElement(driver.findElement(By.xpath("//tr[@class='odd']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(OverTimeRequestSectionDeleteAttendanceButtonLocator));
        WebElement OverTimeRequestSectionDeleteAttendanceButton = driver.findElement(OverTimeRequestSectionDeleteAttendanceButtonLocator);
        OverTimeRequestSectionDeleteAttendanceButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OverTimeRequestSectionDeleteAttendanceDialogLocator));
        WebElement OverTimeRequestSectionDeleteAttendanceDialogConfirmButton = driver.findElement(OverTimeRequestSectionDeleteAttendanceDialogConfirmButtonLocator);
        OverTimeRequestSectionDeleteAttendanceDialogConfirmButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(attendancePageConfirmMessageLocator));
        WebElement attendancePageConfirmMessage = driver.findElement(attendancePageConfirmMessageLocator);
        assertEquals(attendancePageConfirmMessage.getText(), "Overtime deleted.", "Confirm message hien thi sai.");
    }
}