package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_Iframe {

    //● Bir class olusturun: C02_IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    //  ● Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() {
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
        WebElement baslikYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYaziElementi.isEnabled(),"Baslik yazisi erisilebilir degil");
        System.out.println(baslikYaziElementi.getText());


        // ○ Text Box’a “Merhaba Dunya!” yazin.

        driver.switchTo().frame(0); // index ile, en hizlisi
        //driver.switchTo().frame("mce_0_ifr");// string ile ->id

       // WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframe); --> webEelement ile
        WebElement articleBox= driver.findElement(By.xpath("//*[@id='tinymce']"));


        articleBox.clear();
        articleBox.sendKeys("Merhaba Dunya");

// bir iframe'e gecis yaptiktan sonra yeniden anasayfa ile ilgili islem yapmak isterseniz
// gecis yaptiginiz iframe'den geri donmeliyiz 2 yol var
// 1- driver.switchTo().parentFrame(),
// 2- driver.switchTo().defaultContent()

        driver.switchTo().defaultContent();


        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin
        WebElement elementalLink= driver.findElement(By.linkText("Elemental Selenium"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(elementalLink.isDisplayed(),"elemenatal Selenium does not disabled website");

        softAssert.assertAll();

        System.out.println(elementalLink.getText());
    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
