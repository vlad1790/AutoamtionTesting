package ColorStreetTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class LogInPageColorSt extends BasePageS { //extends

    private static Logger logger = LogManager.getLogger(LogInPageColorSt.class);

    public LogInPageColorSt(WebDriver driver) {
        super(driver);
    }

    public LogShippingPageS colorStreet_WebsiteTesting(String zipcode) {

        logger.trace("Testing!");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveButtonBy = By.xpath("//*[@class='ot-bnr-save-handler']"); //Clicked on the Save button.
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonBy));
        WebElement saveButton = driver.findElement(saveButtonBy);
        js.executeScript("arguments[0].scrollIntoView();", saveButton);
        saveButton.click();

        WebElement languageButton = driver.findElement(By.xpath("(//span[text()='English'])[1]")); //I changed the language.
        languageButton.click();

        By canEnglishBy = By.xpath("(//*[@data-val='en-CA'])[1]"); //To Canadian - En.
        wait.until(ExpectedConditions.visibilityOfElementLocated(canEnglishBy));
        WebElement canEnglish = driver.findElement(canEnglishBy);
        js.executeScript("arguments[0].scrollIntoView();", canEnglish);
        canEnglish.click();

        WebElement shop = driver.findElement(By.xpath("//span[text()='Shop']")); //Hover over the shop!
        actions.moveToElement(shop).perform();

        By solidColorBy = By.xpath("(//a[@href='/home/products/solidcolors'])[1]"); //Clicked on the solid color
        wait.until(ExpectedConditions.visibilityOfElementLocated(solidColorBy));
        WebElement solidColor = driver.findElement(solidColorBy);
        solidColor.click();

        WebElement addToCart4 = addToBag4(); //Added three products to the cart
        addToCart4.click();

        WebElement addToCart5 = addToBag5();
        addToCart5.click();

        WebElement addToCart6 = addToBag6();
        addToCart6.click();

        WebElement shoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart
        shoppingBag.click();

        WebElement checkout = driver.findElement(By.xpath("//a[@class='fl-button-top btn custom-checkout-width']")); //Clicked on the checkout
        checkout.click();

        By returnToCatalogBy = By.xpath("(//a[@href='/home/products'])[2]");//Clicked on the return catalog
        wait.until(ExpectedConditions.elementToBeClickable(returnToCatalogBy));
        WebElement returnToCatalog = driver.findElement(returnToCatalogBy);
        returnToCatalog.click();

        WebElement addToCart3 = addToBag3(); //Added item #3 to the cart
        addToCart3.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart again.
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        Boolean discount = driver.findElement(By.xpath("//div[@class='col-xs-2 text-right text-success']")).isDisplayed(); //Verified discount in the shopping cart
        System.out.println("The discount amount is displayed = " + discount);

        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='fl-button-top btn custom-checkout-width']"));// Clicked on the checkout button
        checkoutButton.click();

        WebElement guestButton = clickOnGuest(); //Clicked as guest
        guestButton.click();

        By languageBy = By.xpath("(//div[@class='input-group'])[5]"); //Clicked on the language drop down
        wait.until(ExpectedConditions.elementToBeClickable(languageBy));
        WebElement language = driver.findElement(languageBy);
        language.click();

        By unitedStatesBy = By.xpath("(//*[text()='United States'])[5]"); //Switched the language to the United States
        wait.until(ExpectedConditions.elementToBeClickable(unitedStatesBy));
        WebElement unitedStates = driver.findElement(unitedStatesBy);
        js.executeScript("arguments[0].scrollIntoView();", unitedStates);
        unitedStates.click();

        WebElement zipCode = driver.findElement(By.xpath("(//*[@class='form-control search-form--input'])[4]"));//Entered zip code
        zipCode.click();
        zipCode.sendKeys(zipcode);
        zipCode.sendKeys(Keys.ENTER);

        WebElement searchButton = driver.findElement(By.xpath("(//a[@class='input-group-addon btn btn-primary btn-primary--purple'])[4]"));//Clicked on the Search button
        searchButton.click();

        By selectStylistBy = By.xpath("(//a[@class='btn btn-primary'])[4]");//Selected stylist #3
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectStylistBy));
        WebElement selectStylist = driver.findElement(selectStylistBy);
        selectStylist.click();

        return new LogShippingPageS(driver);
    }

    private WebElement addToBag4() {
        By addToCartBy = By.xpath("(//*[@type='button'])[10]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBy));
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBag5() {
        By addToCartBy = By.xpath("(//*[@type='button'])[11]");
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBag6() {
        By addToCartBy = By.xpath("(//*[@type='button'])[12]");
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBag3() {
        By addToCartBy = By.xpath("(//*[@type='button'])[9]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBy));
        return driver.findElement(addToCartBy);
    }

    private WebElement clickOnGuest() {
        By guestButtonBy = By.xpath("//a[@href='/home/guestcheckout']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestButtonBy));
        return driver.findElement(guestButtonBy);
    }

    public void openWebsite() {
        driver.get("https://www.colorstreet.com/");
    }


    public void addTwoProductsToTheCard() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        WebElement shopAll = driver.findElement(By.xpath("(//a[@href='/home/products/all'])[1]"));
        actions.moveToElement(shopAll).perform();

        By solidColorsBy = By.xpath("(//*[@href='/home/products/solidcolors'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(solidColorsBy));
        WebElement solidColor = driver.findElement(solidColorsBy);
        solidColor.click();

        WebElement addToCartP = addToBagP1(); //Added three products to the cart
        addToCartP.click();

        WebElement addToCartV = addToBagP2();
        addToCartV.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart again.
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        WebElement remove = driver.findElement(By.xpath("//a[@class='text-pink']"));
        remove.click();
    }

    private WebElement addToBagP1() {
        By addToCartBy = By.xpath("(//*[@type='button'])[15]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBy));
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBagP2() {
        By addToCartBy = By.xpath("(//*[@type='button'])[16]");
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBagP3() {
        By addToCartBy = By.xpath("(//*[@type='button'])[17]");
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBagP4() {
        By addToCartBy = By.xpath("(//*[@type='button'])[18]");
        return driver.findElement(addToCartBy);
    }

    private WebElement addToBagP5() {
        By addToCartBy = By.xpath("(//*[@type='button'])[19]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBy));
        return driver.findElement(addToCartBy);
    }


    public void addThreeProductsToTheCard() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        WebElement shopAll = driver.findElement(By.xpath("(//a[@href='/home/products/all'])[1]"));
        actions.moveToElement(shopAll).perform();

        By solidColorsBy = By.xpath("(//*[@href='/home/products/solidcolors'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(solidColorsBy));
        WebElement solidColor = driver.findElement(solidColorsBy);
        solidColor.click();

        WebElement addToCartP = addToBagP1(); //Added three products to the cart
        addToCartP.click();

        WebElement addToCartV = addToBagP2();
        addToCartV.click();

        WebElement addToCartK = addToBagP3();
        addToCartK.click();

        WebElement addToCartZ = addToBagP4();
        addToCartZ.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart again.
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();
    }

    public boolean DiscountIsDisplayed() {
        By discountBy = By.xpath("//div[@class='col-xs-2 text-right text-success']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(discountBy));
            return true;
        } catch (TimeoutException error) {
            return false;
        }
    }

    public void checkoutButton() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        WebElement shopAll = driver.findElement(By.xpath("(//a[@href='/home/products/all'])[1]"));
        actions.moveToElement(shopAll).perform();

        By solidColorsBy = By.xpath("(//*[@href='/home/products/solidcolors'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(solidColorsBy));
        WebElement solidColor = driver.findElement(solidColorsBy);
        solidColor.click();

        WebElement addToCartP = addToBagP1(); //Added three products to the cart
        addToCartP.click();

        WebElement openShoppingBag = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart again.
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag);
        openShoppingBag.click();

        By returnToCatalogBy = By.xpath("//a[@href='/home/products']");
        wait.until(ExpectedConditions.elementToBeClickable(returnToCatalogBy));
        WebElement returnToCatalog = driver.findElement(returnToCatalogBy);
        returnToCatalog.click();

        WebElement addToCartV = addToBagP5();
        addToCartV.click();

        WebElement openShoppingBag1 = driver.findElement(By.xpath("//span[text()='Shopping Bag']")); //Opened shopping cart again.
        js.executeScript("arguments[0].scrollIntoView();", openShoppingBag1);
        openShoppingBag1.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='fl-button-top btn custom-checkout-width']"));
        checkoutButton.click();
    }

    public void arrayListLoop() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        WebElement shopAll = driver.findElement(By.xpath("(//a[@href='/home/products/all'])[1]"));
        actions.moveToElement(shopAll).perform();

        By solidColorsBy = By.xpath("(//*[@href='/home/products/solidcolors'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(solidColorsBy));
        WebElement solidColor = driver.findElement(solidColorsBy);
        solidColor.click();

        // List<WebElement> products = driver.findElements(By.xpath("//*[@class='text-black']"));
        // WebElement q;
        // for(int i=0; i < products.size(); i++){
        //     q = products.get(i);
        //    System.out.println(q.getText());
        // }

        // for(WebElement w : products){
        //    System.out.println(w.getText());
        //  }

        //  for (WebElement pr : products) {
        //      if (pr.getText().contains("Toffee Nut")) {
        //          System.out.println(pr.getTagName());
        //          System.out.println(pr.isDisplayed());
        //          System.out.println(pr.getText());
        //          System.out.println(pr.getSize());

        //    }
        // }


        // for(WebElement p : products){
        //     if(products.size() > 0){
        //         String myText = products.get(0).getText();
        //         if(myText.contains("Toffee Nut")){
        //             System.out.println(p.getText());
        //         }
        //     }

        //  }

         WebElement myProducts = products();
         System.out.println(myProducts.getTagName());
         System.out.println(myProducts.getText());
    }

    private WebElement products(){
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='text-black']"));
        for (WebElement pr : products) {
            if (pr.getText().contains("Toffee Nut")) {
                return pr;
            }
        }
        return null;
    }

    public void application(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        By applicationBy = By.xpath("//a[@href='/home/application']");
        wait.until(ExpectedConditions.elementToBeClickable(applicationBy));
        WebElement application = driver.findElement(applicationBy);
        js.executeScript("arguments[0].scrollIntoView();", application);
        actions.moveToElement(application).perform();

        WebElement video = driver.findElement(By.xpath("//a[@href='/home/application#videos']"));
        video.click();
    }

    public boolean isDisplayedText(){
        By textBy = By.xpath("//div[@class='col-lg-12 application-header']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(textBy));
            return true;

        } catch (TimeoutException error){
            return false;
        }
    }

    public void logIn(String zipCode){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        By saveAllBy = By.xpath("//*[@class='ot-bnr-save-handler']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveAllBy));
        WebElement saveAll = driver.findElement(saveAllBy);
        saveAll.click();

        By loginBy = By.xpath("//a[@href='/home/account/login']");
        wait.until(ExpectedConditions.elementToBeClickable(loginBy));
        WebElement logIn = driver.findElement(loginBy);
        js.executeScript("arguments[0].scrollIntoView();", logIn);
        logIn.click();

        WebElement createAccount = driver.findElement(By.xpath("//a[@href='/home/account/register']"));
        createAccount.click();

        By unitedBy = By.xpath("(//*[text()='United States'])[4]");
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

        By stylistBy = By.xpath("(//a[@class='btn btn-primary'])[3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(stylistBy));
        WebElement stylist = driver.findElement(stylistBy);
        js.executeScript("arguments[0].scrollIntoView();", stylist);

        boolean status = stylist.isDisplayed();
        System.out.println("The stylist is displayed = " + status);

    }
}







