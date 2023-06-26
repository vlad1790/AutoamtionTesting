package ColorStreetTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
    public void openWebsite(){
        driver.get("https://www.colorstreet.com/");
    }

   public void addProductsToTheCart(){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       Actions actions = new Actions(driver);

       By saveBy = By.xpath("//*[@class='ot-bnr-save-handler']");
       wait.until(ExpectedConditions.visibilityOfElementLocated(saveBy));
       WebElement save = driver.findElement(saveBy);
       save.click();

       By shopBy = By.xpath("(//a[@href='/home/products/all'])[1]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(shopBy));
       WebElement shop = driver.findElement(shopBy);
       js.executeScript("arguments[0].scrollIntoView();", shop);
       actions.moveToElement(shop).perform();

       WebElement lipstick = driver.findElement(By.xpath("//a[@href='/home/products/lipstick']"));
       lipstick.click();

       WebElement lipstick1 = addLipstick1();
       lipstick1.click();

       WebElement lipstick2 = addLipstick2();
       lipstick2.click();

       WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
       js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
       openShoppingBag.click();

       WebElement remove = driver.findElement(By.xpath("(//a[@class='text-pink'])[1]"));
       remove.click();

       By checkoutBy = By.xpath("//a[@class='fl-button-top btn custom-checkout-width']");
       wait.until(ExpectedConditions.elementToBeClickable(checkoutBy));
       WebElement checkout = driver.findElement(checkoutBy);
       checkout.click();
   }
    public boolean isCreated(){
        By createdBy = By.xpath("//a[@class='btn btn-primary']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(createdBy));
            return true;

        } catch (TimeoutException error){
            return false;
        }
    }


   private WebElement addLipstick1(){
        By lipstickBy = By.xpath("(//*[@type='button'])[13]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lipstickBy));
        return driver.findElement(lipstickBy);
   }
    private WebElement addLipstick2(){
        By lipstickBy = By.xpath("(//*[@type='button'])[14]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lipstickBy));
        return driver.findElement(lipstickBy);
    }
    private WebElement addLipstick3(){
        By lipstickBy = By.xpath("(//*[@type='button'])[15]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lipstickBy));
        return driver.findElement(lipstickBy);
    }
    private WebElement addLipstick4(){
        By lipstickBy = By.xpath("(//*[@type='button'])[16]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lipstickBy));
        return driver.findElement(lipstickBy);
    }

    public void addFewProductsToTheCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBy));
        WebElement save = driver.findElement(saveBy);
        save.click();

        By shopBy = By.xpath("(//a[@href='/home/products/all'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopBy));
        WebElement shop = driver.findElement(shopBy);
        js.executeScript("arguments[0].scrollIntoView();", shop);
        actions.moveToElement(shop).perform();

        WebElement lipstick = driver.findElement(By.xpath("//a[@href='/home/products/lipstick']"));
        lipstick.click();

        WebElement lipstick1 = addLipstick1();
        lipstick1.click();

        WebElement lipstick2 = addLipstick2();
        lipstick2.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        WebElement returnButton = driver.findElement(By.xpath("(//a[@href='/home/products'])[1]"));
        returnButton.click();

        WebElement lipstick3 = addLipstick3();
        lipstick3.click();

        WebElement lipstick4 = addLipstick4();
        lipstick4.click();

        WebElement openShoppingBag1 = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag1);
        openShoppingBag1.click();

        By checkoutBy = By.xpath("//a[@class='fl-button-top btn custom-checkout-width']");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBy));
        WebElement checkout = driver.findElement(checkoutBy);
        checkout.click();

        By guestButtonBy = By.xpath("//*[@href='/home/guestcheckout']");
        wait.until(ExpectedConditions.elementToBeClickable(guestButtonBy));
        WebElement guestButton = driver.findElement(guestButtonBy);
        guestButton.click();
    }

    public boolean inputFieldIsDisplayed(){
        By fieldBy = By.xpath("(//*[@class='form-control search-form--input'])[3]");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(fieldBy));
            return true;

          } catch (TimeoutException error){
            return false;
        }
    }

    public void goToTheAboutPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBy));
        WebElement save = driver.findElement(saveBy);
        save.click();

        By shopBy = By.xpath("(//a[@href='/home/products/all'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopBy));
        WebElement shop = driver.findElement(shopBy);
        js.executeScript("arguments[0].scrollIntoView();", shop);
        actions.moveToElement(shop).perform();

        WebElement lipstick = driver.findElement(By.xpath("//a[@href='/home/products/lipstick']"));
        lipstick.click();

        WebElement lipstick1 = addLipstick1();
        lipstick1.click();

        WebElement lipstick2 = addLipstick2();
        lipstick2.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        WebElement returnButton = driver.findElement(By.xpath("(//a[@href='/home/products'])[1]"));
        returnButton.click();

        WebElement lipstick3 = addLipstick3();
        lipstick3.click();

        WebElement lipstick4 = addLipstick4();
        lipstick4.click();

        WebElement openShoppingBag1 = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag1);
        openShoppingBag1.click();

        By aboutBy = By.xpath("(//*[@href='/home/about'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutBy));
        WebElement about = driver.findElement(aboutBy);
        js.executeScript("arguments[0].scrollIntoView();", about);
        actions.moveToElement(about).perform();

        WebElement ourStory = driver.findElement(By.xpath("(//a[@href='/home/about#story'])[1]"));
        ourStory.click();
    }

    public boolean textIsDisplayed(){
        By textBy = By.xpath("//div[@class='text-screen banner-about-text-desktop']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(textBy));
            return true;

        } catch (TimeoutException error){
            return false;
        }
    }

    public void checkOutPage(String zipCode){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBy));
        WebElement save = driver.findElement(saveBy);
        save.click();

        By shopBy = By.xpath("(//a[@href='/home/products/all'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopBy));
        WebElement shop = driver.findElement(shopBy);
        js.executeScript("arguments[0].scrollIntoView();", shop);
        actions.moveToElement(shop).perform();

        WebElement lipstick = driver.findElement(By.xpath("//a[@href='/home/products/lipstick']"));
        lipstick.click();

        WebElement lipstick1 = addLipstick1();
        lipstick1.click();

        WebElement lipstick2 = addLipstick2();
        lipstick2.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        WebElement returnButton = driver.findElement(By.xpath("(//a[@href='/home/products'])[1]"));
        returnButton.click();

        WebElement lipstick3 = addLipstick3();
        lipstick3.click();

        WebElement lipstick4 = addLipstick4();
        lipstick4.click();

        WebElement openShoppingBag1 = driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag1);
        openShoppingBag1.click();

        By checkoutBy = By.xpath("//a[@class='fl-button-top btn custom-checkout-width']");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBy));
        WebElement checkout = driver.findElement(checkoutBy);
        checkout.click();

        By guestBy = By.xpath("//a[@href='/home/guestcheckout']");
        wait.until(ExpectedConditions.elementToBeClickable(guestBy));
        WebElement guest = driver.findElement(guestBy);
        guest.click();

        By languageBy = By.xpath("(//div[@class='input-group'])[5]"); //Clicked on the language drop down
        wait.until(ExpectedConditions.elementToBeClickable(languageBy));
        WebElement language = driver.findElement(languageBy);
        language.click();

        By unitedBy = By.xpath("(//*[text()='United States'])[5]");
        wait.until(ExpectedConditions.elementToBeClickable(unitedBy));
        WebElement unitedStates = driver.findElement(unitedBy);
        unitedStates.click();

        By zipCodeBy = By.xpath("(//*[@class='form-control search-form--input'])[4]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeBy));
        WebElement zip = driver.findElement(zipCodeBy);
        zip.click();
        zip.sendKeys(zipCode);

        WebElement searchButton = driver.findElement(By.xpath("(//a[@class='input-group-addon btn btn-primary btn-primary--purple'])[4]"));
        searchButton.click();

        By stylistBy = By.xpath("(//*[@class='btn btn-primary'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(stylistBy));
        WebElement stylist = driver.findElement(stylistBy);
        js.executeScript("arguments[0].scrollIntoView();", stylist);
        stylist.click();
    }

    public boolean nameIsDisplayed(){
        By nameBy = By.xpath("//*[@data-val-required='First Name is required']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy));
            return true;

        } catch (TimeoutException error){
            return false;
        }
    }
}
