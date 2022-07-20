import DriverSet.DriverSetUp;
import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.NoSuchElementException;

import static DriverSet.DriverSetUp.*;

public class SignUpTest {
      /*
        Test yapacağım pageleri oluşturdum ve sıra geldi onları uygulamaya , Test sayfamda oluşturduğum classlarımdaki
        kullanacağım metotları çağırmak için Composition ve new Object özelliğinden yararlanırım. Bu şekilde
        benim testim bakımı kolay ve tek bir yerde belki de 1000lerce satır kod yazmaktan ve testimi spagetti koda çevirmekten
        kurtulurum.
        Kullanacağım metotları çağırıp sırasıyla test koşumu gerçekleştiririm.
        Sign Up testim için kullanacağım objeler çağıralarak metotlarını koşmasını söylerim Java'ya.
         */

    public static void main(String[] args) {
        DriverSetUp.open("https://www.enuygun.com/");
        String checkOpenWebsite = chromeDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/")){
            System.out.println("PASSED \t:Chrome browser is in the true Website");
        }else {
            System.out.println("FAILED \t:Chrome Browser is not in the true Website");
        }

        checkOpenWebsite = firefoxDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/")){
            System.out.println("PASSED \t:Firefox browser is in the true Website");
        }else {
            System.out.println("FAILED \t:Firefox Browser is not in the true Website");
        }


        checkOpenWebsite = edgeDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/")){
            System.out.println("PASSED \t:Edge browser is in the true Website");
        }else {
            System.out.println("FAILED \t:Edge Browser is not in the true Website");
        }

        SignUpPage sign = new SignUpPage();
        try
        {
            sign.checkSignUpBtn();
            sign.verifiedSignUp("test123@gmail.com", "123456");
            sign.verifiedMUISignUpButton();
        }catch (NoSuchElementException e)
        {
            System.out.println("ELEMENT IS NOT FINDING INSIDE SIGN UP PAGE CONTAINER ; WHICH ELEMENT \t:" +e.getMessage());
        }
        HomePage homePage = new HomePage();

        try {
            homePage.verifiedLoggedIn();
        }catch (NoSuchElementException e)
        {
            System.out.println("ELEMENT IS NOT FINDING INSIDE HOME PAGE CONTAINER ; WHICH ELEMENT \t:" +e.getMessage());
        }


        DriverSetUp.tearDown();
    }
}
