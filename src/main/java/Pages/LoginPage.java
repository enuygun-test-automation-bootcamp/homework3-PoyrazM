package Pages;

import DriverSet.DriverSetUp;
import LocatorContainers.LoginPageContainer;

public class LoginPage extends DriverSetUp {

    public void checkLoginButton(){
        /*
            Eğer geldiğim urlde giriş yap butonu bulunuyorsa ona tıkla işlemi yaparım. isEnabled komutumdan dönecek
            true veya false response'una göre doğrulama yapılır.
         */

        boolean loginButtonIsEnabled = chromeDriver.findElement(LoginPageContainer.loginButton).isEnabled();
        if (loginButtonIsEnabled == true)
        {
            chromeDriver.findElement(LoginPageContainer.loginButton).click();
            System.out.println("PASSED \t:Login Button successfully clicked in the Chrome Browser");
        } else
        {
            System.out.println("FAIL \t:Not clicked the login button in the Chrome Browser");
        }

        loginButtonIsEnabled = firefoxDriver.findElement(LoginPageContainer.loginButton).isEnabled();
        if (loginButtonIsEnabled == true)
        {
            firefoxDriver.findElement(LoginPageContainer.loginButton).click();
            System.out.println("PASSED \t:Login Button successfully clicked in the Firefox Browser");
        } else
        {
            System.out.println("FAIL \t:Not clicked the login button in the Firefox Browser");
        }

        loginButtonIsEnabled = edgeDriver.findElement(LoginPageContainer.loginButton).isEnabled();
        if (loginButtonIsEnabled == true)
        {
            edgeDriver.findElement(LoginPageContainer.loginButton).click();
            System.out.println("PASSED \t:Login Button successfully clicked in the Edge Browser");
        } else
        {
            System.out.println("FAIL \t:Not clicked the login button in the Edge Browser");
        }
    }


    public void verifiedLogin(String email , String password){
        /*
        Giriş yap butonuna tıkladım ve karşıma mail adresi ve şifre göndereceğim yeni bir sayfa çıktı
        ve orada dönen Giriş Yap textinin doğrulamasını yaparak , eğer Giriş Yap yazıyorsa sendKeys kullanarak
        email ve password gönderilir aksi durumda test başarısız yani failed olur.
     */

        String verifyTexts = chromeDriver.findElement(LoginPageContainer.verifiedLoginText).getText();
        if (verifyTexts.equals("Giriş Yap"))
        {
            chromeDriver.findElement(LoginPageContainer.loginEmail).sendKeys(email);
            chromeDriver.findElement(LoginPageContainer.loginPassword).sendKeys(password);
            System.out.println("PASSED \t:Email and password successfully wrote for Chrome Browser");
        }else
        {
            System.out.println("FAILED \t:Email and password NOT successfully wrote for Chrome Browser");
        }


        verifyTexts = firefoxDriver.findElement(LoginPageContainer.verifiedLoginText).getText();
        if (verifyTexts.equals("Giriş Yap"))
        {
            firefoxDriver.findElement(LoginPageContainer.loginEmail).sendKeys(email);
            firefoxDriver.findElement(LoginPageContainer.loginPassword).sendKeys(password);
            System.out.println("PASSED \t:Email and password successfully wrote for Firefox Browser");
        }else
        {
            System.out.println("FAILED \t:Email and password NOT successfully wrote for Firefox Browser");
        }


        verifyTexts = edgeDriver.findElement(LoginPageContainer.verifiedLoginText).getText();
        if (verifyTexts.equals("Giriş Yap"))
        {
            edgeDriver.findElement(LoginPageContainer.loginEmail).sendKeys(email);
            edgeDriver.findElement(LoginPageContainer.loginPassword).sendKeys(password);
            System.out.println("PASSED \t:Email and password successfully wrote for Edge Browser");
        }else
        {
            System.out.println("FAILED \t:Email and password NOT successfully wrote for Edge Browser");
        }
    }

    public void verifiedMUILoginButton(){
        /*
        Burada email ve password keylerimi gönderdikten sonra bulunduğum sayfadaki giriş yap butonu testi yaparım
        orada bulunuyorsa tıkla komutu gönderip , aksi durumda fail döndürmesini isterim.
         */
        boolean muiButton = chromeDriver.findElement(LoginPageContainer.muiLoginButton).isDisplayed();
        if (muiButton == true)
        {
            chromeDriver.findElement(LoginPageContainer.muiLoginButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Login Button for Chrome Browser");
        }else
        {
            System.out.println("FAILED \t:NOT clicked the Mui Login Button for Chrome Browser");
        }


        muiButton = firefoxDriver.findElement(LoginPageContainer.muiLoginButton).isDisplayed();
        if (muiButton == true)
        {
            firefoxDriver.findElement(LoginPageContainer.muiLoginButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Login Button for Firefox Browser");
        }else
        {
            System.out.println("FAILED \t:NOT clicked the Mui Login Button for Firefox Browser");
        }


        muiButton = edgeDriver.findElement(LoginPageContainer.muiLoginButton).isDisplayed();
        if (muiButton == true)
        {
            edgeDriver.findElement(LoginPageContainer.muiLoginButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Login Button for Edge Browser");
        }else
        {
            System.out.println("FAILED \t:NOT clicked the Mui Login Button for Edge Browser");
        }
    }
}
