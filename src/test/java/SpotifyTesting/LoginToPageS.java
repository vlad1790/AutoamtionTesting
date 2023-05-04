package SpotifyTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        By searchBy = By.xpath("//*[text()='Search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy));
        return driver.findElement(searchBy);
    }
    private WebElement getSearchField(){
        By searchFieldBy = By.xpath("//*[@class='Type__TypeElement-sc-goli3j-0 bNyYSN QO9loc33XC50mMRUCIvf']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy));
        return driver.findElement(searchFieldBy);
    }
    private WebElement getSongtoPlay(){
        By songBy = By.xpath("//*[@class='vnCew8qzJq3cVGlYFXRI']");
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
}
