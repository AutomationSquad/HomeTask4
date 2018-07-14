package lesson7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class WebDriverTest extends BaseTest {

    @Test
        // THE TEST FROM THE LECTURE
    void firstTest() {
        String searchString;
        Select drpCountry;
        WebElement searchInput;

        driver.get("https://www.wikipedia.org/");

        drpCountry = new Select(driver.findElement(By.id("searchLanguage")));
        searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchString = "Ukraine";
        drpCountry.selectByVisibleText("English");
        searchInput.sendKeys(searchString);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(), "Wrong title");
        assertEquals(searchString, driver.findElement(By.cssSelector("[class='fn org country-name']")).getText(), "Wrong country name");


    }

    @Test
        // THE FIRST HOME TASK TEST
    void secondTest() {
        Boolean sectionIsPresent, imageIsPresent;

        driver.get("https://www.wikipedia.org/");
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOfElementLocated(By.id("js-link-box-en")));

        driver.findElement(By.id("js-link-box-en")).click();
        sectionIsPresent = driver.findElements(By.id("Today's_featured_picture")).size() > 0;
        imageIsPresent = driver.findElements(By.xpath("//*[@id=\"mp-tfp\"]//img")).size() > 0;
        Assertions.assertTrue(sectionIsPresent, "The 'Today's featured picture' section isn't shown !!!");
        Assertions.assertTrue(imageIsPresent, "The image doesn't present in the 'Today's featured picture' section !!!");


    }

    @Test
        // THE SECOND HOME TASK TEST
    void thirdTest() {
        WebElement loginField, passwordField;
        String login = "Ukraine";
        String password = "Ukraine";

        driver.get("https://www.wikipedia.org/");
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOfElementLocated(By.id("js-link-box-en")));

        driver.findElement(By.id("js-link-box-en")).click();
        driver.findElement(By.id("pt-login")).click();
        loginField = driver.findElement(By.id("wpName1"));
        passwordField = driver.findElement(By.id("wpPassword1"));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        driver.findElement(By.id("wpLoginAttempt")).click();
        assertEquals("Incorrect username or password entered. Please try again.", driver.findElement(By.cssSelector("[class = 'mw-parser-output']")).getText(), "The text of the error message isn't compared with mockup!!");


    }
}
