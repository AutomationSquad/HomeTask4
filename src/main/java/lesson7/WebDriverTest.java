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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertEquals(searchString, driver.findElement(By.cssSelector(".country-name")).getText(), "Wrong title");
    }

    @Test
    public void todaysFeaturedPictureNotEmpty() {
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]")).click();

        String featuredPictureText = "Today's featured picture";
        WebElement featuredPictureBlock = driver.findElement(By.id("mp-bottom"));

        assertEquals(featuredPictureText, featuredPictureBlock.findElement(By.id("Today's_featured_picture")).getText(), "Wrong title");

        WebElement picture = featuredPictureBlock.findElement(By.xpath("//*[@id=\"mp-tfp\"]//*[@class=\"image\"]/img"));
        assertFalse(picture.getAttribute("src").isEmpty(), "A picture missing");
        assertTrue(picture.isDisplayed());
    }

    @Test
    public void enterInvalidCredentialsExpectedTryAgainMessage() {
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("js-link-box-en")).click();
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a")).click();

        WebElement inputLogin = driver.findElement(By.id("wpName1"));
        WebElement inputPassword = driver.findElement(By.id("wpPassword1"));

        inputLogin.sendKeys("123");
        inputPassword.sendKeys("123");
        driver.findElement(By.id("wpLoginAttempt")).submit();

        String invalidCredentialsMessage = "Incorrect username or password entered. Please try again.";

        assertEquals(invalidCredentialsMessage,
                driver.findElement(By.cssSelector(".error > .mw-parser-output > p")).getText(),
                "Invalid credential message");
    }
}
