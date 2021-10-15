package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Project extends TestBase {
    //Go to http://demo.guru99.com/test/drag_drop.html url
    //     Drag and drop the BANK button to the Account section in DEBIT SIDE
    //     Drag and drop the SALES button to the Account section in CREDIT SIDE
    //     Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    //     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE


    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Actions actions=new Actions(driver);
        WebElement bank= driver.findElement(By.id("credit2"));
        WebElement debitSideAccount= driver.findElement(By.id("bank"));
        actions.dragAndDrop(bank,debitSideAccount).perform();
        //li[@class='placeholder']

        Thread.sleep(2000);

        WebElement sales=driver.findElement(By.id("credit1"));
        WebElement creditSideAccount=driver.findElement(By.id("loan"));
        actions.dragAndDrop(sales,creditSideAccount).perform();

        Thread.sleep(2000);

        WebElement first5000=driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement debitSideAmount=driver.findElement(By.id("amt7"));
        actions.dragAndDrop(first5000,debitSideAmount).perform();

        Thread.sleep(2000);

        WebElement second5000=driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement creditSideAmount=driver.findElement(By.id("amt8"));
        actions.dragAndDrop(second5000,creditSideAmount).perform();

    }



}
