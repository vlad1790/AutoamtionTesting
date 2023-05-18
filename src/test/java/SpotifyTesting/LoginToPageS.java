package SpotifyTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;

public class LoginToPageS extends BasePageS{

    private static Logger logger = LogManager.getLogger(LoginToPageS.class);


    public LoginToPageS(WebDriver driver){
        super(driver);
    }

////////////////////////////////////////////////////////////////////////////// log in
    private WebElement getEmailField(){
        By emailBy = By.xpath("//*[@type='text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy));
        return driver.findElement(emailBy);
    }

    private WebElement getPasswordField(){
        return driver.findElement(By.xpath("//*[@type='password']"));
    }

    private WebElement getLoginButton(){
        return driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 cJdEzG encore-bright-accent-set']"));
    }
////////////////////////////////////////////////////////////////////////////// Get account and log out
    private WebElement getAccountIcon(){
        By accountBy = By.xpath("//div[@class='KdxlBanhDJjzmHfqhP0X']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountBy));
        return driver.findElement(accountBy);
    }

    private WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//*[text()='Log out']"));
    }
//////////////////////////////////////////////////////////////////////////////  search field -> find a song and play it! It worked !!!
    private WebElement getClickSearchButton(){
        By searchBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 bhIkbK'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy));
        return driver.findElement(searchBy);
    }
    private WebElement getSearchField(){
        By searchFieldBy = By.xpath("//input[@class='Type__TypeElement-sc-goli3j-0 eMzEmF QO9loc33XC50mMRUCIvf']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy));
        return driver.findElement(searchFieldBy);
    }
    private WebElement getSongtoPlay(){
        By songBy = By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 jqrOrp encore-bright-accent-set']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(songBy));
        return driver.findElement(songBy);
    }
    private WebElement getSongtoPause(){
        return driver.findElement(By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']"));
    }

////////////////////////////////////////////////////////////////////////////// Delete the play list! // It worked successfully!
    public void deletePlayList(){
        logger.trace("Playlist was deleted!"); //notebook for us!

        JavascriptExecutor js = (JavascriptExecutor) driver;

        By playListBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[13]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);

        Actions actions = new Actions(driver);
        actions.contextClick(playList).perform();

        By deleteBy = By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[6]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBy));
        WebElement delete = driver.findElement(deleteBy);
        delete.click();

        WebElement finalDelete = driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 drfsaJ encore-bright-accent-set']"));
        finalDelete.click();
    }

////////////////////////////////////////////////////////////////////////////
    public MainPageS logToSpotify(String username, String password){
        logger.info("Log in was successful to Spotify!"); // Notebook
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPageS(driver);

    }
    public void logOut(){
        getAccountIcon().click();
        getLogoutButton().click();
    }

    public void playTheSong(String name){
        getClickSearchButton().click();
        getSearchField().sendKeys(name);
        getSearchField().sendKeys(Keys.RETURN);
        getSongtoPlay().click();
        getSongtoPause().click();
    }

    public void open(){
        driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
    }

