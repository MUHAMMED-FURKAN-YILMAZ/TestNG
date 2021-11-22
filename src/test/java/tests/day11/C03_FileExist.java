package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C03_FileExist  {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home")); //C:\Users\user
        // "C:\Users\user\Desktop\picture.jpg"

        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        //      dosya yolunu ikiye ayiracagiz
        // 1. herkesin bilgisayarinda farkli olan kisim
        //    bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. herkes icin ayni olan kisim
        //    bu kisim 1.maddedeki yolun devami seklinde olur

        // ornek masaustumuzdeki picture dosyasi icin yol kaydedelim
        String dosyaYoluDinamik = System.getProperty("user.home")+ "\\Desktop\\picture.jpg";

        String dosyaYoluManuel="C:\\Users\\user\\Desktop\\picture.jpg";

        System.out.println("dosya yolumuz : "+dosyaYoluDinamik);

        System.out.println(Files.exists (Paths.get (dosyaYoluDinamik)));

        Assert.assertTrue(Files.exists (Paths.get (dosyaYoluDinamik)));


        System.out.println(System.getProperty("user.dir"));//->bu kodu yazdigim icinde oldugumuz dosya yolunu verir
    }
}