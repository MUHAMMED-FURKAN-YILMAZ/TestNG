package tests.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Test8 extends TestBase {

// http://the-internet.herokuapp.com/add_remove_elements/
// click on the "Add Element" button 100 times
// write a function that takes a number, and clicks the "Delete" button
// given number of times, and then validates that given number of
// buttons was deleted


    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(100);
        deleteButtonValidate(90);
    }

    private void createButtons(int numberOfButtonToAdd) {
        WebElement button = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < numberOfButtonToAdd; i++) {
            button.click();
        }
    }


    private void deleteButtonValidate (int number){
        List<WebElement> deleteElements=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int size=deleteElements.size();

        List<WebElement> removeDeleteButtons = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int count=0;

        for(WebElement w : removeDeleteButtons){
            count++;

            if (count > number){
                break;
            }
            w.click();
        }

        List<WebElement> elementAfter = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeAfterDelete=elementAfter.size();

        if ((size-number)==sizeAfterDelete){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }






}
