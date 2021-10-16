package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

// abstract yaparak bu class'tan obje olusturulmasinin onune geceriz
// yani diger class'lardan TestBase testBase=new TestBase();-> seklinde obje olusturulmasinin onune geceriz




// public : herkes ulasabilir
// protected : ayni package veya child class
// default ( bir sey yazmayinca da default kabul edilir) : package private
// private : sadece class icinde kullanabiliriz

// Biz test base class'i sadece extends ile inherit ederek kullanacagiz
// dolayisi ile olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz

    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
