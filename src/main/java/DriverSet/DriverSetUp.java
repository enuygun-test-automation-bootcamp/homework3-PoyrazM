package DriverSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetUp{
/*
     Ben sürekli her sayfada driver yapıcısı çevirmenin bizi clean code'dan uzaklaştırıp , sürekli kod tekrarı yaptırdığı düşüncesindeyim
     Bu yüzden oluşturduğum driver'ı yapıcı döndürmeden bir kere üretip her yerde kullanmak istediğim için
     public static tanımlamasını yaparım. Hem her yerden erişebilirim , hem de static metotların içinde çağırabilirim.
*/
    public static WebDriver chromeDriver;
    public static WebDriver firefoxDriver;
    public static WebDriver edgeDriver;

    /*
            Burada open metotu içerisinde ; Utility classında tanımlanan optionslarla birlikte driverlarımı üretirim ve test classımda
            open metotu kullanılarak gönderilen url keyime göre istenilen siteye giderim.
    */

    public static void open(String url){
        try {
                Utility.setDriverProps(DriverType.CHROME);
                chromeDriver = new ChromeDriver(Utility.setChromeOptions(false));
                chromeDriver.get(url);

                Utility.setDriverProps(DriverType.FIREFOX);
                firefoxDriver = new FirefoxDriver(Utility.setFirefoxOptions());
                firefoxDriver.get(url);
                firefoxDriver.manage().window().maximize();

                Utility.setDriverProps(DriverType.EDGE);
                edgeDriver = new EdgeDriver(Utility.setEdgeOptions());
                edgeDriver.get(url);

        }catch (IllegalStateException e){
            System.out.println("PLEASE ADD DRIVER !!!" +e.getMessage());
        }
    }

    // Driverlarım eğer test sonunda çalışır halde ise yani null değil ise onları kapat tanımlaması yaparım.
    public static void tearDown(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
        if(edgeDriver != null){
            edgeDriver.quit();
        }
    }
}
