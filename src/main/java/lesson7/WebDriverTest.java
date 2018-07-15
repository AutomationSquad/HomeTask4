package lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.wikipedia.org/");

        WebElement language = driver.findElement(By.id("js-link-box-en"));
        language.click();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);

        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");
        assertEquals(searchString, driver.findElement(By.xpath("//span[@class = 'fn org country-name']")).getText(), "Wrong country");

    }
    @Test
    public void test1() {
        driver.get("https://www.wikipedia.org/");
        WebElement language = driver.findElement(By.id("js-link-box-en"));
        language.click();
        String string = "Today's featured picture";
        assertEquals(string, driver.findElement(By.id("Today's_featured_picture")).getText(), "Wrong section");
        WebElement image = driver.findElement(By.xpath("//div[@id = 'mp-tfp']//a[@class = 'image']"));
        assertTrue(image.isDisplayed());

    }
    @Test
    public void test2() {
        driver.get("https://www.wikipedia.org/");
        WebElement language = driver.findElement(By.id("js-link-box-en"));
        language.click();
        WebElement login = driver.findElement(By.xpath("//a[@accesskey = 'o']"));
        login.click();
        String username = "123";
        String password = "123";
        WebElement input1 = driver.findElement(By.id("wpName1"));
        WebElement input2 = driver.findElement(By.id("wpPassword1"));
        input1.sendKeys(username);
        input2.sendKeys(password);
        WebElement button = driver.findElement(By.xpath("//button[@id = 'wpLoginAttempt']"));
        button.click();
        String wrongCredentials ="Incorrect username or password entered. Please try again.";
        assertEquals(wrongCredentials, driver.findElement(By.xpath("//div[@class = 'mw-parser-output']/p")).getText(), "no message");



    }
}
