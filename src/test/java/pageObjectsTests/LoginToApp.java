package pageObjectsTests;

import Listeners.MyRetry;
import MainPage.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BaseTest;
import pageObjects.LoginPage;

import java.security.PublicKey;

public class LoginToApp extends BaseTest { // Inheritance

    private int count = 0; // To restart a test case when it fails first time
    @Test(retryAnalyzer = MyRetry.class)
    public void flakyTest(){
        if (count<=2){
            count++;
            Assert.assertTrue(false);
        }
        Assert.assertTrue(true);
    }


    @Test // (enabled = false) to skip the test or exclude in TestNG. Now we run all tests from TestNG.
    public void loginToApp_correctCredentials_successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username,password);
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginToApp_incorrectCredentials_failedLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApp(username,"wrong password");
        Assert.assertTrue(loginPage.isError());
    }
    @Test
    public void deletePlaylist_playListDeleted_Succesfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApp(username,password);
        loginPage.deletePlayList();
        Assert.assertTrue(loginPage.isSuccess());
    }
}
