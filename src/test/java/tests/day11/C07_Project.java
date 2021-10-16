package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C07_Project extends TestBase {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

        Thread.sleep(1500);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("'TechProEducation' Muhammed Furkan");
        driver.switchTo().alert().accept();

        String print= driver.findElement(By.id("demo1")).getText();
        String expectedWord="Hello 'TechProEducation' Muhammed Furkan How are you today";
        Assert.assertEquals(print,expectedWord,"message does not contains expected word");

    }


}
