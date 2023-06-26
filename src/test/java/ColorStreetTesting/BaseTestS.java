package ColorStreetTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestS {

        protected WebDriver driver;
        protected String name;
        protected String lastname;
        protected String streetAddress;
        protected String city;
        protected String postCode;
        protected String email;
        protected String phone;

        @Parameters({"firstname","lastname","streetAddress","city","postCode","email","phone","browser"})

        @BeforeMethod
        public void startUp1(String name,String lastname,String streetAddress,String city,
                             String postCode,String email,String phone,String browser){
            this.name = name;
            this.lastname = lastname;
            this.streetAddress = streetAddress;
            this.city = city;
            this.postCode = postCode;
            this.email = email;
            this.phone = phone;

            BrowserTypes browserTypes = browser.equals("chrome") ? BrowserTypes.CHROME : BrowserTypes.FIREFOX;
            driver = BrowserFactories.getDriver(BrowserTypes.CHROME);
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown1() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

