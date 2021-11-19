package tests.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import utilities.TestBase;

public class DataProvider02 extends TestBase {
    /*
@DataProvider bir TestNG annotation’idir.
Dolayisiyla sadece TestNG ile kullanilir.
Veri sağlamak için kullanılır.
DDT (Data Driven Test) yapilir
Cucumber’daki Scenario Outline ile ayni isleve sahiptir
 */
    public class DataProviderTest extends TestBase {
        // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
        // login yapiniz Email: asd@gmail.com   password : 123qweasd
        // Search fonksiyonunu kullanarak
        // Mac,ipod ve samsung icin Dataprovider ile yapınız.
        @Test(dataProvider = "getData")
        void SearchFunction(String txtSearch) throws InterruptedException {
            driver.get("http://opencart.abstracta.us/index.php?route=account/login");
            WebElement inputEmail = driver.findElement(By.id("input-email"));
            inputEmail.sendKeys("asd@gmail.com");
            WebElement password = driver.findElement(By.id("input-password"));
            password.sendKeys("123qweasd");
            WebElement login = driver.findElement(By.cssSelector("input[value='Login']"));
            login.click();
            WebElement gelismis = driver.findElement(By.id("details-button"));
            gelismis.click();
            Thread.sleep(2000);
            WebElement link = driver.findElement(By.id("proceed-link"));
            link.click();
            Thread.sleep(2000);
            WebElement searchArea = driver.findElement(By.xpath("//input[@name='search']")); // full xpath:  /html/body/header/div/div/div[2]/div/input
            searchArea.clear();
            searchArea.sendKeys(txtSearch);
            WebElement searchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));  //#search > span > button
            searchBtn.click();
            List<WebElement> productList = driver.findElements(By.cssSelector("h4>a"));
            for (WebElement macs : productList) {
                Assert.assertTrue(macs.getText().toLowerCase().contains(txtSearch.toLowerCase()));
            }
        }

        @DataProvider // bu metoda dataprovider gorevi verildi.
        public Object[] getData() // DataProvider olarak kullanilcak metodun tipi Object olmak zorundir
        {
            Object[] data = {"Mac", "ipod", "samsung"};
            return data;
        }

    }
}
