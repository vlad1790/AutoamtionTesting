package ColorStreetTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInToTheColorStreet extends BaseTestS { //extends

    @Test
    public void colorStreet_E2E_Testing(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        LogShippingPageS logShippingPageS = logInPageColorSt.colorStreet_WebsiteTesting("07029");
        logShippingPageS.shippingPage(name,lastname,streetAddress,city,postCode,email,phone);// parameters
        }

    @Test
    public void test1(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        logInPageColorSt.addTwoProductsToTheCard();
    }

    @Test
    public void test2(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        logInPageColorSt.addThreeProductsToTheCard();
        Assert.assertTrue(logInPageColorSt.DiscountIsDisplayed());
    }

    @Test
    public void test3(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        logInPageColorSt.checkoutButton();
    }

    @Test
    public void test4(){
        LogShippingPageS logShippingPageS = new LogShippingPageS(driver);
        logShippingPageS.openWebsite();
        logShippingPageS.addProductsToTheCart();
        Assert.assertTrue(logShippingPageS.isCreated());
    }

    @Test
    public void test5(){
        LogShippingPageS logShippingPageS = new LogShippingPageS(driver);
        logShippingPageS.openWebsite();
        logShippingPageS.addFewProductsToTheCart();
        Assert.assertTrue(logShippingPageS.inputFieldIsDisplayed());
    }

    @Test
    public void test6(){
        LogShippingPageS logShippingPageS = new LogShippingPageS(driver);
        logShippingPageS.openWebsite();
        logShippingPageS.goToTheAboutPage();
        Assert.assertTrue(logShippingPageS.textIsDisplayed());
    }

    @Test
    public void test7(){
        LogInPageColorSt logInPageColorSt = new LogInPageColorSt(driver);
        logInPageColorSt.openWebsite();
        logInPageColorSt.arrayListLoop();
    }



    // choose stylist
    // go to about page
    // Add one product to the cart and click checkout and choose stylist and get to the shipping page!
    //Go to  join page -> start the video -> stop the video -> go back to home page




    // Add two products to the cart and remove one product!
        // Add three products to the cart and assert that the discount appeared!
        // Add one product to the cart - then return to catalog and add another product and click checkout button!
        // Add one product to the cart and click checkout and choose stylist and get to the shipping page!
        //Go to  join page -> start the video -> stop the video -> go back to home page
        // test around with the shop
        // choose stylist
        // go to about page
        // shop different products and add to the cart 4 products to get the discount and Assert it
        // add products and remove products
        //Filter for some products and assert that you can see it
    }

