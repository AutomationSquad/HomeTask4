package lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void Test(){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@id='js-link-box-en']")).click();
        driver.findElement(By.xpath("//*[@id='pt-login']")).click();

        WebElement loginInput = driver.findElement(By.xpath("//*[@id='wpName1']"));
        String credString = "123";
        loginInput.sendKeys(credString);

        WebElement passInput = driver.findElement(By.xpath("//*[@id='wpPassword1']"));
        passInput.sendKeys(credString);
        passInput.sendKeys(credString);

        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();
        assertEquals("Incorrect username or password entered. Please try again.", driver.findElement(By.xpath("//*[@id=\"userloginForm\"]/form/div[1]/div/p")).getText(),"User name / passwor  validation  is missed." );
        
    }

}
