package Pages;

import DriverSet.DriverSetUp;
import LocatorContainers.HomePageContainer;

public class HomePage extends DriverSetUp {
    /*
     Eğer logintest veya signuptest başarılı olursa beni anasayfaya atar ve onu doğrulamak için
     sağ üstte bulunan kullanıcı adını kontrol ederek doğrulama işlemi yaparım. Eğer text beklediğim gibi dönerse
     başarıyla login veya sign up yapmışımdır.
    */
    public void verifiedLoggedIn(){
        String verifiedLoggedInText = chromeDriver.findElement(HomePageContainer.userNameText).getText();
        System.out.println("Username is \t:"+verifiedLoggedInText);
        if (verifiedLoggedInText.equals("test123")){
            System.out.println("PASSED \t:Successfully logged in for Chrome Browser");
        }else {
            System.out.println("FAILED \t:NOT successfully logged in for Chrome Browser");
        }

        verifiedLoggedInText = firefoxDriver.findElement(HomePageContainer.userNameText).getText();
        if (verifiedLoggedInText.equals("test123")){
            System.out.println("PASSED \t:Successfully logged in for Firefox Browser");
        }else {
            System.out.println("FAILED \t:NOT successfully logged in for Firefox Browser");
        }

        verifiedLoggedInText = edgeDriver.findElement(HomePageContainer.userNameText).getText();
        if (verifiedLoggedInText.equals("test123")){
            System.out.println("PASSED \t:Successfully logged in for Edge Browser");
        }else {
            System.out.println("FAILED \t:NOT successfully logged in for Edge Browser");
        }
    }
}
