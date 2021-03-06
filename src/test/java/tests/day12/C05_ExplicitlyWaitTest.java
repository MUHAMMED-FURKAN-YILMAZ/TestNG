package tests.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_ExplicitlyWaitTest  {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void enableTest() {
        //1. Bir class olusturun : ExplicitlyWaitTest
        //2. Bir metod olusturun : enableTest()
        //3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");

        //4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        Assert.assertFalse(enableAfter.isEnabled(), "Will enable 5 seconds button is enabled");

        //5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
    }

    @Test
    public void  visibleTest(){
        //6. Bir metod olusturun : visibleTest()
        driver.get("https://demoqa.com/dynamic-properties");

        //7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
        //ve gorunur oldugunu test edin
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        WebElement visibleAfter= driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue(visibleAfter.isDisplayed(),"Visible After 5 Seconds button is not displayed");


    }

}
