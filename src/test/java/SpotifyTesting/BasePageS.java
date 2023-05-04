package SpotifyTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageS {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePageS(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 200);

    }
}
