package tests.Practise;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataProviderTest {


    @DataProvider
    public  Object[][] getData() {

        Object [][] data={
                {"Muhammet","123"},
                {"Murat","asd"},
                {"Kubilay","1q2w"}
        };

        return  data;
    }

    @Test(dataProvider = "getData")
    public void UserNameTest(String username,String password) {

        System.out.println("username : "+username+" " + " password : "+password );

    }


//--------------------------------------------------------------------------------------------------


    @DataProvider
    public Iterator<Object> getData2() {

        List<Object> data2=new ArrayList<>();
        data2.add("Merve");
        data2.add("Esra");
        data2.add("Hakan");

        return  data2.iterator();
    }

    @Test(dataProvider = "getData2")
    public void UserNameTest2(String username) {

        System.out.println("username : "+username );

    }







}
