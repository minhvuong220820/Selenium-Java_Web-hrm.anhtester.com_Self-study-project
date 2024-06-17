package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Initiation;
import pages.HomePage;
import pages.LoginPage;
import pages.ProjectPage;

public class ProjectTestCase extends Initiation{

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private ProjectPage projectPage;
	
	@BeforeClass
	public void beforeTest() {
		driver = Setup("chrome");
	}
	
	@Test
	public void testViewProjectsSection() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.viewProjectsSection();
	}

	@Test
	public void testAddNewProjectSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.addNewProjectSuccess("test title", "quang pham", 72, "Normal", "10-07-2030", "12-07-2030", "test summary", "Project Manager,Admin Example", "test description");
	}

	@Test
    public void testAddNewProjectFailEmptyTitle() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.addNewProjectFailEmptyTitle("", "quang pham", 72, "Normal", "10-07-2030", "12-07-2030", "test summary", "Project Manager,Admin Example", "test description");
	}

	@Test
	public void testAddNewProjectFailEmptyClient() throws Exception {
		loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToProjectsPage();
        projectPage = new ProjectPage(driver);
        projectPage.addNewProjectFailEmptyClient("test title", "", 72, "Normal", "10-07-2030", "12-07-2030", "test summary", "Project Manager,Admin Example", "test description");
	}

	@Test
    public void testAddNewProjectFailEmptyStartDate() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.addNewProjectFailEmptyStartDate("test title", "quang pham", 72, "Normal", "12-07-2030", "test summary", "Project Manager,Admin Example", "test description");
	}

	@Test
    public void testAddNewProjectFailEmptyEndDate() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.addNewProjectFailEmptyEndDate("test title", "quang pham", 72, "Normal", "10-07-2030", "test summary", "Project Manager,Admin Example", "test description");
	}

	@Test
    public void testAddNewProjectFailEmptySummary() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.addNewProjectFailEmptySummary("test title", "quang pham", 72, "Normal", "10-07-2030", "12-07-2030", "", "Project Manager,Admin Example", "test description");
	}

	@Test
    public void testSearchInProjectsSection() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.searchInProjectsSection(10, "25-10-2023 25 high");
	}

	@Test
	public void testViewProjectDetails() throws Exception {
		loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToProjectsPage();
        projectPage = new ProjectPage(driver);
        projectPage.viewProjectDetails(10, "2030");
	}

	@Test
	public void testEditProjectUpdateProgressStatusPriority() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectUpdateProgressStatusPriority(10, "2030", 30, "On Hold", "High");
	}

	@Test
	public void testEditProjectUpdateEditSectionSuccess() throws Exception{
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectUpdateEditSectionSuccess(10, "2030", "new test title", "Taii Nguyen", 72,"10-07-2030", "12-07-2030", "new test summary", "Project Manager", "new test description");
	}

	@Test
	public void testEditProjectUpdateEditSectionFailEmptyTitle() throws Exception{
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectUpdateEditSectionFailEmptyTitle(10, "2030", "", "Taii Nguyen", 72,"10-07-2030", "12-07-2030", "new test summary", "Project Manager", "new test description");
	}

	@Test
	public void testEditProjectUpdateEditSectionFailEmptySummary() throws Exception{
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectUpdateEditSectionFailEmptySummary(10, "2030", "New Title", "Taii Nguyen", 72,"10-07-2030", "12-07-2030", "", "Project Manager,hehe he,duy nguyen", "new test description");
	}

	@Test
	public void testEditProjectDiscussionSectionAddNewDiscussSuccess() throws Exception{
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectDiscussionSectionAddNewDiscussSuccess(10, "2030", "Buoc nay lam the nay, bla bla");
	}

	@Test
	public void testEditProjectDiscussionSectionAddNewDiscussFailEmptyMessage() throws Exception {
		loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToProjectsPage();
        projectPage = new ProjectPage(driver);
        projectPage.editProjectDiscussionSectionAddNewDiscussFailEmptyMessage(10, "2030", "");
	}
	@Test
	public void testEditProjectDiscussionSectionDeleteDiscuss() throws Exception{
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectDiscussionSectionDeleteDiscuss(10, "2030", 4);
	}

	@Test
	public void testEditProjectBugSectionAddNewBugSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectBugSectionAddNewBugSuccess(10, "2030", "co loi xay ra o function bla bla");
	}

	@Test
	public void testEditProjectBugSectionAddNewBugFailEmptyDetail() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectBugSectionAddNewBugFailEmptyDetail(10, "2030", "");
	}

	@Test
	public void testEditProjectBugSectionDeleteBug() throws Exception {
		loginPage = new LoginPage(driver);
        loginPage.loginSuccess("admin_example", "123456");
        Thread.sleep(Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        homePage.navigateToProjectsPage();
        projectPage = new ProjectPage(driver);
        projectPage.editProjectBugSectionDeleteBug(10, "2030", 2);
	}

	@Test
    public void testEditProjectTaskSectionAddNewTaskSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskSuccess(10, "2030", "Task1 title", "10-07-2030", "11-07-2030", 3, "bla bal bla bla bla bal bla bla bla bal bla bla bla bal bla bla", "task Description");
	}

	@Test
    public void testEditProjectTaskSectionAddNewTaskFailEmptyTitle() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskFailEmptyTitle(10, "2030", "", "10-07-2030", "11-07-2030", 3, "bla bal bla bla bla bal bla bla bla bal bla bla bla bal bla bla", "task Description");
	}

	@Test
	public void testEditProjectTaskSectionAddNewTaskFailEmptyStartDate() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskFailEmptyStartDate(10, "2030", "Task1 title", "11-07-2030", 3, "bla bal bla bla bla bal bla bla bla bal bla bla bla bal bla bla", "task Description");
	}

	@Test
    public void testEditProjectTaskSectionAddNewTaskFailEmptyEndDate() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskFailEmptyEndDate(10, "2030", "Task1 title", "10-07-2030", 3, "bla bal bla bla bla bal bla bla bla bal bla bla bla bal bla bla", "task Description");
	}

	@Test
	public void testEditProjectTaskSectionAddNewTaskFailEmptySummary() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskFailEmptySummary(10, "2030", "Task1 title", "10-07-2030", "11-07-2030", 3, "", "task Description");
	}

	@Test
	public void testEditProjectTaskSectionAddNewTaskFailShortSummary() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectTaskSectionAddNewTaskFailShortSummary(10, "2030", "Task1 title", "10-07-2030", "11-07-2030", 3, "123", "task Description");
	}

	@Test
	public void testEditProjectAttachFilesSectionAddFileSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionAddFileSuccess(10, "2030", "File title 1", "1.jpg");
	}

	@Test
	public void testEditProjectAttachFilesSectionAddFileFailEmptyTitle() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionAddFileFailEmptyTitle(10, "2030", "", "1.jpg");
	}

	@Test
	public void testEditProjectAttachFilesSectionAddFileFailEmptyFile() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionAddFileFailEmptyFile(10, "2030", "file name 234");
	}

	@Test
	public void testEditProjectAttachFilesSectionAddFileFailNotImageFile() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionAddFileFailNotImageFile(10, "2030", "File title 1", "a.txt");
	}

	@Test
	public void testEditProjectAttachFilesSectionAddFileFailFileSizeTooLarge() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionAddFileFailFileSizeTooLarge(10, "2030", "File title 1", "57mb.gif");
	}

	@Test
	public void testEditProjectAttachFilesSectionDeleteFile() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectAttachFilesSectionDeleteFile(10, "2030", 5);
	}

	@Test
	public void testEditProjectNoteSectionAddNoteSuccess() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectNoteSectionAddNoteSuccess(10, "2030", "note 1");
	}

	@Test
	public void testEditProjectNoteSectionAddNoteFailEmptyNote() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectNoteSectionAddNoteFailEmptyNote(10, "2030", "");
	}

	@Test
	public void testEditProjectNoteSectionDeleteNote() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin_example", "123456");
		Thread.sleep(Duration.ofSeconds(2));
		homePage = new HomePage(driver);
		homePage.navigateToProjectsPage();
		projectPage = new ProjectPage(driver);
		projectPage.editProjectNoteSectionDeleteNote(10, "2030", 5);
	}

	@AfterClass
	public void afterTest() throws Exception {
		Close();
	}
}
