package lesson7;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends BaseTest {

    @Test
    public void test1(){
        driver.get("https://www.wikipedia.org/");

        Select searchLanguage = new Select(driver.findElement(By.id("searchLanguage")));
        searchLanguage.selectByVisibleText("English");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);


        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");
        assertEquals(searchString, driver.findElement(By.cssSelector("[class='fn org country-name']")).getText(),
                "Wrong text");

    }

    @Test
    public void test2(){
        driver.get("https://www.wikipedia.org/");

        WebElement language = driver.findElement(By.xpath("//*[@class='central-featured-lang lang2']//*[text()='English']"));
        language.click();

        String todayPictureSection = "Today's featured picture";
        assertEquals(todayPictureSection, driver.findElement(By.id("Today's_featured_picture")).getText(),
                "Wrong text");

       WebElement todayImage = driver.findElement(By.xpath("//*[@id='mp-tfp']/table/tbody/tr/td/a/img"));
       Assert.assertFalse("Picture is absent", todayImage.getAttribute("src").isEmpty());
    }

    @Test
    public void test3(){
        driver.get("https://www.wikipedia.org/");

        WebElement language = driver.findElement(By.xpath("//*[@class='central-featured-lang lang2']//*[text()='English']"));
        language.click();

        WebElement login = driver.findElement(By.id("pt-login"));
        login.click();

        WebElement usernameInput = driver.findElement(By.id("wpName1"));
        String username = "test123";
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("wpPassword1"));
        String password = "test123";
        passwordInput.sendKeys(password);

        driver.findElement(By.id("wpLoginAttempt")).click();

        String loginFailed = "Incorrect username or password entered. Please try again.";
        assertEquals(loginFailed, driver.findElement(By.cssSelector("[class='mw-parser-output']")).getText(),
                "Wrong message");
    }
}
