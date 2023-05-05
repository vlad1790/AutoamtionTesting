package SpotifyTesting;

import Listeners.GetScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestS {

    protected WebDriver driver;
    protected String username;
    protected String password;

    @BeforeMethod // we use this annotation before the function! to keep the code dry! It will work before each test.
    public void startUp() { //because we added parameters in TestNG XML file!
        username = "kalayda.vlad1990@gmail.com";
        password = "Vlad1990!";

//        BrowserTypeS browserTypeS = browser.equals("chrome") ? BrowserTypeS.CHROME : BrowserTypeS.FIREFOX; //SAME AS IF, ELSE ? if and : else
//        driver = BrowserFactory.getDriver(BrowserType.CHROME);

        //Browser Factory where we have all functions to drivers

//        System.setProperty("webdriver.chrome.driver","chromedriver"); //OLD WAY
//        WebDriverManager.chromedriver().setup();//NEW WAY
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    // we use this annotation before the function, and it will work at the end of the tests to keep the code dry!
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult iTestResult) throws InterruptedException { //FOR SCREENSHOT IF TEST FAILS TO GET SCREENSHOT!
        if (iTestResult.getStatus() == iTestResult.FAILURE){
            GetScreenshot.capture(driver, iTestResult.getName());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}



