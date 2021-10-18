package tests.day12;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C03_MentoringProject extends TestBase {

     /*
      go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window

     */

    @Test
    public void test(){
        driver.get("http://demo.guru99.com/popup.php");

        String firstWindowHandle= driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> windowHandles=driver.getWindowHandles();

        String secondWindowHandle="";
        for (String w: windowHandles) {
            if (!w.equals(firstWindowHandle)){
                secondWindowHandle=w;
            }
        }


        driver.switchTo().window(secondWindowHandle);

        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();


        SoftAssert softAssert=new SoftAssert();

        String actualText=driver.findElement(By.tagName("h3")).getText();
        String expectedText="This access is valid only for 20 days.";

        softAssert.assertEquals(actualText,expectedText,"Actual text does not equals expected text");
        softAssert.assertAll();

        driver.switchTo().window(firstWindowHandle);

    }
}
