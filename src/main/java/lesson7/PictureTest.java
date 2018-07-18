package lesson7;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PictureTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.xpath("//*[@id='js-link-box-en']")).click();

        Assert.assertTrue("Section was not found", driver.findElement(By.xpath("//*[@id=\"Today's_featured_picture\"]")).isEnabled());

        Assert.assertTrue("Image not found", driver.findElement(By.xpath("//*[@id=\"mp-tfp\"]//img")).isEnabled());

        driver.findElement(By.xpath("//*[@class='mw-input mw-htmlform-nolabelt']")).click();

    }
}

