package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C05_IframeTest02 extends TestBase {

    ///Bir class olusturun: IframeTest02
    //    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //    //2) sayfadaki iframe sayısını bulunuz.
    //    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-
    //    //project.html) tıklayınız


    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");

        //System.out.println(driver.findElements(By.tagName("iframe")).size());

        List<WebElement> iframeCount=driver.findElements(By.tagName("iframe"));
        System.out.println("This website contains "+iframeCount.size()+" iframes");

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        driver.switchTo().defaultContent();
    }

}
