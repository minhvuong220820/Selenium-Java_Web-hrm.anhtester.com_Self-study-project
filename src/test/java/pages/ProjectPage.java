package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ProjectPage {
    private WebDriver driver;
    Actions action;
    WebDriverWait wait;
    WebDriverWait longWait;

    private By projectsPageConfirmMessageLocator = By.xpath("//div[@class='toast-message']");

    private By projectsSectionLocator = By.xpath("//div[@id='smartwizard-2']//ul//li[1]");
    private By projectsSectionTitleLocator = By.xpath("//h5[contains(text(),'List All')]");
    private By projectsSectionAddNewProjectButtonLocator = By.xpath("//a[normalize-space()='Add New']");
    private By projectsSectionAddNewProjectFormLocator = By.xpath("//div[@id='accordion']");
    private By projectsSectionAddNewProjectFormTitleInputLocator = By.xpath("//input[@placeholder='Title']");
    private By projectsSectionAddNewProjectFormClientSelectorLocator = By.xpath("//select[@id='client_id']");
    private By projectsSectionAddNewProjectFormEstimatedHourInputLocator = By.xpath("//input[@placeholder='Estimated Hour']");
    private By projectsSectionAddNewProjectFormPrioritySelectorLocator = By.xpath("//select[@name='priority']");
    private By projectsSectionAddNewProjectFormStartDateInputLocator = By.xpath("//input[@placeholder='Start Date']");
    private By projectsSectionAddNewProjectFormEndDateInputLocator = By.xpath("//input[@placeholder='End Date']");
    private By projectsSectionAddNewProjectFormSummaryTextareaLocator = By.xpath("//textarea[@placeholder='Summary']");
    private By projectsSectionAddNewProjectFormTeamSelectorLocator = By.xpath("//select[@name='assigned_to[]']");
    private By projectsSectionAddNewProjectFormDescriptionTextareaLocator = By.xpath("//body");
    private By projectsSectionAddNewProjectFormSaveButtonLocator = By.xpath("//button[@type='submit'][normalize-space()='Save']");
    private By projectsSectionSearchInputLocator = By.xpath("//input[@class='form-control form-control-sm']");

    private By itemsPerPageSelectLocator = By.xpath("//select[@name='xin_table_length']");
    private By dataTableInfoLocator = By.xpath("//div[@id='xin_table_info']");
    private By dataTableNextPageButtonLocator = By.xpath("//a[normalize-space()='Next']");

    private By projectsSectionViewProjectDetailsButtonLocator = By.xpath("//i[@class='feather icon-arrow-right']");

    private By projectDetailsProgressLocator = By.xpath("//span[@class='irs-single']");
    private By projectDetailsPrioritySelectorLocator = By.xpath("//select[@name='priority']");
    private By projectDetailsUpdateStatusButtonLocator = By.xpath("//form[@id='update_project_progress']//button[@type='submit']");

    private By projectDetailsEditSectionLocator = By.xpath("//a[@id='pills-edit-tab']");
    private By projectDetailsEditSectionUpdateProjectButtonLocator = By.xpath("//form[@id='update_project']//button[@type='submit']");

    private By projectDetailsDiscussionSectionLocator = By.xpath("//a[@id='pills-discussion-tab']");
    private By projectDetailsDiscussionSectionNewDiscussTextareaLocator = By.xpath("//body");
    private By projectDetailsDiscussionSectionAddButtonLocator = By.xpath("//form[@id='add_discussion']//button[@type='submit']");

    private By projectDetailsBugSectionLocator = By.xpath("//a[@id='pills-bugs-tab']");
    private By projectDetailsBugSectionNewBugTextareaLocator = By.xpath("//body");
    private By projectDetailsBugSectionAddButtonLocator = By.xpath("//form[@id='add_bug']//button[@type='submit']");

    private By projectDetailsTaskSectionLocator = By.xpath("//a[@id='pills-tasks-tab']");
    private By projectDetailsTaskSectionAddNewTaskButtonLocator = By.xpath("//a[normalize-space()='Add New']");
    private By projectDetailsTaskSectionAddNewTaskFormLocator = By.xpath("//form[@id='add_task']");
    private By projectDetailsTaskSectionAddNewTaskFormTitleInputLocator = By.xpath("//input[@name='task_name']");
    private By projectDetailsTaskSectionAddNewTaskFormStartDateInputLocator = By.xpath("(//input[@placeholder='Start Date'])[3]");
    private By projectDetailsTaskSectionAddNewTaskFormEndDateInputLocator = By.xpath("(//input[@placeholder='End Date'])[3]");
    private By projectDetailsTaskSectionAddNewTaskFormEstimatedHourInputLocator = By.xpath("//input[@name='task_hour']");
    private By projectDetailsTaskSectionAddNewTaskFormSummaryTextAreaLocator = By.xpath("//textarea[@id='summary']");
    private By projectDetailsTaskSectionAddNewTaskFormDescriptionTextareaLocator = By.xpath("//body");
    private By projectDetailsTaskSectionAddNewTaskFormSaveButtonLocator = By.xpath("//form[@id='add_task']//button[@type='submit']");

    private By projectDetailsAttachFilesSectionLocator = By.xpath("//a[@id='pills-files-tab']");
    private By projectDetailsAttachFilesSectionTitleInputLocator = By.xpath("//input[@name='file_name']");
    private By projectDetailsAttachFilesSectionAttachmentInputLocator = By.xpath("//input[@id='attachment_file']");
    private By projectDetailsAttachFilesSectionAddFileButtonLocator = By.xpath("//div[@id='pills-files']//button[@type='submit']");

    private By projectDetailsNoteSectionLocator = By.xpath("//a[@id='pills-notes-tab']");
    private By projectDetailsNoteSectionNoteInputLocator = By.xpath("//input[@placeholder='Post a Note...']");
    private By projectDetailsNoteSectionAddNoteButtonLocator = By.xpath("//button[@class='btn waves-effect waves-light btn-primary btn-icon ladda-button']");

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public void viewProjectsSection() throws Exception {
        WebElement projectsSection = driver.findElement(projectsSectionLocator);
        projectsSection.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertEquals(driver.getTitle(), "Projects | HRM | Anh Tester Demo");
        WebElement projectsSectionTitle = driver.findElement(projectsSectionTitleLocator);
        assertTrue(projectsSectionTitle.getText().contains("List All Projects"), "Projects section title hien thi sai.");
    }

    public void enterTitle(String title) {
        WebElement projectsSectionAddNewProjectFormTitleInput = driver.findElement(projectsSectionAddNewProjectFormTitleInputLocator);
        assertTrue(projectsSectionAddNewProjectFormTitleInput.isDisplayed(), "Title input ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormTitleInput.isEnabled(), "Title input ko the tuong tac.");
        projectsSectionAddNewProjectFormTitleInput.clear();
        projectsSectionAddNewProjectFormTitleInput.sendKeys(title);
    }

    public void selectClient(String client) {
        Select projectsSectionAddNewProjectFormClientSelector = new Select(driver.findElement(projectsSectionAddNewProjectFormClientSelectorLocator));
        projectsSectionAddNewProjectFormClientSelector.selectByVisibleText(client);
    }

    public void enterEstimatedHour(int estimatedHour) {
        WebElement projectsSectionAddNewProjectFormEstimatedHourInput = driver.findElement(projectsSectionAddNewProjectFormEstimatedHourInputLocator);
        assertTrue(projectsSectionAddNewProjectFormEstimatedHourInput.isDisplayed(), "Estimated Hour input ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormEstimatedHourInput.isEnabled(), "Estimated Hour input ko the tuong tac.");
        projectsSectionAddNewProjectFormEstimatedHourInput.clear();
        projectsSectionAddNewProjectFormEstimatedHourInput.sendKeys(String.valueOf(estimatedHour));
    }

    public void selectPriority(String priority) {
        Select projectsSectionAddNewProjectFormPrioritySelector = new Select(driver.findElement(projectsSectionAddNewProjectFormPrioritySelectorLocator));
        projectsSectionAddNewProjectFormPrioritySelector.selectByVisibleText(priority);
    }

    public void setDateInCalendar(String date, String index) throws Exception{
        String[] arrayOfDate = date.split("-");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='dtp-content'])[" + index + "]")));

        WebElement CalendarPresentYear = driver.findElement(By.xpath("(//div[@class='dtp-actual-year p80'])[" + index + "]"));
        WebElement CalendarPreviousYearButton = driver.findElement(By.xpath("(//a[@class='dtp-select-year-before'])[" + index + "]"));
        WebElement CalendarNextYearButton = driver.findElement(By.xpath("(//a[@class='dtp-select-year-after'])[" + index + "]"));
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

        WebElement CalendarPresentMonth = driver.findElement(By.xpath("(//div[@class='dtp-actual-month p80'])[" + index + "]"));
        WebElement CalendarPreviousMonthButton = driver.findElement(By.xpath("(//a[@class='dtp-select-month-before'])[" + index + "]"));
        WebElement CalendarNextMonthButton = driver.findElement(By.xpath("(//a[@class='dtp-select-month-after'])[" + index + "]"));

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
        WebElement CalendarPresentDay = driver.findElement(By.xpath("(//div[@class='dtp-actual-num'])[" + index + "]"));
        String typeOfIndex = "";
        if(Integer.parseInt(index) % 2 == 0) {
            typeOfIndex = "2";
        }
        else {
            typeOfIndex = "1";
        }
        if(dayOfDate == Integer.parseInt(CalendarPresentDay.getText())) {
            System.out.println("Ngay hien tai tren calender " + CalendarPresentDay.getText() + " = ngay nhap vao " + dayOfDate);
        }
        else {
            driver.findElement(By.xpath("(//a[@class='dtp-select-day'][normalize-space()='" + arrayOfDate[0] + "'])[" + typeOfIndex + "]")).click();
            assertEquals(arrayOfDate[0], CalendarPresentDay.getText(), "Ngay hien tai tren calender khong dung.");
        }

        Thread.sleep(Duration.ofSeconds(1));

        WebElement CalendarOkButton = driver.findElement(By.xpath("(//button[normalize-space()='OK'])[" + index + "]"));
        CalendarOkButton.click();
    }

    public void setStartDate(String startDate) throws Exception{
        WebElement projectsSectionAddNewProjectFormStartDateInput = driver.findElement(projectsSectionAddNewProjectFormStartDateInputLocator);
        assertTrue(projectsSectionAddNewProjectFormStartDateInput.isDisplayed(), "Start date input ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormStartDateInput.isEnabled(), "Start date input ko the tuong tac.");
        projectsSectionAddNewProjectFormStartDateInput.click();

        setDateInCalendar(startDate, "1");
    }

    public void setEndDate(String endDate) throws Exception{
        WebElement projectsSectionAddNewProjectFormEndDateInput = driver.findElement(projectsSectionAddNewProjectFormEndDateInputLocator);
        assertTrue(projectsSectionAddNewProjectFormEndDateInput.isDisplayed(), "End date input ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormEndDateInput.isEnabled(), "End date input ko the tuong tac.");
        projectsSectionAddNewProjectFormEndDateInput.click();

        setDateInCalendar(endDate, "2");
    }

    public void enterSummary(String summary) {
        WebElement projectsSectionAddNewProjectFormSummaryTextarea = driver.findElement(projectsSectionAddNewProjectFormSummaryTextareaLocator);
        assertTrue(projectsSectionAddNewProjectFormSummaryTextarea.isDisplayed(), "Summary textarea ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormSummaryTextarea.isEnabled(), "Summary textarea ko the tuong tac.");
        projectsSectionAddNewProjectFormSummaryTextarea.clear();
        projectsSectionAddNewProjectFormSummaryTextarea.sendKeys(summary);
    }

    public void enterTeam(String teamMembers) {
        String[] arrayOfTeamMembers = teamMembers.split(",");
        Select projectsSectionAddNewProjectFormTeamSelector = new Select(driver.findElement(projectsSectionAddNewProjectFormTeamSelectorLocator));
        assertTrue(projectsSectionAddNewProjectFormTeamSelector.isMultiple(), "Team Members selector ko the chon nhieu lua chon.");
        projectsSectionAddNewProjectFormTeamSelector.deselectAll();
        for (int i = 0; i < arrayOfTeamMembers.length; i++) {
            projectsSectionAddNewProjectFormTeamSelector.selectByVisibleText(arrayOfTeamMembers[i]);
        }
    }

    public void enterDescription(String description) {
        driver.switchTo().frame(0);
        WebElement projectsSectionAddNewProjectFormDescriptionTextarea = driver.findElement(projectsSectionAddNewProjectFormDescriptionTextareaLocator);
        projectsSectionAddNewProjectFormDescriptionTextarea.clear();
        projectsSectionAddNewProjectFormDescriptionTextarea.sendKeys(description);
        driver.switchTo().defaultContent();
    }

    public void clickSaveButton() {
        WebElement projectsSectionAddNewProjectFormSaveButton = driver.findElement(projectsSectionAddNewProjectFormSaveButtonLocator);
        assertTrue(projectsSectionAddNewProjectFormSaveButton.isDisplayed(), "Save button ko duoc hien thi.");
        assertTrue(projectsSectionAddNewProjectFormSaveButton.isEnabled(), "Save button ko the tuong tac.");
        projectsSectionAddNewProjectFormSaveButton.click();
    }

    public void addNewProjectSuccess(String title, String client, int estimatedHour, String priority, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project added."), "Add new project success confirm ko duoc hien thi.");
    }

    public void addNewProjectFailEmptyTitle(String title, String client, int estimatedHour, String priority, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The title field is required."), "Add new project fail confirm ko duoc hien thi.");
    }

    public void addNewProjectFailEmptyClient(String title, String client, int estimatedHour, String priority, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The client field is required."), "Add new project fail confirm ko duoc hien thi.");
    }

    public void addNewProjectFailEmptyStartDate(String title, String client, int estimatedHour, String priority, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The start_date field is required."), "Add new project fail confirm ko duoc hien thi.");
    }

    public void addNewProjectFailEmptyEndDate(String title, String client, int estimatedHour, String priority, String startDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setStartDate(startDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The end_date field is required."), "Add new project fail confirm ko duoc hien thi.");
    }

    public void addNewProjectFailEmptySummary(String title, String client, int estimatedHour, String priority, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionAddNewProjectButton = driver.findElement(projectsSectionAddNewProjectButtonLocator);
        assertTrue(projectsSectionAddNewProjectButton.isDisplayed(), "Add new project button ko duoc hien thi.");
        projectsSectionAddNewProjectButton.click();

        WebElement projectsSectionAddNewProjectForm = driver.findElement(projectsSectionAddNewProjectFormLocator);
        assertTrue(projectsSectionAddNewProjectForm.isDisplayed(), "Add new project form ko duoc hien thi.");

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        selectPriority(priority);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickSaveButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The summary field is required."), "Add new project fail confirm ko duoc hien thi.");
    }

    public void verifyDataInTableByQuery(int itemsPerPage, String query) throws Exception {
        int numberOfColumn;
        List<WebElement> listColumn = driver.findElements(By.xpath("(//tbody)[2]//tr[1]//td"));
        numberOfColumn = listColumn.size();
        boolean verifyData = false;

        if (numberOfColumn == 1){
            assertEquals(driver.findElement(By.xpath("(//tbody)[2]//tr[1]//td")).getText(), "No records available", "Search result hien thi sai.");
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
                                if (driver.findElement(By.xpath("(//tbody)[2]//tr[" + j + "]//td[" + k + "]")).getText().toLowerCase().contains(querySplitByLine[l].toLowerCase())) {
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

    public void searchInProjectsSection (int itemsPerPage, String query) throws Exception {
        viewProjectsSection();

        WebElement projectsSectionSearchInput = driver.findElement(projectsSectionSearchInputLocator);
        projectsSectionSearchInput.sendKeys(query);

        Thread.sleep(Duration.ofSeconds(1));

        verifyDataInTableByQuery(itemsPerPage, query);
    }

    public void viewProjectDetails(int itemsPerPage, String query) throws Exception {
        searchInProjectsSection(itemsPerPage, query);

        action.moveToElement(driver.findElement(By.xpath("(//tbody)[2]//tr"))).build().perform();
        WebElement projectsSectionViewProjectDetailsButton = driver.findElement(projectsSectionViewProjectDetailsButtonLocator);
        assertTrue(projectsSectionViewProjectDetailsButton.isDisplayed(), "View Project Details Button ko duoc hien thi.");
        projectsSectionViewProjectDetailsButton.click();
        Thread.sleep(Duration.ofSeconds(1));
        assertTrue(driver.findElement(By.xpath("//li[normalize-space()='Project Details']")).getText().contains("Project Details"), "Chua chuyen huong den trang project details.");
    }

    public void editProjectUpdateProgressStatusPriority(int itemsPerPage, String query, int progress, String status, String priority) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsProgress = driver.findElement(projectDetailsProgressLocator);
        if(Integer.parseInt(projectDetailsProgress.getText()) > progress) {
            action.moveToElement(projectDetailsProgress).build().perform();
            action.clickAndHold();
            while(Integer.parseInt(projectDetailsProgress.getText()) > progress) {
                action.moveByOffset(-1, 0).perform();
                projectDetailsProgress = driver.findElement(projectDetailsProgressLocator);
                Thread.sleep(100);
            }
            action.release().perform();
        }
        else if (Integer.parseInt(projectDetailsProgress.getText()) < progress) {
            action.moveToElement(projectDetailsProgress).build().perform();
            action.clickAndHold();
            while(Integer.parseInt(projectDetailsProgress.getText()) < progress) {
                action.moveByOffset(1, 0).perform();
                projectDetailsProgress = driver.findElement(projectDetailsProgressLocator);
                Thread.sleep(100);
            }
            action.release().perform();
        }
        else {
            System.out.println("Tien trinh du an hien tai giong voi tien trinh du an mong muon.");
        }

        String statusIndex = "";
        switch (status) {
            case "Not Started":
                statusIndex = "1";
                break;
            case "In Progress":
                statusIndex = "2";
                break;
            case "Cancelled":
                statusIndex = "3";
                break;
            case "On Hold":
                statusIndex = "4";
                break;
            case "Completed":
                statusIndex = "5";
                break;
            default:
                break;
        }
        driver.findElement(By.xpath("//div[@class='br-widget']//a[" + statusIndex + "]")).click();

        Select projectDetailsPrioritySelector = new Select(driver.findElement(projectDetailsPrioritySelectorLocator));
        projectDetailsPrioritySelector.selectByVisibleText(priority);

        WebElement projectDetailsUpdateStatusButton = driver.findElement(projectDetailsUpdateStatusButtonLocator);
        projectDetailsUpdateStatusButton.click();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project status updated."), "Update project detail success confirm message ko duoc hien thi.");
    }

    public void clickUpdateProjectButton() {
        WebElement projectDetailsEditSectionUpdateProjectButton = driver.findElement(projectDetailsEditSectionUpdateProjectButtonLocator);
        assertTrue(projectDetailsEditSectionUpdateProjectButton.isDisplayed(), "Update Project button ko duoc hien thi.");
        assertTrue(projectDetailsEditSectionUpdateProjectButton.isEnabled(), "Update Project button ko the tuong tac.");
        projectDetailsEditSectionUpdateProjectButton.click();
    }

    public void editProjectUpdateEditSectionSuccess(int itemsPerPage, String query, String title, String client, int estimatedHour, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);
        WebElement projectDetailsEditSection = driver.findElement(projectDetailsEditSectionLocator);
        projectDetailsEditSection.click();

        Thread.sleep(1000);

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickUpdateProjectButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project updated."), "Edit project success confirm ko duoc hien thi.");
    }

    public void editProjectUpdateEditSectionFailEmptyTitle(int itemsPerPage, String query, String title, String client, int estimatedHour, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);
        WebElement projectDetailsEditSection = driver.findElement(projectDetailsEditSectionLocator);
        projectDetailsEditSection.click();

        Thread.sleep(1000);

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickUpdateProjectButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The title field is required."), "Edit project fail confirm ko duoc hien thi.");
    }

    public void editProjectUpdateEditSectionFailEmptySummary(int itemsPerPage, String query, String title, String client, int estimatedHour, String startDate, String endDate, String summary, String teamMembers, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);
        WebElement projectDetailsEditSection = driver.findElement(projectDetailsEditSectionLocator);
        projectDetailsEditSection.click();

        Thread.sleep(1000);

        enterTitle(title);
        selectClient(client);
        enterEstimatedHour(estimatedHour);
        setStartDate(startDate);
        setEndDate(endDate);
        enterSummary(summary);
        enterTeam(teamMembers);
        enterDescription(description);
        clickUpdateProjectButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The summary field is required."), "Edit project fail confirm ko duoc hien thi.");
    }

    public void enterDiscussionMessage(String message) {
        driver.switchTo().frame(1);
        WebElement projectDetailsDiscussionSectionNewDiscussTextarea = driver.findElement(projectDetailsDiscussionSectionNewDiscussTextareaLocator);
        projectDetailsDiscussionSectionNewDiscussTextarea.clear();
        projectDetailsDiscussionSectionNewDiscussTextarea.sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public void editProjectDiscussionSectionAddNewDiscussSuccess(int itemsPerPage, String query, String message) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsDiscussionSection = driver.findElement(projectDetailsDiscussionSectionLocator);
        projectDetailsDiscussionSection.click();

        Thread.sleep(1000);

        enterDiscussionMessage(message);

        WebElement projectDetailsDiscussionSectionAddButton = driver.findElement(projectDetailsDiscussionSectionAddButtonLocator);
        projectDetailsDiscussionSectionAddButton.click();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project discussion added."), "Edit project add new discussion message success confirm ko duoc hien thi.");
    }

    public void editProjectDiscussionSectionAddNewDiscussFailEmptyMessage(int itemsPerPage, String query, String message) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsDiscussionSection = driver.findElement(projectDetailsDiscussionSectionLocator);
        projectDetailsDiscussionSection.click();

        Thread.sleep(1000);

        enterDiscussionMessage(message);

        WebElement projectDetailsDiscussionSectionAddButton = driver.findElement(projectDetailsDiscussionSectionAddButtonLocator);
        projectDetailsDiscussionSectionAddButton.click();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The discussion field is required."), "Edit project add new discussion message fail confirm ko duoc hien thi.");
    }

    public void editProjectDiscussionSectionDeleteDiscuss(int itemsPerPage, String query, int messageId) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsDiscussionSection = driver.findElement(projectDetailsDiscussionSectionLocator);
        projectDetailsDiscussionSection.click();

        Thread.sleep(1000);

        WebElement deleteMessageButton = null;
        try {
            deleteMessageButton = driver.findElement(By.xpath("//a[@data-field='" + messageId + "']"));
            deleteMessageButton.click();

            WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
            wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
            assertTrue(projectsPageConfirmMessage.getText().contains("Project discussion deleted."), "Edit project delete discussion message success confirm ko duoc hien thi.");
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Message khong ton tai.");
        }
    }

    public void enterBugDetail(String detail) {
        driver.switchTo().frame(2);
        WebElement projectDetailsBugSectionNewBugTextarea = driver.findElement(projectDetailsBugSectionNewBugTextareaLocator);
        projectDetailsBugSectionNewBugTextarea.clear();
        projectDetailsBugSectionNewBugTextarea.sendKeys(detail);
        driver.switchTo().defaultContent();
    }

    public void editProjectBugSectionAddNewBugSuccess(int itemsPerPage, String query, String detail) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsBugSection = driver.findElement(projectDetailsBugSectionLocator);
        projectDetailsBugSection.click();

        Thread.sleep(1000);

        enterBugDetail(detail);

        WebElement projectDetailsBugSectionAddButton = driver.findElement(projectDetailsBugSectionAddButtonLocator);
        projectDetailsBugSectionAddButton.click();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project bug added."), "Edit project add new bug success confirm ko duoc hien thi.");
    }

    public void editProjectBugSectionAddNewBugFailEmptyDetail(int itemsPerPage, String query, String detail) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsBugSection = driver.findElement(projectDetailsBugSectionLocator);
        projectDetailsBugSection.click();

        Thread.sleep(1000);

        enterBugDetail(detail);

        WebElement projectDetailsBugSectionAddButton = driver.findElement(projectDetailsBugSectionAddButtonLocator);
        projectDetailsBugSectionAddButton.click();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The bug field is required."), "Edit project add new bug fail confirm ko duoc hien thi.");
    }

    public void editProjectBugSectionDeleteBug(int itemsPerPage, String query, int bugId) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsBugSection = driver.findElement(projectDetailsBugSectionLocator);
        projectDetailsBugSection.click();

        Thread.sleep(1000);

        WebElement deleteBugButton = null;
        try {
            deleteBugButton = driver.findElement(By.xpath("//a[@data-field='" + bugId + "']"));
            deleteBugButton.click();

            WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
            wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
            assertTrue(projectsPageConfirmMessage.getText().contains("Project bug deleted."), "Edit project delete bug success confirm ko duoc hien thi.");
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Bug khong ton tai.");
        }
    }

    public void enterTaskTitle(String title) {
        WebElement projectDetailsTaskSectionAddNewTaskFormTitleInput = driver.findElement(projectDetailsTaskSectionAddNewTaskFormTitleInputLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormTitleInput.isDisplayed(), "Add new task title input ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormTitleInput.isEnabled(), "Add new task title input ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormTitleInput.clear();
        projectDetailsTaskSectionAddNewTaskFormTitleInput.sendKeys(title);
    }

    public void setTaskStartDate(String startDate) throws Exception{
        WebElement projectDetailsTaskSectionAddNewTaskFormStartDateInput = driver.findElement(projectDetailsTaskSectionAddNewTaskFormStartDateInputLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormStartDateInput.isDisplayed(), "Add new task start date input ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormStartDateInput.isDisplayed(), "Add new task start date input ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormStartDateInput.click();

        setDateInCalendar(startDate, "5");
    }

    public void setTaskEndDate(String endDate) throws Exception{
        WebElement projectDetailsTaskSectionAddNewTaskFormEndDateInput = driver.findElement(projectDetailsTaskSectionAddNewTaskFormEndDateInputLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormEndDateInput.isDisplayed(), "Add new task end date input ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormEndDateInput.isDisplayed(), "Add new task end date input ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormEndDateInput.click();

        setDateInCalendar(endDate, "6");
    }

    public void enterTaskEstimatedHour(int estimatedHour) {
        WebElement projectDetailsTaskSectionAddNewTaskFormEstimatedHourInput = driver.findElement(projectDetailsTaskSectionAddNewTaskFormEstimatedHourInputLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormEstimatedHourInput.isDisplayed(), "Add new task estimated hour input ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormEstimatedHourInput.isEnabled(), "Add new task estimated hour input ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormEstimatedHourInput.clear();
        projectDetailsTaskSectionAddNewTaskFormEstimatedHourInput.sendKeys(String.valueOf(estimatedHour));
    }

    public void enterTaskSummary(String summary) {
        WebElement projectDetailsTaskSectionAddNewTaskFormSummaryTextArea = driver.findElement(projectDetailsTaskSectionAddNewTaskFormSummaryTextAreaLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormSummaryTextArea.isDisplayed(), "Add new task summary text area ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormSummaryTextArea.isEnabled(), "Add new task summary text area ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormSummaryTextArea.clear();
        projectDetailsTaskSectionAddNewTaskFormSummaryTextArea.sendKeys(summary);
    }

    public void enterTaskDescription(String description) {
        driver.switchTo().frame(3);
        WebElement projectDetailsTaskSectionAddNewTaskFormDescriptionTextarea = driver.findElement(projectDetailsTaskSectionAddNewTaskFormDescriptionTextareaLocator);
        projectDetailsTaskSectionAddNewTaskFormDescriptionTextarea.clear();
        projectDetailsTaskSectionAddNewTaskFormDescriptionTextarea.sendKeys(description);
        driver.switchTo().defaultContent();
    }

    public void clickSaveTaskButton() {
        WebElement projectDetailsTaskSectionAddNewTaskFormSaveButton = driver.findElement(projectDetailsTaskSectionAddNewTaskFormSaveButtonLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskFormSaveButton.isDisplayed(), "Add new task save button ko duoc hien thi.");
        assertTrue(projectDetailsTaskSectionAddNewTaskFormSaveButton.isEnabled(), "Add new task save button ko the tuong tac.");
        projectDetailsTaskSectionAddNewTaskFormSaveButton.click();
    }

    public void editProjectTaskSectionAddNewTaskSuccess(int itemsPerPage, String query, String title, String startDate, String endDate, int estimatedHour, String summary, String description) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskStartDate(startDate);
        setTaskEndDate(endDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Task added."), "Edit project add new task success confirm ko duoc hien thi.");
    }

    public void editProjectTaskSectionAddNewTaskFailEmptyTitle(int itemsPerPage, String query, String title, String startDate, String endDate, int estimatedHour, String summary, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskStartDate(startDate);
        setTaskEndDate(endDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The task_name field is required."), "Edit project add new task fail confirm ko duoc hien thi.");
    }

    public void editProjectTaskSectionAddNewTaskFailEmptyStartDate(int itemsPerPage, String query, String title, String endDate, int estimatedHour, String summary, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskEndDate(endDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The start_date field is required."), "Edit project add new task fail confirm ko duoc hien thi.");
    }

    public void editProjectTaskSectionAddNewTaskFailEmptyEndDate(int itemsPerPage, String query, String title, String startDate, int estimatedHour, String summary, String description) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskStartDate(startDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The end_date field is required."), "Edit project add new task fail confirm ko duoc hien thi.");
    }

    public void editProjectTaskSectionAddNewTaskFailEmptySummary(int itemsPerPage, String query, String title, String startDate, String endDate, int estimatedHour, String summary, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskStartDate(startDate);
        setTaskEndDate(endDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The summary field is required."), "Edit project add new task fail confirm ko duoc hien thi.");
    }

    public void editProjectTaskSectionAddNewTaskFailShortSummary(int itemsPerPage, String query, String title, String startDate, String endDate, int estimatedHour, String summary, String description) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsTaskSection = driver.findElement(projectDetailsTaskSectionLocator);
        projectDetailsTaskSection.click();

        Thread.sleep(1000);

        WebElement projectDetailsTaskSectionAddNewTaskButton = driver.findElement(projectDetailsTaskSectionAddNewTaskButtonLocator);
        projectDetailsTaskSectionAddNewTaskButton.click();

        WebElement projectDetailsTaskSectionAddNewTaskForm = driver.findElement(projectDetailsTaskSectionAddNewTaskFormLocator);
        assertTrue(projectDetailsTaskSectionAddNewTaskForm.isDisplayed(), "project Details Task Section Add New Task Form ko duoc hien thi.");

        enterTaskTitle(title);
        setTaskStartDate(startDate);
        setTaskEndDate(endDate);
        enterTaskEstimatedHour(estimatedHour);
        enterTaskSummary(summary);
        enterTaskDescription(description);
        clickSaveTaskButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The summary field must be at least 60 characters in length."), "Edit project add new task fail confirm ko duoc hien thi.");
    }

    public void enterFileTitle(String title) {
        WebElement projectDetailsAttachFilesSectionTitleInput = driver.findElement(projectDetailsAttachFilesSectionTitleInputLocator);
        assertTrue(projectDetailsAttachFilesSectionTitleInput.isDisplayed(), "projectDetailsAttachFilesSectionTitleInput ko duoc hien thi.");
        assertTrue(projectDetailsAttachFilesSectionTitleInput.isEnabled(), "projectDetailsAttachFilesSectionTitleInput ko the tuong tac.");
        projectDetailsAttachFilesSectionTitleInput.sendKeys(title);
    }

    public void enterFile(String fileName) {
        WebElement projectDetailsAttachFilesSectionAttachmentInput = driver.findElement(projectDetailsAttachFilesSectionAttachmentInputLocator);
        assertTrue(projectDetailsAttachFilesSectionAttachmentInput.isDisplayed(), "projectDetailsAttachFilesSectionAttachmentInput ko duoc hien thi.");
        assertTrue(projectDetailsAttachFilesSectionAttachmentInput.isEnabled(), "projectDetailsAttachFilesSectionAttachmentInput ko the tuong tac.");
        projectDetailsAttachFilesSectionAttachmentInput.sendKeys(System.getProperty("user.dir") + "/src/test/java/resource/" + fileName);
    }

    public void clickAddFileButton() {
        WebElement projectDetailsAttachFilesSectionAddFileButton = driver.findElement(projectDetailsAttachFilesSectionAddFileButtonLocator);
        assertTrue(projectDetailsAttachFilesSectionAddFileButton.isDisplayed(), "projectDetailsAttachFilesSectionAddFileButton ko duoc hien thi.");
        assertTrue(projectDetailsAttachFilesSectionAddFileButton.isEnabled(), "projectDetailsAttachFilesSectionAddFileButton ko the tuong tac.");
        projectDetailsAttachFilesSectionAddFileButton.click();
    }

    public void editProjectAttachFilesSectionAddFileSuccess(int itemsPerPage, String query, String title, String fileName) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        enterFileTitle(title);
        enterFile(fileName);
        clickAddFileButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project file added."), "Edit project add file success confirm ko duoc hien thi.");
    }

    public void editProjectAttachFilesSectionAddFileFailEmptyTitle(int itemsPerPage, String query, String title, String fileName) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        enterFileTitle(title);
        enterFile(fileName);
        clickAddFileButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The file_name field is required."), "Edit project add file fail confirm ko duoc hien thi.");
    }

    public void editProjectAttachFilesSectionAddFileFailEmptyFile(int itemsPerPage, String query, String title) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        enterFileTitle(title);
        clickAddFileButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The file field is required."), "Edit project add file fail confirm ko duoc hien thi.");
    }

    public void editProjectAttachFilesSectionAddFileFailNotImageFile(int itemsPerPage, String query, String title,  String fileName) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        enterFileTitle(title);
        enterFile(fileName);
        clickAddFileButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("wrong size"), "Edit project add file fail confirm ko duoc hien thi.");
    }

    public void editProjectAttachFilesSectionAddFileFailFileSizeTooLarge(int itemsPerPage, String query, String title, String fileName) throws Exception{
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        enterFileTitle(title);
        enterFile(fileName);
        clickAddFileButton();

        longWait.until(ExpectedConditions.visibilityOfElementLocated(projectsPageConfirmMessageLocator));
        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        assertTrue(projectsPageConfirmMessage.getText().contains("attachment_file is too large of a file."), "Edit project add file fail confirm ko duoc hien thi.");
    }

    public void editProjectAttachFilesSectionDeleteFile(int itemsPerPage, String query, int fileId) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsAttachFilesSection = driver.findElement(projectDetailsAttachFilesSectionLocator);
        projectDetailsAttachFilesSection.click();

        Thread.sleep(1000);

        WebElement deleteFileButton = null;
        try {
            deleteFileButton = driver.findElement(By.xpath("//a[@data-field='" + fileId + "']//span"));
            deleteFileButton.click();

            WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
            wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
            assertTrue(projectsPageConfirmMessage.getText().contains("Project file deleted."), "Edit project delete file success confirm ko duoc hien thi.");
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("File khong ton tai.");
        }
    }

    public void enterNote(String note) {
        WebElement projectDetailsNoteSectionNoteInput = driver.findElement(projectDetailsNoteSectionNoteInputLocator);
        assertTrue(projectDetailsNoteSectionNoteInput.isDisplayed(), "projectDetailsNoteSectionNoteInput ko duoc hien thi.");
        assertTrue(projectDetailsNoteSectionNoteInput.isEnabled(), "projectDetailsNoteSectionNoteInput ko the tuong tac.");
        projectDetailsNoteSectionNoteInput.sendKeys(note);
    }

    public void clickAddNoteButton() {
        WebElement projectDetailsNoteSectionAddNoteButton = driver.findElement(projectDetailsNoteSectionAddNoteButtonLocator);
        assertTrue(projectDetailsNoteSectionAddNoteButton.isDisplayed(), "projectDetailsNoteSectionAddNoteButton ko duoc hien thi.");
        assertTrue(projectDetailsNoteSectionAddNoteButton.isEnabled(), "projectDetailsNoteSectionAddNoteButton ko the tuong tac.");
        projectDetailsNoteSectionAddNoteButton.click();
    }

    public void editProjectNoteSectionAddNoteSuccess(int itemsPerPage, String query, String note) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsNoteSection = driver.findElement(projectDetailsNoteSectionLocator);
        projectDetailsNoteSection.click();

        Thread.sleep(1000);

        enterNote(note);
        clickAddNoteButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("Project note added."), "Edit project add note success confirm ko duoc hien thi.");
    }

    public void editProjectNoteSectionAddNoteFailEmptyNote(int itemsPerPage, String query, String note) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsNoteSection = driver.findElement(projectDetailsNoteSectionLocator);
        projectDetailsNoteSection.click();

        Thread.sleep(1000);

        enterNote(note);
        clickAddNoteButton();

        WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
        wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
        assertTrue(projectsPageConfirmMessage.getText().contains("The note field is required."), "Edit project add note fail confirm ko duoc hien thi.");
    }

    public void editProjectNoteSectionDeleteNote(int itemsPerPage, String query, int noteId) throws Exception {
        viewProjectDetails(itemsPerPage, query);

        WebElement projectDetailsNoteSection = driver.findElement(projectDetailsNoteSectionLocator);
        projectDetailsNoteSection.click();

        Thread.sleep(1000);

        WebElement deleteNoteButton = null;
        try {
            deleteNoteButton = driver.findElement(By.xpath("//li[@id='note_option_id_" + noteId + "']//a[normalize-space()='Delete']"));
            deleteNoteButton.click();

            WebElement projectsPageConfirmMessage = driver.findElement(projectsPageConfirmMessageLocator);
            wait.until(ExpectedConditions.visibilityOf(projectsPageConfirmMessage));
            assertTrue(projectsPageConfirmMessage.getText().contains("Project note deleted."), "Edit project delete note success confirm ko duoc hien thi.");
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Note khong ton tai.");
        }
    }
}
