package ColorStreetTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactories {

     public static WebDriver getDriver(BrowserTypes browser){ // we use static to avoid creating objects
         
            switch (browser) {
                case FIREFOX: return getFirefoxDriver();
                default: return getChromeDriver();
            }
        }
        private static WebDriver getChromeDriver(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
//            options.addArguments("window-size=1400,1000"); //to run test cases without seeing
//            options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(options);
        }
        private static WebDriver getFirefoxDriver(){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); //to run test cases without seeing
            options.addArguments("--width=1400");
            options.addArguments("--height=1000");
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(options);
        }
}
