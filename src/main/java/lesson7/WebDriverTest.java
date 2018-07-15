package lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.wikipedia.org/");
        Select drpCountry;
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);
        drpCountry = new Select(driver.findElement(By.id("searchLanguage")));
        drpCountry.selectByVisibleText("English");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),"Wrong title");
        assertEquals(searchString, driver.findElement(By.cssSelector("[class='fn org country-name']")).getText(), "Wrong country name");

    }
    @Test
    public void test2(){
        String picture = "Today's featured picture";
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]")).click();
        assertEquals(picture,driver.findElement(By.id("Today's_featured_picture")).getText(), "Wrong title");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mp-tfp\"]/table/tbody/tr/td[1]/a/img")).isDisplayed(), "No picture");
    }
    @Test
    public void test3(){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]")).click();
        driver.findElement(By.id("pt-login")).click();
        driver.findElement(By.id("wpName1")).sendKeys("admin");
        driver.findElement(By.id("wpPassword1")).sendKeys("admin");
        driver.findElement(By.id("wpLoginAttempt")).click();
        assertEquals("Incorrect username or password entered. Please try again.",driver.findElement(By.cssSelector("[class = 'mw-parser-output']")).getText(),
        "Invalid message");
    }
}
