package lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InvalidLoginTest extends BaseTest {

    @Test
    void testInvalidLogin() {
        driver.get("https://www.wikipedia.org/");

        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();

        WebElement login = driver.findElement(By.id("pt-login"));
        login.click();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"wpName1\"]"));
        username.sendKeys("123");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".error"));

        Assertions.assertEquals("Incorrect username or password entered. Please try again.", errorMessage.getText(),
                "Inappropriate error text");
    }
}
