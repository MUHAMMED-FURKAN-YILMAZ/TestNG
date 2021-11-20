package tests.Practise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test9_Homework2 extends TestBase {

    @Test
    public void setUp() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor jsExecutrer = (JavascriptExecutor) driver;

        WebElement aramaKutusu = (WebElement) jsExecutrer.executeScript("return document.querySelector(\"body > book-app\")." +
                "shadowRoot.querySelector(\"#input\")");

        aramaKutusu.sendKeys("Basitmis degil mi?");

        Thread.sleep(3000);
    }
}
