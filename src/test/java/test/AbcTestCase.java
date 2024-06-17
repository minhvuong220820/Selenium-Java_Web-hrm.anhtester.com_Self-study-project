package test;

import base.Initiation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbcPage;
import pages.LoginPage;

public class AbcTestCase extends Initiation {

    //Day la file de test linh tinh bat cu thu gi, k lien quan den 3 file test cua 3 page trong du an hrmanhtester

    private WebDriver driver;
    private AbcPage abcPage;

    @BeforeClass
    public void beforeTest() {
        driver = Setup("chrome");
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        abcPage = new AbcPage(driver);
        try {
            abcPage.search("thoi tiet hom nay");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterTest() throws Exception {
        Close();
    }
}
