package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C05_Project {
    //     * Navigate to  https://www.saucedemo.com/
    //     * Enter the user name  as standard_user
    //     * Enter the password as   secret_sauce
    //     * Click on login button
    //     * Choose price low to high
    //     * Verify item prices are sorted from low to high

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

        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement dropDown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropDown);
        select.selectByValue("lohi");


        List<WebElement> websiteProductPriceList=driver.findElements(By.className("inventory_item_price"));
        List<String> productPriceString=new ArrayList<>();
        List<Double> productPriceDouble=new ArrayList<>();

        websiteProductPriceList.stream().forEach(t->productPriceString.add(t.getText()));


        for (int i = 0; i <productPriceString.size() ; i++) {
            productPriceDouble.add(Double.parseDouble(productPriceString.get(i).replace("$","")));
        }

        for (int i = 1; i < productPriceDouble.size() ; i++) {
            if (productPriceDouble.get(i-1)<=productPriceDouble.get(i)){
                System.out.println("Test PASS");
            }else{
                System.out.println("Test FAILED");
            }
        }
    }

    @AfterClass
    public void tearDown(){
         driver.close();
    }
}
