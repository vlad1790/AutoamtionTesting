package SpotifyTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageS extends BasePageS {

    private static Logger logger = LogManager.getLogger(MainPageS.class);


    public MainPageS(WebDriver driver){
        super(driver);
    }

    public boolean isHome(){
        By homeBy = By.xpath("//*[text()='Home']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    public boolean isLogOut(){
        By logOutBy = By.xpath("//*[text()='Log in']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(logOutBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    ////////////////////////////////////////////// create a play list and assert that it was created! It worked!

    private WebElement getPlusButton(){
        By plusButtonBy = By.xpath("(//*[@class='IconWrapper__Wrapper-sc-16usrgb-0 dlqYDF'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(plusButtonBy));
        return driver.findElement(plusButtonBy);
    }


    private WebElement getCreatePlayList(){
        logger.info("Playlist was created!");

        By createBy = By.xpath("(//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(createBy));
        return driver.findElement(createBy);
        //class="Type__TypeElement-sc-goli3j-0 jqNXli J4xXuqyaJnnwS6s2p3ZB standalone-ellipsis-one-line"
    }

    public void created(){
        getPlusButton().click();
        getCreatePlayList().click();
    }

    public boolean isCreated(){
        By createBy = By.xpath("//div[@class='os-host os-host-foreign os-theme-spotify os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-scrollbar-vertical-hidden os-host-transition']");
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(createBy));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    ////////////////////////////////////////////// open play list -> scroll to the song and play it! It worked!
    public void openPlayList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By openBy = By.xpath("(//*[@class='ufICQKJq0XJE5iiIsZfj  qEiVyQ28VnOKb0LeijqL'])[1]"); //(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[7] it works
        wait.until(ExpectedConditions.visibilityOfElementLocated(openBy));
        WebElement playList = driver.findElement(openBy);
        js.executeScript("arguments[0].scrollIntoView();", playList);

        Actions actions = new Actions(driver);
        actions.doubleClick(playList).perform();

        By buttonBy = By.xpath("(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[19]"); //(//span[@class='vBFTtFW3Co9F_yJ_HjF4'])[7]
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBy));
        WebElement button = driver.findElement(buttonBy);
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();

        By pauseBy = By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']");
        wait.until(ExpectedConditions.elementToBeClickable(pauseBy));
        WebElement pause = driver.findElement(pauseBy);
        pause.click();

        // Right Click
        //Actions actions = new Actions(driver);
        //WebElement elementLocator = driver.findElement(By.id("ID"));
        //actions.contextClick(elementLocator).perform();
    }
///////////////////////////////////////////////////////////////////////////////////////// It worked!
public void renamePlayList(String newName) { // It worked successfully!
    logger.trace("Play List was renamed!");
    logger.info("Created Playlist with name -> " + newName);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    By openBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[12]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(openBy));
    WebElement playList = driver.findElement(openBy);
    js.executeScript("arguments[0].scrollIntoView();", playList);

    Actions actions = new Actions(driver);
    actions.contextClick(playList).perform();

    By editBy = By.xpath("(//*[@class='wC9sIed7pfp47wZbmU6m'])[3]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(editBy));
    WebElement edit = driver.findElement(editBy);
    edit.click();

    WebElement editDetails = getEditDetails();
    editDetails.sendKeys(Keys.COMMAND + "A");
    editDetails.sendKeys(newName);
    editDetails.sendKeys(Keys.RETURN);

    WebElement save = driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 ODKlM encore-inverted-light-set']"));
    save.click();
    logger.info("Save button was clicked successfully." +save);


}
 private WebElement getEditDetails(){
        By editDetailsBy = By.xpath("//*[@class='f0GjZQZc4c_bKpqdyKbq JaGLdeBa2UaUMBT44vqI']");
        wait.until(ExpectedConditions.elementToBeClickable(editDetailsBy));
        return driver.findElement(editDetailsBy);
    }
////////////////////////////////////////////////////////////////////////////////////////// add song to play list and play it

 public void addSongToPlayList(String name){

     JavascriptExecutor js = (JavascriptExecutor) driver;
     By openBy = By.xpath("(//*[@class='Areas__HeaderArea-sc-8gfrea-3 fInrEV'])[4]");
     wait.until(ExpectedConditions.visibilityOfElementLocated(openBy));
     WebElement playList = driver.findElement(openBy);
     js.executeScript("arguments[0].scrollIntoView();", playList);

     Actions actions = new Actions(driver);
     actions.doubleClick(playList).perform();

     By fieldSearchBy = By.xpath("//*[@class='Type__TypeElement-sc-goli3j-0 eMzEmF FeWwGSRANj36qpOBoxdx']");
     wait.until(ExpectedConditions.elementToBeClickable(fieldSearchBy));
     WebElement searchField = driver.findElement(fieldSearchBy);
     searchField.click();
     searchField.sendKeys(name);

     By addSongBy = By.xpath("(//*[@class='Button-sc-y0gtbx-0 eNMEAb'])[2]");
     wait.until(ExpectedConditions.visibilityOfElementLocated(addSongBy));
     WebElement add = driver.findElement(addSongBy);
     js.executeScript("arguments[0].scrollIntoView();", add);
     add.click();

     By songBy = By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']");
     wait.until(ExpectedConditions.visibilityOfElementLocated(songBy));
     WebElement song = driver.findElement(songBy);
     js.executeScript("arguments[0].scrollIntoView();", song);
     song.click();

     WebElement pauseSong = driver.findElement(By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']"));
     pauseSong.click();

 }
 ///////////////////////////// open your podcasts -> your episodes -> 3 dots -> remove podcast
    //tree dots (//button[@type='button'])[8] sandhagen podcast
    // remove episode (//span[@class='Type__TypeElement-sc-goli3j-0 eMzEmF ellipsis-one-line PDPsYDh4ntfQE3B4duUI'])[2]





    ///////////////////// delete a song from play list

}
