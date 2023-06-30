package TestCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContactTests {

    WebDriver driver;
    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void MandatoryErrorMessages()
    {
        driver.get("https://d3ovkzfkbrwp1z.cloudfront.net/#/");

        driver.findElement(By.cssSelector("[aria-label='contact']")).click();

        driver.findElement(By.cssSelector("[aria-label='submit']")).click();


        popupMsg("forename-err", "Forename is required");
        popupMsg("email-err", "Email is required");
        popupMsg("message-err", "Message is required");

        driver.findElement(By.id("forename")).sendKeys("Dan");
        Assertions.assertTrue(driver.findElement(By.id("forename-err")).isDisplayed());

        driver.findElement(By.id("email")).sendKeys("dan@abc.com");
        Assertions.assertTrue(driver.findElement(By.id("forename-err")).isDisplayed());

        driver.findElement(By.id("message")).sendKeys("Nice Pizza");
        Assertions.assertTrue(driver.findElement(By.id("message-err")).isDisplayed());

    }



    public void popupMsg(String element, String actualTest )
    {
        By popupmassage = By.id(element);
        Assertions.assertEquals(actualTest,
                driver.findElement(popupmassage).getText());
    }

    @Test
    public void clearUp(){
        driver.quit();
    }
}
