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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {

    // Verify edin dendiginde soft assert'tur..-> convention'i budur
    // test edin dendiginde ise hard assert'tur

// burada 2 hata vermesine ragmen teste devam ediyor. hard assert gibi kodu break etmiyor

    // amazon sayfasina gidin
    //URL'in amazon icerdigini test edin,
    // title'in amazon icerdigini test edin
    //java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini test edin

    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        SoftAssert softAssert=new SoftAssert();

        // amazon sayfasina gidin
        //URL'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"URL amazon icermiyor");

        System.out.println("assertion failed oldugunda bu satir calisir");

        //title'in amazon icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"Title amazon icermiyor");

        //java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        WebElement firstProduct= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(firstProduct.getText().contains("java"),"ilk urun java icermiyor");

        softAssert.assertAll();
// assertion'lar pass olsa da olmasa da assertAll'a kadar tum satirlar calisir
// ama eger testlerden bir tanesi bile failed ise assertAll()'dan sonra execution stop

        System.out.println("assertion failed oldugunda bu satir assertAll()'dan sonra oldugu icin artik calismaz");

    }
//assertAll()'dan sonra o methodu calistirmamasina ragmen @afterclass'i calistirdi
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
