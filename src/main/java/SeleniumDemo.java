import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    public static WebDriver driver = null;

    @Test
    public void getDriver() {

        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("search_query_top")).sendKeys("dress", Keys.ENTER);
        String text = driver.findElement(By.className("product-count")).getText();
        Assert.assertEquals(text, "Showing 1 - 7 of 7 items");
    }

    @Test
    public void clickSignIn() {

        driver.findElement(By.className("login")).click();

    }
        @AfterMethod
        public void tearDown () {
            driver.close();
        }

}