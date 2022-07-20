package UserGmailStartChrome;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UserBrowser {

    public static void main(String[] args) {
        // Burada kullanacağım driverı , içinde bulunduğu dosyadan çekebilmek için Path kütüphanesinden yararlanılıp driver'ın
        // Path konumunu tanımlarız. Propertyde ise kullanacağımız driverı seçeriz. Burada chrome driver kullanıldı.
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.setProperty("webdriver.chrome.driver",absolutePath+"/binary/chromedriver.exe");


        // Selenium kütüphanesinin ChromeOptions özelliği kullanılarak , driverımın başlarken nasıl başlaması gerektiğini
        // tanımlamak istediğim durumlarda gerekli tanımlamalar yapılır.
        ChromeOptions options = new ChromeOptions();

        /*
            Daha sonrasında chrome browserı kendi gmail hesabımla başlatmak için , kullanıcı datamın pathini gösteririm
            Ürettiğim ChromeDriver objesine bu özellikle başlaması için options tanımlaması yapıp , Enuygun'un sitesini açarım
        */

        // Syntax = "user-data-dir=C:/Users/username/AppData/Local/Google/Chrome/User Data"
        options.addArguments("user-data-dir=C:/Users/mertc/AppData/Local/Google/Chrome/User Data");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.enuygun.com/");

    }
}
