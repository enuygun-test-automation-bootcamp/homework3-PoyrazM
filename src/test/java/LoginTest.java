import DriverSet.DriverSetUp;
import Pages.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import static DriverSet.DriverSetUp.*;

public class LoginTest {

    public static void main(String[] args) {
        /*
        Test yapacağım pageleri oluşturdum ve sıra geldi onları uygulamaya , Test sayfamda oluşturduğum classlarımdaki
        kullanacağım metotları çağırmak için Composition ve metotunu kullanacağım classı
        çağırmak için nesne ürettiğim new Object özelliğinden yararlanırım. Bu şekilde
        benim testim bakımı kolay ve tek bir yerde belki de 1000lerce satır kod yazmaktan ve testimi spagetti koda çevirmekten
        kurtulurum.
        Kullanacağım metotları çağırıp sırasıyla test koşumu gerçekleştiririm.
        Login testim için kullanacağım objeler çağıralarak metotlarını koşmasını söylerim Java'ya.
         */
        DriverSetUp.open("https://www.enuygun.com/");
        String checkOpenWebsite = chromeDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/"))
        {
            System.out.println("PASSED \t:Chrome browser is in the true Website");
        }else
        {
            System.out.println("FAILED \t:Chrome browser is not in the true Website");
        }

        checkOpenWebsite = firefoxDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/"))
        {
            System.out.println("PASSED \t:Firefox browser is in the true Website");
        }else
        {
                System.out.println("FAILED \t:Firefox browser is not in the true Website");
        }

        checkOpenWebsite = edgeDriver.getCurrentUrl();
        if (checkOpenWebsite.equals("https://www.enuygun.com/"))
        {
            System.out.println("PASSED \t:Edge browser is in the true Website");
        }else
        {
            System.out.println("FAILED \t:Edge browser is not in the true Website");
        }

        LoginPage login = new LoginPage();

        try
        {
            login.checkLoginButton();
            login.verifiedLogin("test123@gmail.com", "123456");
            login.verifiedMUILoginButton();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("ELEMENT IS NOT FINDING INSIDE LOGIN PAGE CONTAINER ; WHICH ELEMENT \t:" +e.getMessage());
        }
        DriverSetUp.tearDown();
    }
}
