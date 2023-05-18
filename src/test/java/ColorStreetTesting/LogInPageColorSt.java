package ColorStreetTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPageColorSt extends BasePageS{ //extends

        private static Logger logger = LogManager.getLogger(LogInPageColorSt.class);

    public LogInPageColorSt(WebDriver driver) {
        super(driver);
    }
        public LogShippingPageS colorStreet_WebsiteTesting(String zipcode){

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
            canEnglish.click();  // It worked

            WebElement shop = driver.findElement(By.xpath("//span[text()='Shop']")); //Clicked on the shop
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

        private WebElement addToBag4(){
            By addToCartBy = By.xpath("(//*[@type='button'])[10]");
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBy));
            return driver.findElement(addToCartBy);
        }
        private WebElement addToBag5(){
            By addToCartBy = By.xpath("(//*[@type='button'])[11]");
            return driver.findElement(addToCartBy);
        }
        private WebElement addToBag6(){
            By addToCartBy = By.xpath("(//*[@type='button'])[12]");
            return driver.findElement(addToCartBy);
        }

        private WebElement addToBag3(){
            By addToCartBy = By.xpath("(//*[@type='button'])[9]");
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBy));
            return driver.findElement(addToCartBy);
        }

        private WebElement clickOnGuest(){
            By guestButtonBy = By.xpath("//a[@href='/home/guestcheckout']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(guestButtonBy));
            return driver.findElement(guestButtonBy);
        }

        public void openWebsite(){
            driver.get("https://www.colorstreet.com/");
        }
    }

