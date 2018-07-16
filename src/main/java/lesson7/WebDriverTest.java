package lesson7;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.WebEndpoint;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.wikipedia.org/");

        Select country = new Select(driver.findElement(By.id("searchLanguage")));
        country.selectByVisibleText("English");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);

        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");

        WebElement countryHighlight = driver.findElement(By.cssSelector(".fn.org.country-name"));
        String countryDisplayed = countryHighlight.getText();
        Assert.assertEquals("Ukraine", countryDisplayed);

    }

    @Test

    public void checkImage() {

        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.cssSelector("a#js-link-box-en>strong")).click();

        WebElement todaySection = driver.findElement(By.id("Today's_featured_picture"));
        String todayElement = todaySection.getText();
        Assert.assertEquals("Today's featured picture", todayElement);
        Assert.assertEquals(true, driver.findElement(By.cssSelector("#mp-tfp>table>tbody>tr>td>a")).isDisplayed());
    }

    @Test

    public void login() {

        driver.get("https://www.wikipedia.org/");
        driver.findElement((By.cssSelector("a#js-link-box-en>strong"))).click();
        driver.findElement(By.cssSelector("a[title=\"You're encouraged to log in; however, it's not mandatory. [ctrl-option-o]\"]")).click();
        driver.findElement(By.cssSelector("#wpName1")).sendKeys("123");
        driver.findElement(By.cssSelector("#wpPassword1")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();
        Assert.assertEquals("Incorrect username or password entered. Please try again.", driver.findElement(By.cssSelector(".mw-parser-output>p")).getText());
    }

}
