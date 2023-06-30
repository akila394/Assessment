package TestCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class MenuTests {

    WebDriver driver;
    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void menuTest(){
        driver.get("https://d3ovkzfkbrwp1z.cloudfront.net/#/");
        driver.findElement(By.cssSelector("[aria-label='menu']")).click();


        List<WebElement> sideelements = driver.findElements(
                By.cssSelector("[class='v-tab v-tab--active']"));

        driver.findElement(By.xpath("//div[text()=\" Sides \"]")).click();

//        for(WebElement sides: sideelements){
//            if(sides.getText().equalsIgnoreCase("fastfood")){
//                sides.click();
//            }
//        }

        List<WebElement> sideVegetarian = driver.findElements(By.cssSelector(
                "[class='v-card v-sheet theme--light flexcard px-2 menuItem side vegetarian']"));

        for(WebElement sides: sideVegetarian){
            if(sides.findElement(By.className("[class='name']")).getText().
                    equalsIgnoreCase("Chunky Chips and Aioli")){
                Assertions.assertEquals("3273KJ",sides.findElement(By.className(
                        "kilojoules grey--text text--darken-1 caption")));

                Assertions.assertEquals("9.99",sides.findElements(By.className("price")));

                //Here i want to only get long value of the items
            }
        }

    }




    @Test
    public void clearUp(){
        driver.quit();
    }
}
