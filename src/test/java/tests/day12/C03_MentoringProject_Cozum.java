package tests.day12;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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

public class C03_MentoringProject_Cozum {
    WebDriver driver;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws InterruptedException {
        //go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //get the first window
        String firstWindowHandle=driver.getWindowHandle();
        System.out.println("firstWindow : "+firstWindowHandle);

        //   clicking on click here button
        driver.findElement(By.linkText("Click Here")).click();

        //  get all the window in the set
        Set<String> windowHandles=driver.getWindowHandles();

        String secondWindowHandle="";
        for (String w: windowHandles) {
            if (!w.equals(firstWindowHandle)){
                secondWindowHandle=w;
            }
        }


        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(2000);

        // Clicking on the submit button
        driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys("somepne@gmail.com"+ Keys.ENTER);

        // verify title as expected
        SoftAssert softAssert= new SoftAssert(); //-->test edin diyorsa hard assertion, verify diyorsa soft assertion
        String actualText=driver.findElement(By.tagName("h3")).getText();
        String expectedText="This access is valid only for 20 days.";

        softAssert.assertEquals(actualText,expectedText,"Actual text does not equals expected text");
        softAssert.assertAll();

        driver.switchTo().window(firstWindowHandle);

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
