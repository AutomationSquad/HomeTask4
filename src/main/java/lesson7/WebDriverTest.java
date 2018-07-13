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

        String searchString = "Ukraine";
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchInput.sendKeys(searchString);

        String currentLanguage = "English";
        Select drpCountry = new Select(driver.findElement(By.id("searchLanguage")));
        drpCountry.selectByVisibleText(currentLanguage);

        assertEquals(currentLanguage, drpCountry.getFirstSelectedOption().getText(), "Wrong language");

        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");

        assertEquals(searchString, driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[1]/th/span")).getText(), "Wrong title");
    }
}
