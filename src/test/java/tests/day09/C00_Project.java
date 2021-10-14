package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C00_Project extends TestBase {

    ////go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //       //maximize the web site
    //       //click on second emoji
    //       //click all second emoji's element
    //       //go back parent iframe
    //       //fill out the form,(Fill the form with the texts you want)
    //       //click on apply button

    @Test
    public void test() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement> allEmojiesOf2=driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));

        allEmojiesOf2.stream().forEach(t->t.click());

        driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent();

        List<WebElement> inputSystem=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        //inputSystem.get(0).sendKeys("selenium");
        //inputSystem.get(1).sendKeys("eagle");
        //inputSystem.get(2).sendKeys("sea");
        //inputSystem.get(3).sendKeys("meat");
        //inputSystem.get(4).sendKeys("football");
        //inputSystem.get(5).sendKeys("home");
        //inputSystem.get(6).sendKeys("Computer");
        //inputSystem.get(7).sendKeys("Brain");
        //inputSystem.get(8).sendKeys("Turkey Flag");
        //inputSystem.get(9).sendKeys("----");
        //inputSystem.get(10).sendKeys("*******");

        List<String> info=new ArrayList<>(Arrays.asList("selenium","eagle","sea","meat","football","home","Computer","Brain","Turkey Flag","----","*******"));
        for (int i = 0; i <info.size() ; i++) {
            inputSystem.get(i).sendKeys(info.get(i));
        }


        driver.findElement(By.id("send")).click();


    }

}
