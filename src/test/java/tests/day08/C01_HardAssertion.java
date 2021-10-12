package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        // amazon sayfasina gidin
        //URL'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //title'in amazon icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("amazon"));
//hard assert oldugu icin ilk failed olan assertion'da execution stop
//ancak buradaki hata duzelirse kod calismaya devam eder

        //java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        WebElement firstProduct= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(firstProduct.getText().contains("Java"));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
