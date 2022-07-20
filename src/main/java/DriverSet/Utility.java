package DriverSet;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utility {

    // Browserımın başlatma özelliklerimi tanımlayarak , driverlarımın içine yerleştiririm.
    static String[] args = {"start-maximized","--disable-notifications"};

    public static ChromeOptions setChromeOptions(boolean headless){

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(headless);
        options.addArguments(args);
        return options;
    }

    public static FirefoxOptions setFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return options;
    }

    public static EdgeOptions setEdgeOptions(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments(args);
        return options;
    }

    // Burada istenilen driverım hangisiyse ona göre binary pathinde bulunan driver execute konumları tanımlanmıştır.

    public static void setDriverProps(Enum driverType){
        try {
            Path resourceDirectory = Paths.get("src", "main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();

            if (driverType.equals(DriverType.CHROME)){
                System.setProperty("webdriver.chrome.driver",absolutePath+"/binary/chromedriver.exe");
        }
            else if (driverType.equals(DriverType.FIREFOX)){
                System.setProperty("webdriver.gecko.driver",absolutePath+"/binary/geckodriver.exe");
        }
            else if (driverType.equals(DriverType.EDGE)) {
                System.setProperty("webdriver.edge.driver",absolutePath+"/binary/msedgedriver.exe");
        }
            }catch (InvalidArgumentException e) {
            System.out.println("DID NOT FIND ABSOLUTE PATH , INVALID PATH !!! " + e.getMessage());
        }
    }
}




