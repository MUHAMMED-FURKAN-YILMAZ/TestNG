package tests.Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test3 {
    // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropDown() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement dropdownGun=driver.findElement(By.cssSelector("#day"));
        Select select1=new Select(dropdownGun);

        List<WebElement> daySecenekler=select1.getOptions();
        System.out.println("============== GUNLER ================");
        for (WebElement each: daySecenekler) {
            System.out.println(each.getText());
        }


        WebElement dropdownAy=driver.findElement(By.cssSelector("#month"));
         select1=new Select(dropdownAy);
        List<WebElement> monthSecenekler=select1.getOptions();
        System.out.println("============== AYLAR ================");
        for (WebElement each: monthSecenekler) {
            System.out.println(each.getText());
        }

        WebElement dropdownYil=driver.findElement(By.cssSelector("#year"));
         select1=new Select(dropdownYil);
        List<WebElement> yearSecenekler=select1.getOptions();
        System.out.println("============== YILLAR ================");
        for (WebElement each: yearSecenekler) {
            System.out.println(each.getText());
        }


    }


}
