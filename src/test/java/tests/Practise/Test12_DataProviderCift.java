package tests.Practise;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test12_DataProviderCift extends TestBase {


    @DataProvider
    public static Object[][] signInTest() {
        Object[][] gmiBankData= new Object[2][2];
        // Object gmibankData [][] = {
        //            {"username1@gmail.com","password1"},
        //            {"username2@gmail.com","password2"},
        //
        //    };

        gmiBankData [0][0]="username1@gmail.com";
        gmiBankData [0][1]="password1";
        gmiBankData [1][0]="username2@gmail.com";
        gmiBankData [1][1]="password1";

        return  gmiBankData;
    }

    @Test(dataProvider = "signInTest")
    public void test(String username, String password) throws InterruptedException {
        driver.get("https://www.gmibank.com");

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

    }
}
