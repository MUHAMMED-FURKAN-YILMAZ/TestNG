package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C05_WebAppSecurity {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.navigate().to("http://zero.webappsecurity.com/");
    }

    @Test
    public void test1() {
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.linkText("zero.webappsecurity.com sitesine ilerle (güvenli değil)")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        }


        @Test(dependsOnMethods = "test1")
    public void test2(){
            //8. “Currency” drop down menusunden Eurozone’u secin
            WebElement dropDown= driver.findElement(By.id("pc_currency"));
            Select select=new Select(dropDown);
            select.selectByValue("EUR");

            //9. “amount” kutusuna bir sayi girin
            driver.findElement(By.id("pc_amount")).sendKeys("1234");

            //10. “US Dollars” in secilmedigini test edin
            WebElement checkBox= driver.findElement(By.id("pc_inDollars_true"));
            Assert.assertFalse(checkBox.isSelected(),"CheckBox tikli");


            //11. “Selected currency” butonunu secin
            driver.findElement(By.id("pc_inDollars_false")).click();

            //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
            driver.findElement(By.id("pc_calculate_costs")).click();
            driver.findElement(By.id("purchase_cash")).click();

            //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
            String actualWord=driver.findElement(By.id("alert_content")).getText();
            String expectedWord="Foreign currency cash was successfully purchased.";
            Assert.assertEquals(actualWord,expectedWord,"Test FAILED");
        }

        @AfterClass
    public void tearDown(){
        driver.close();
        }


}
