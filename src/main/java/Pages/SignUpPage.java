package Pages;

import DriverSet.DriverSetUp;
import LocatorContainers.SignUpPageContainer;

public class SignUpPage extends DriverSetUp {

    public void checkSignUpBtn(){
           /*
            Eğer geldiğim urlde kayıt ol butonu bulunuyorsa ona tıkla işlemi yaparım. isEnabled komutumdan dönecek
            true veya false response'una göre doğrulama yapılır.
         */
        boolean signUpButtonIsEnabled = chromeDriver.findElement(SignUpPageContainer.signUpButton).isEnabled();
        if (signUpButtonIsEnabled == true){
            chromeDriver.findElement(SignUpPageContainer.signUpButton).click();
            System.out.println("PASSED \t:Sign Up Button successfully clicked in the Chrome Browser");
        }else {
            System.out.println("FAILED \t:Not clicked the sign up button in Chrome Browser");
        }

        signUpButtonIsEnabled = firefoxDriver.findElement(SignUpPageContainer.signUpButton).isEnabled();
        if (signUpButtonIsEnabled == true){
            firefoxDriver.findElement(SignUpPageContainer.signUpButton).click();
            System.out.println("PASSED \t:Sign Up Button successfully clicked in the Firefox Browser");
        }else {
            System.out.println("FAILED \t:Not clicked the sign up button in Firefox Browser");
        }

        signUpButtonIsEnabled = edgeDriver.findElement(SignUpPageContainer.signUpButton).isEnabled();
        if (signUpButtonIsEnabled == true){
            edgeDriver.findElement(SignUpPageContainer.signUpButton).click();
            System.out.println("PASSED \t:Sign Up Button successfully clicked in the Edge Browser");
        }else {
            System.out.println("FAILED \t:Not clicked the sign up button in Edge Browser");
        }
    }
    public void verifiedSignUp(String email , String password){
        /*
        Kayıt Ol butonuna tıkladım ve karşıma mail adresi ve şifre göndereceğim yeni bir sayfa çıktı
        ve orada dönen Enuygun'a Üye Ol textinin doğrulamasını yaparak , eğer Enuygun'a Üye Ol yazıyorsa sendKeys kullanarak
        email ve password gönderilir aksi durumda test başarısız yani failed olur.
     */
        String verifyTexts = chromeDriver.findElement(SignUpPageContainer.verifiedSignUpText).getText();
        System.out.println("SIGN UP TEXT IS \t:"+verifyTexts);
        if (verifyTexts.equals("Enuygun'a Üye Ol")){
            chromeDriver.findElement(SignUpPageContainer.signUpEmail).sendKeys(email);
            chromeDriver.findElement(SignUpPageContainer.signUpPassword).sendKeys(password);
            chromeDriver.findElement(SignUpPageContainer.acceptDiscountButton).click();
            System.out.println("PASSED \t:Email and password successfully wrote for Chrome Browser");
        }else
        {
            System.out.println("FAILED \t::Chrome browser is not sending keys !!");
        }


        verifyTexts = firefoxDriver.findElement(SignUpPageContainer.verifiedSignUpText).getText();
        if (verifyTexts.equals("Enuygun'a Üye Ol")){
            firefoxDriver.findElement(SignUpPageContainer.signUpEmail).sendKeys(email);
            firefoxDriver.findElement(SignUpPageContainer.signUpPassword).sendKeys(password);
            firefoxDriver.findElement(SignUpPageContainer.acceptDiscountButton).click();
            System.out.println("PASSED \t:Email and password successfully wrote for Firefox Browser");
        }else
        {
            System.out.println("FAILED \t:Firefox browser is not sending keys !!");
        }

        verifyTexts = edgeDriver.findElement(SignUpPageContainer.verifiedSignUpText).getText();
        if (verifyTexts.equals("Enuygun'a Üye Ol")){
            edgeDriver.findElement(SignUpPageContainer.signUpEmail).sendKeys(email);
            edgeDriver.findElement(SignUpPageContainer.signUpPassword).sendKeys(password);
            edgeDriver.findElement(SignUpPageContainer.acceptDiscountButton).click();
            System.out.println("PASSED \t:Email and password successfully wrote for Edge Browser");
        }else
        {
            System.out.println("FAILED \t:Edge browser is not sending keys !!");
        }
    }

    public void verifiedMUISignUpButton(){
        /*
        Burada email ve password keylerimi gönderdikten sonra bulunduğum sayfadaki Üye Ol butonu testi yaparım
        orada bulunuyorsa tıkla komutu gönderip , aksi durumda fail döndürmesini isterim.
         */
        boolean verifyMUISignUpBtn = chromeDriver.findElement(SignUpPageContainer.muiSignUpButton).isEnabled();
        if (verifyMUISignUpBtn == true){
            chromeDriver.findElement(SignUpPageContainer.muiSignUpButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Sign Up Button for Chrome Browser");
        }else {
            System.out.println("FAILED \t:NOT clicked the Mui Sign Up Button for Chrome Browser!!");
        }

        verifyMUISignUpBtn = firefoxDriver.findElement(SignUpPageContainer.muiSignUpButton).isEnabled();
        if (verifyMUISignUpBtn == true){
            firefoxDriver.findElement(SignUpPageContainer.muiSignUpButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Sign Up Button for Firefox Browser");
        }else {
            System.out.println("FAILED \t:NOT clicked the Mui Sign Up Button for Firefox Browser!!");
        }

        verifyMUISignUpBtn = edgeDriver.findElement(SignUpPageContainer.muiSignUpButton).isEnabled();
        if (verifyMUISignUpBtn == true){
            edgeDriver.findElement(SignUpPageContainer.muiSignUpButton).click();
            System.out.println("PASSED \t:Successfully clicked the Mui Sign Up Button for Edge Browser");
        }else {
            System.out.println("FAILED \t:NOT clicked the Mui Sign Up Button for Edge Browser!!");
        }
    }
}
