package lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeatureDayImageTest extends BaseTest {


    @Test
    void testInvalidLogic() {
        driver.get("https://www.wikipedia.org/");

        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();

        WebElement featureDay = driver.findElement(By.cssSelector("[class='MainPageBG']"));

        Assertions.assertNotNull(featureDay.findElement(By.cssSelector("[class='image']")));
    }
}
