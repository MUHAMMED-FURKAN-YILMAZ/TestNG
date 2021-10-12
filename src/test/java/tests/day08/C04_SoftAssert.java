package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C04_SoftAssert {
    //1.“https://www.hepsiburada.com/” Adresine gidin
    //2.Basliginin “Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com" icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

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
        driver.get("https://www.hepsiburada.com/");

        String actualTitle= driver.getTitle();
        String expectedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        SoftAssert sa=new SoftAssert();
        sa.assertEquals(actualTitle,expectedTitle,"Title istenen metni icermiyor");

        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);

       WebElement resultText=driver.findElement(By.className("category-suggestion-title"));
        System.out.println(resultText.getText());

        sa.assertTrue(resultText.getText().contains("araba"),"sonuc yazisi araba icermiyor");
        sa.assertFalse(resultText.getText().contains("oto"),"sonuc yazisi oto icermiyor");


        sa.assertAll();



    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
