package SpotifyTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToSpotify extends BaseTestS {

    @Test
    public void logIn_toSpotify_correctCredentials(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        Assert.assertTrue(mainPageS.isHome());
    }
    @Test
    public void logIn_toSpotify_incorrectCredentials(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,"asdasd");
        Assert.assertTrue(loginToPageS.isError());
    }
    @Test
    public void logout_fromSpotify_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        loginToPageS.logOut();
        Assert.assertTrue(mainPageS.isLogOut());
    }
    @Test
    public void search_theSong_andPlayIt_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.playTheSong("STAY");
    }
    @Test
    public void delete_thePlayList_Successfully(){ //It worked successfully!
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.deletePlayList();

    }
    @Test
    public void play_podcast(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.PlayPodcast();
    }

    @Test
    public void add_podcast_toMyPodcasts(){

    }

    @Test
    public void search_ufc_inGoogle(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.google();
        loginToPageS.googleSearch("ufc.com");

    }
}
