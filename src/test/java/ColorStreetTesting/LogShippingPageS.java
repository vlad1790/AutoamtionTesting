package ColorStreetTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogShippingPageS extends BasePageS{ //extends

    public LogShippingPageS(WebDriver driver){
        super(driver);
    }
    public void shippingPage(String firstname,String lastname,String streetAddress,
                             String city,String postCode,String email,String phone){

       By nameBy = By.xpath("//*[@data-val-required='First Name is required']"); //The correct x path
       wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy));
       WebElement name = driver.findElement(nameBy);
       name.click();
       name.sendKeys(firstname);
       name.sendKeys(Keys.ENTER);

        WebElement lastName = driver.findElement(By.xpath("//*[@data-val-required='Last Name is required']"));
        lastName.click();
        lastName.sendKeys(lastname);

        WebElement streetAddress1  = driver.findElement(By.xpath("//*[@data-val-required='Street Address is required']"));
        streetAddress1.click();
        streetAddress1.sendKeys(streetAddress);

        WebElement city1 = driver.findElement(By.xpath("//*[@data-val-required='City is required']"));
        city1.click();
        city1.sendKeys(city);

        By provinceBy = By.xpath("(//*[@class='form-control'])[8]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(provinceBy));
        WebElement province = driver.findElement(provinceBy);
        province.click();

        WebElement selectProvince = driver.findElement(By.xpath("//select/option[text() = 'Ontario']"));
        selectProvince.click();

        WebElement postalCode = driver.findElement(By.xpath("//*[@data-val-required='Zip Code is required']"));
        postalCode.click();
        postalCode.sendKeys(postCode);

        WebElement enterEmail = driver.findElement(By.xpath("//*[@data-val-required='Email is required']"));
        enterEmail.click();
        enterEmail.sendKeys(email);

        WebElement enterPhone = driver.findElement(By.xpath("//*[@data-val-required='Phone Number is required']"));
        enterPhone.click();
        enterPhone.sendKeys(phone);

        WebElement shipButton = driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[4]"));
        shipButton.click();

        By continueButtonBy = By.xpath("//a[@data-role='use-address']");
        wait.until(ExpectedConditions.elementToBeClickable(continueButtonBy));
        WebElement continueButton = driver.findElement(continueButtonBy);
        continueButton.click();
    }
}
