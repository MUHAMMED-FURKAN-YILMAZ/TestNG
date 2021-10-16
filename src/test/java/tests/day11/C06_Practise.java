package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Practise extends TestBase {

    /*
    Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
*/

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverFirst= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));

        actions.moveToElement(hoverFirst).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert']")).click();
// bu xpath'den 4 tane olsa bile uzerine gelmeden cikmadigi icin index vermeye gerek yok...

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        Thread.sleep(2000);

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();


    }









}
