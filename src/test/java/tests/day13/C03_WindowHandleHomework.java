package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandleHomework extends TestBase {

    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/");

        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        String firstWindowHandle= driver.getWindowHandle();
        String secondWindpwHandle="";

        Set<String> allWindowHandles=driver.getWindowHandles();
        for (String w:allWindowHandles) {
            if (firstWindowHandle!=w){
                secondWindpwHandle=w;
            }
        }


        driver.switchTo().window(secondWindpwHandle);

        driver.findElement(By.id("text")).sendKeys("muhammed furkan");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login-button")).click();

        String actualPopupMessage=driver.switchTo().alert().getText();
        String expectedPopupMessage="validation failed";

        Assert.assertEquals(actualPopupMessage,expectedPopupMessage,"Actual popup message does not equals expected popup message");

        driver.switchTo().alert().accept();

        driver.switchTo().window(firstWindowHandle);

        String currentPage=driver.getWindowHandle();

        Assert.assertEquals(firstWindowHandle,currentPage,"Failed to return to first page");

    }

}
