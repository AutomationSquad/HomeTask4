package lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://www.wikipedia.org/");

        Select language = new Select(driver.findElement(By.id("searchLanguage")));
        language.selectByVisibleText("English");


        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);

        driver.findElement(By.cssSelector("[type='submit']")).click();

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");
        assertEquals(searchString, driver.findElement(By.cssSelector("[class='fn org country-name']")).getText(),
                "Wrong country is opened");

    }
}
