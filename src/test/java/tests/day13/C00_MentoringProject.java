package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C00_MentoringProject extends TestBase {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

    Methods
        clickAllElements
        getName
        compareTwoList
     */

    List<String> phoneBrandNameStr=new ArrayList<>();
    List<String> totalAddedCartButtonInProductStr=new ArrayList<>();

    @Test
    public void clickAllElementsAndGetName(){
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        driver.findElement(By.linkText("Phones & PDAs")).click();

        List<WebElement> phoneBrandName=driver.findElements(By.tagName("h4"));
        phoneBrandName.stream().forEach(t->phoneBrandNameStr.add(t.getText()));

        List<WebElement> addToCart=driver.findElements(By.xpath("//span[text()='Add to Cart']")); //By.xpath("//button[contains(@onclick,'cart.add')]")
        addToCart.stream().forEach(t->t.click());

      WebDriverWait wait=new WebDriverWait(driver,10);
      WebElement totalCart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id= 'cart-total']")));
      totalCart.click();

      List<WebElement> totalAddedCartButtonInProduct=driver.findElements(By.xpath("//td[@class='text-left']"));
      totalAddedCartButtonInProduct.stream().forEach(t->totalAddedCartButtonInProductStr.add(t.getText()));

  }

    @Test (dependsOnMethods = "clickAllElementsAndGetName")
    public void compareTwoList(){

        Collections.sort(phoneBrandNameStr);
        Collections.sort(totalAddedCartButtonInProductStr);

        System.out.println("phoneBrandNameStr "+phoneBrandNameStr);
        System.out.println("totalAddedCartButtonInProductStr = " + totalAddedCartButtonInProductStr);

        Assert.assertEquals(phoneBrandNameStr,totalAddedCartButtonInProductStr,"lists does not equals");
    }

}
