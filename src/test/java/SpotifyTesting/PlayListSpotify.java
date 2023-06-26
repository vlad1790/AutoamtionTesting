package SpotifyTesting;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class PlayListSpotify extends BaseTestS{

    @Test
    public void create_playList_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.created();
        Assert.assertTrue(mainPageS.isCreated());
    }
    @Test
    public void scrollToTheSong_andPlayIt_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.openPlayList();
    }
    @Test
    public void renamePlayList_successfully(){ // It worked successfully!
        Faker faker = new Faker();
        String newName = faker.artist().name();
        System.out.println(newName);

        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.renamePlayList(newName);
    }

    @Test
    public void addSong_toLibrary_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.addSongToPlayList("God's Plan");
        Assert.assertTrue(mainPageS.isHeart());
    }

    @Test
    public void removeSong_fromPlayList(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.deleteSong();
    }

// All five tests cases below have worked!
    @Test
    public void OpenFavorites_playSong(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.favoritesSong();
    }

    @Test
    public void playTheSong(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.openMyPlayListSong();
    }

    @Test
    public void clickOnMenuDots() {
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.clickOnThreeDots();
        Assert.assertTrue(mainPageS.isJahKhalib());
    }

    @Test
    public void addSong_ToThe_PlayList(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.addSongToPlayList();
    }

    @Test
    public void OpenPlaylist_GoToArtistPage(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.openArtist();
        Assert.assertTrue(mainPageS.isArtist());
    }

    @Test
    public void addPodcastToPlayList(){ //It worked
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.adding_thePodcast_toThePlayList("Joe Rogan");
    }

    @Test
    public void removePodcast_fromPlayList(){ //it worked
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.removePodcast();
    }








    // add podcast to a play list -
    // remove podcast -

    // Remove a song +
    // add to a play list +
    // go to artist and go back and Assert it+

    // play song -> stop -> open favorites -> play song->stop.
    //open account profile and play a song


    // Test cases!
    // scroll,double click, and right click! +
    // Edit existing play list +
    // rename play list -> create and then rename
    // check the play list id and name were created
    // add songs to the play list
    // open podcast and play it
    // add song from one play list to another play list.
    // delete a song
    // play song -> stop -> open favorites -> play song->stop.
    // play podcast
    // open song options and try to do different steps! like add song to play list, then delete the song, go to album and play a song
    // play song -> stop -> open favorites -> play song->stop.
    //*** create and rename the play list
    //*** check that play list was created

    //search something in Google

}
