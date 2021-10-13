package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_Alerts {

// her alert JS Alert degildir.
//  Alert ciktiginda sag click yapip incele diyebiliyorsak bu bir HTML alert'tur
// HTML alert'ler siradan webelement'ler olarak locate edilip kullanilabilir
// Sag click yapamiyorsak alert bir JS Alert'tur ve swictTo() kullanilarak handle edilebilir


    // Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    @Test
    public void acceptAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement resultYaziElementi= driver.findElement(By.id("result"));
        String expectedResult="You successfully clicked an alert";
        String actualResult= resultYaziElementi.getText();
        assertEquals(actualResult,expectedResult,"Actual result does not equals expected result");
    }

    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    @Test
    public void dismissAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String unexpectedWord="successfuly";
        WebElement resultYaziElementi= driver.findElement(By.id("result"));
        String actualResult= resultYaziElementi.getText();
        assertFalse(actualResult.contains(unexpectedWord),"result does not contains unexpected word");
    }

    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String name="Muhammed Furkan";
        driver.switchTo().alert().sendKeys(name);// + Keys.ENTER' ile yapabilirdik ama tercih..
        driver.switchTo().alert().accept();

        WebElement resultYaziElementi= driver.findElement(By.id("result"));
        String actualResult= resultYaziElementi.getText();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualResult.contains(name));
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }







}
