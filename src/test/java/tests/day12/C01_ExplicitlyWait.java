package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {

    @Test
    public void implicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.id("message"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());

        softAssert.assertAll();

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //7. It’s back mesajinin gorundugunu test edin
        sonucYazisi=driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYazisi.isDisplayed());
    }

    @Test
    public void explicitWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebDriverWait wait=new WebDriverWait(driver,20);

// explicitly wait'i istersek locate islemi ile birlikte tek satirda yapabiliriz
        WebElement yaziLocateIleBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(yaziLocateIleBirlikte.isDisplayed());


// veya once locate edip uygun method kullanarak eklemeyi yapabiliriz
// ancak bu test icin once webElementi olusturmak anlamsiz olur cunku
// biz wait islemini zaten o webelement olussun diye yapiyoruz wait olmadan
// o element olmaz , o element olmadan da sectigimiz method calismaz
        /*
        WebElement sonucYazisi=driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
            */

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());
    }


}
