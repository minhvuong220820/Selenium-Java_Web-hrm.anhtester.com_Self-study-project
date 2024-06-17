package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbcPage {
    private WebDriver driver;
    Actions action;
    WebDriverWait wait;

    By searchInputLocator = By.xpath("//textarea[@id='APjFqb']");

    public AbcPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void search(String query) throws InterruptedException {
        WebElement searchInput = driver.findElement(searchInputLocator);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='Google']"))));
        searchInput.sendKeys(query);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(Duration.ofSeconds(3));
    }
}
