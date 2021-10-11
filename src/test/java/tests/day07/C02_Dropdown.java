package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_Dropdown {

    // dropdown Acilir pencere demektir

    // ************** dropdown= HTML'de select tagi-> interview sorusu*************

    // select tagi varsa=> option vardir
    // option varsa 3 sey onemlidir:
    // 1-)visible text => selectByVisibleText()
    // 2-)index        => selectByIndex()
    // 3-)value        => selectByValue()

    // dropdown'lar icin Select class'i olusturulmus (WebElement gibi) ..



    //Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        Thread.sleep(2000);
        //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown= driver.findElement(By.id("dropdown"));//a. adim dropdown'i locate et
        Select select=new Select(dropDown);//b. adim Select class'ini kullanarakbir obje olustur ve
                    // parametre olarak dta type'i WebElement olan locate ettigimiz webelementi kullan

        select.selectByIndex(1);//c. istedigin option'i select objesi kullanarak sec
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);
        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");//-> string oldugu icin string yazmaliyiz
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);
        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //    4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement>  allOptions= select.getOptions();
        //options.stream().forEach(t-> System.out.println(t.getText())); lambda yontemi
        System.out.println("Tum options listesi");
        for (WebElement w : allOptions) {
            System.out.println(w.getText());
        }

        //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        //Assert.assertEquals(tumOpsiyonlar.size(),4);-> true/false yazdiramayiz

        System.out.println(allOptions.size());
        if (allOptions.size()==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    // odev
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori
    //sayisinin 45 oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

}
