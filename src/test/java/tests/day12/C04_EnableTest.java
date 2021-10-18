package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_EnableTest  extends TestBase {

    @Test
    public void isEnabled(){
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"Text box is enable");



        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));

        enableButton.click();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6. “It's enabled!” mesajinin goruntulendigini dogrulayın.
        String expectedMessage="It's enabled!";
        String message=driver.findElement(By.id("message")).getText();
        softAssert.assertEquals(message,expectedMessage,"Message does not equals expected message");

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        softAssert.assertTrue(textBox.isEnabled(),"Text box does not enabled");

        softAssert.assertAll();
    }

}
