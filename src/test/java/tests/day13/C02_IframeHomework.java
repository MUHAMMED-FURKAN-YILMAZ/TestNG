package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_IframeHomework extends TestBase {

    //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");


        driver.switchTo().frame(0);
        driver.findElement(By.linkText("Our Products")).click();

        driver.findElement(By.xpath("//p[text()='Cameras']")).click();

        Thread.sleep(2000);

        WebElement popup= driver.findElement(By.xpath("//div[@class='modal-body']"));
        Thread.sleep(2000);

        System.out.println("***"+popup.getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Close']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        String actualURL= driver.getCurrentUrl();
        String expectedURL="http://webdriveruniversity.com/index.html";

        Assert.assertEquals(actualURL,expectedURL,"actual URL-Expected URL does not equals");

    }

}