    public boolean isError(){
        By errorBy = By.xpath("//span[@class='Message-sc-15vkh7g-0 dHbxKh']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    //////////////////////////////////////////////////// open Joe podcast -> SCROLL it to podcast and play it and saved to a library || It worked!

    public void PlayPodcast(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        By podcastBy = By.xpath("(//div[@class='tsv7E_RBBw6v0XTQlcRo'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(podcastBy));
        WebElement podcast = driver.findElement(podcastBy);
        js.executeScript("arguments[0].scrollIntoView();", podcast);

        Actions actions = new Actions(driver);
        actions.doubleClick(podcast).perform();

        By imageBy = By.xpath("(//div[@class='ij5_Bi2LfqgWwHzQBXJS'])[18]"); //(//*[@class='DyuLxip2Kl8P7H8fW62u'])[24]
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageBy));
        WebElement image = driver.findElement(imageBy);
        js.executeScript("arguments[0].scrollIntoView();", image);
        image.click();

        By pressButtonBy = By.xpath("//button[@class='IeLnf2wUHVKqxhzBcBoM KOoUMuC7IxI_1Pi4r4m5 encore-bright-accent-set']");
        wait.until(ExpectedConditions.elementToBeClickable(pressButtonBy));
        WebElement pressButton = driver.findElement(pressButtonBy);
        pressButton.click();

        // add podcast to a play list
        By plusBy = By.xpath("(//button[@type='button'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusBy));
        WebElement plus = driver.findElement(plusBy);
        plus.click();
    }

    ///////////////////////////////////////// Google Search worked / keep palying around with google
    public void google(){
        driver.get("https://www.google.com/");
    }

    public void googleSearch(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By googleSearchBy = By.xpath("//*[@class='gLFyf']");
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchBy));
        WebElement googleSearch = driver.findElement(googleSearchBy);
        googleSearch.click();
        googleSearch.sendKeys(name);
        googleSearch.sendKeys(Keys.ENTER);

        By ufcBy = By.xpath("(//div[@class='O3S9Rb'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ufcBy));
        WebElement ufc = driver.findElement(ufcBy);
        js.executeScript("arguments[0].scrollIntoView();", ufc);
        ufc.click();

        //Actions actions = new Actions(driver);
        //actions.doubleClick(ufc).perform();

    }

    public boolean newsIsDisplayed(){
        By buttonBy = By.xpath("//*[@class='iRPxbe']");
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBy));
        return true;

    } catch (TimeoutException err) {
            return false;
        }
    }
    ///////////////////////////////////////////////////////////// Google search!
    public void googleSearch1(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By googleSearchBy = By.xpath("//*[@class='gLFyf']");
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchBy));
        WebElement googleSearch = driver.findElement(googleSearchBy);
        googleSearch.click();
        googleSearch.sendKeys(name);
        googleSearch.sendKeys(Keys.ENTER);


        WebElement ufc = driver.findElement(By.xpath("(//div[@class='g5wfEd'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", ufc);
        ufc.click();


        By eventsBy = By.xpath("(//*[@class='c-menu-main__item--left'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(eventsBy));
        WebElement events = driver.findElement(eventsBy);
        events.click();



    }

    public boolean isMainEvent(){
        By mainEventBy = By.xpath("(//span[@class='e-button__text'])[1]");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(mainEventBy));
            return true;
        } catch (TimeoutException error){
            return false;
        }
    }


    public void googleSearch2(String name,String fieldName){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By googleSearchBy = By.xpath("//*[@class='gLFyf']");
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchBy));
        WebElement googleSearch = driver.findElement(googleSearchBy);
        googleSearch.click();
        googleSearch.sendKeys(name);
        googleSearch.sendKeys(Keys.ENTER);

        WebElement ufc = driver.findElement(By.xpath("(//div[@class='g5wfEd'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", ufc);
        ufc.click();

        WebElement search = driver.findElement(By.xpath("//*[@class='e-icon__svg search']"));
        search.click();

        By searchFieldBy = By.xpath("//*[@class='js-yext-query yxt-SearchBar-input']");
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldBy));
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.click();
        searchField.sendKeys(fieldName);
        searchField.sendKeys(Keys.RETURN);

    }

    public boolean searchResult(){
        By searchResultBy = By.xpath("//div[@class='l-masthead__headline ']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultBy));
            return true;
        } catch (TimeoutException error){
            return true;
        }
    }

    public void googleSearch3(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By googleSearchBy = By.xpath("//*[@class='gLFyf']");
        wait.until(ExpectedConditions.elementToBeClickable(googleSearchBy));
        WebElement googleSearch = driver.findElement(googleSearchBy);
        googleSearch.click();
        googleSearch.sendKeys(name);
        googleSearch.sendKeys(Keys.ENTER);

        WebElement ufc = driver.findElement(By.xpath("(//div[@class='g5wfEd'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", ufc);
        ufc.click();

        By ufcButtonBy = By.xpath("//a[@href='https://ufc.com/30']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ufcButtonBy));
        WebElement ufcButton = driver.findElement(ufcButtonBy);
        ufcButton.click();


        By playBy = By.xpath("//a[@href='/video/ufc-30th-anniversary-changing-game']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBy));
        WebElement play = driver.findElement(playBy);
        play.click();

        WebElement close = driver.findElement(By.xpath("//a[@href='/']"));
        close.click();

    }

    public boolean isRead(){
        By readBy = By.xpath("(//span[@class='e-button__text'])[1]");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(readBy));
            return true;
        } catch (TimeoutException error){
            return false;
        }
    }













//////////////////////////////////////////////////////////////// search for Joe Rogan -> click on it -> scroll it and add to my episodes a podcast

    public void addPodcast(String name){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        By searchBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 bhIkbK'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy));
        WebElement search = driver.findElement(searchBy);
        js.executeScript("arguments[0].scrollIntoView();", search);
        search.click();
        logger.info("Search click was successful!"); //notebook for us!

        By searchFieldBy = By.xpath("//input[@class='Type__TypeElement-sc-goli3j-0 eMzEmF QO9loc33XC50mMRUCIvf']");
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldBy));
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(name);
        searchField.sendKeys(Keys.ENTER);
        logger.trace("Search Field was successful!"); //notebook for us!

        By imageBy = By.xpath("//*[@class='_gB1lxCfXeR8_Wze5Cx9']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageBy));
        WebElement image = driver.findElement(imageBy);
        js.executeScript("arguments[0].scrollIntoView();", image);
        image.click();
        logger.info("Clicked on the podcast image!"); //notebook for us!

        By threeDotsBy = By.xpath("(//button[@class='T0anrkk_QA4IAQL29get'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(threeDotsBy));
        WebElement threeDots = driver.findElement(threeDotsBy);
        js.executeScript("arguments[0].scrollIntoView();", threeDots);
        threeDots.click();

        WebElement description = driver.findElement(By.xpath("(//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[3]"));
        description.click();





        //(//button[@type='button'])[16] three dots
        // (//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[3] see episodes description
        ////*[@class='ql0zZd7giPXSnPg75NR0'] back arrow
        // //button[@class='idI9vydtCzXVhU1BaKLw'] assert



    }
    //////////////////////////////////////////////////////// delete a song from play list

    public void deleteSong() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By playListBy = By.xpath("(//*[@class='jb9xD5ECTqKFK02qe3HZ'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListBy));
        WebElement playList = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);
        playList.click();

        By threeDotsBy = By.xpath("(//button[@class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(threeDotsBy));
        WebElement threeDots = driver.findElement(playListBy);
        js.executeScript("arguments[0].scrollIntoView();", threeDots);
        threeDots.click();

        By removeBy = By.xpath("(//*[@class='DuEPSADpSwCcO880xjUG'])[7]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(threeDotsBy));
        WebElement remove = driver.findElement(removeBy);
        js.executeScript("arguments[0].scrollIntoView();", remove);
        remove.click();

    }

}
