package lesson7;

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
    public void test(){
        driver.get("https://www.wikipedia.org/");

        Select drpCountry = new Select(driver.findElement(By.id("searchLanguage")));
        drpCountry.selectByVisibleText("English");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);

        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");
        assertEquals(searchString, driver.findElement(By.cssSelector("[class='fn org country-name']")).getText(), "Wrong title on the side panel");
    }

    @Test
    public void imageTest(){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong")).click();
        String featuredPicture = "Today's featured picture";
        assertEquals(true, driver.findElement(By.id("Today's_featured_picture")).isDisplayed(), "Today's featured picture section is missed.");
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"mp-tfp\"]/table/tbody/tr[1]/td/a/img")).isDisplayed(), "Today's featured picture section is missed.");

    }

    @Test
    public void logInNegativeTest(){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong")).click();
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"wpName1\"]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();
        assertEquals("Incorrect username or password entered. Please try again.", driver.findElement(By.xpath("//*[@id=\"userloginForm\"]/form/div[1]/div/p")).getText(),  "User name / passwor  validation  is missed." );


    }
}
