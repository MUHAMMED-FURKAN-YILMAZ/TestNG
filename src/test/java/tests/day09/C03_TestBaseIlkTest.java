package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    // 2 yontem var
    // 1- obje create ederek
    // 2- extends ederek

    @Test
    public void test(){
    driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }
}
