package ColorStreetTesting;

import org.testng.annotations.Test;

public class LogInToTheColorStreet extends BaseTestS { //extends

    @Test
    public void colorStreet_E2E_Testing(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        LogShippingPageS logShippingPageS = logInPageColorSt.colorStreet_WebsiteTesting("07029");
        logShippingPageS.shippingPage(name,lastname,streetAddress,city,postCode,email,phone);
        }

    }

