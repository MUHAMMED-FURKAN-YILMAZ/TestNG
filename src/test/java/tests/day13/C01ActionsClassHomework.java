package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01ActionsClassHomework extends TestBase {

    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin

    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/Actions");

        Actions actions=new Actions(driver);

        WebElement hoverOverMeFirst= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOverMeFirst).perform();

        WebElement link1= driver.findElement(By.className("list-alert"));
// Bu locater'dan 4 tane olmasina ragmen hover olmadan digerleri cikmadigi icin bu sekilde yapabildim

        actions.click(link1).perform();

        System.out.println("Popup message " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        System.out.println("Click and hold message-> "+clickAndHold.getText());

        WebElement doubleClick=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

    }


}
