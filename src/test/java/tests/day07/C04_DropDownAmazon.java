package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C04_DropDownAmazon {

    //● Bir class oluşturun: C04_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com/");
    }

    //- Test 1
    @Test(priority = 1)
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori
        //sayisinin 45 oldugunu test edin
        WebElement categoryBox= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(categoryBox);
        List<WebElement> categoryBoxList= select.getOptions();
        Assert.assertEquals(categoryBoxList.size(),45,"Category box size does not equals 45");
            // 45 olmadigi icin burada hata almaliyiz
    }

    //-Test 2
    @Test(priority = 2)
    public void test2() throws InterruptedException {
    //1. Kategori menusunden Books secenegini secin
        WebElement categoryBox= driver.findElement(By.id("searchDropdownBox"));
        Select select= new Select(categoryBox);
        select.selectByVisibleText("Books");
        Thread.sleep(2000);


    //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+Keys.ENTER);

    //3. Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String containsWord="Java";
        Assert.assertTrue(driver.getTitle().contains(containsWord),"Title does not contains Java");
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
