package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C00_Project_Cevap2 extends TestBase {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    //click on second emoji
    //click all second emoji's element
    //go back parent iframe
    //fill out the form,(Fill the form with the texts you want)
    //click on apply button
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame("emoojis");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement emoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emoji)).click();
        List<WebElement> emojies = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        System.out.println("iconlar tiklanacak"); //consolda gormek icin..
        for (WebElement w : emojies
        ) {
            w.click();
            System.out.println("iconlar tiklaniyor"); //consolda gormek icin..
        }
        // emojies.stream().forEach(t -> t.click()); yukardaki for Each yerine yazilabilir
        driver.switchTo().defaultContent();
        List<WebElement> inputList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> inputTexts = new ArrayList<>(Arrays.asList("Bir", "iframe", "sorusu", "bu", "kadar", "eglenceli", "olabilir", "sizce de", "oyle degil mi ?", "", ""));
        for (int i = 0; i < inputList.size(); i++) {
            inputList.get(i).sendKeys((inputTexts.get(i)));
        }
        driver.findElement(By.xpath("//button[@id='send']")).click();
        // driver.findElement(By.id("send")).click();
    }

}

