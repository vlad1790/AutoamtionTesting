package SpotifyTesting;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        String newName = faker.funnyName().name();
        System.out.println(newName);

        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.renamePlayList(newName);
    }

    @Test
    public void addSong_toPlaylist_successfully(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        MainPageS mainPageS = loginToPageS.logToSpotify(username,password);
        mainPageS.addSongToPlayList("God's Plan");
    }

    @Test
    public void addSong_fromOnePlayList_toAnother_PlayList(){

    }

    @Test
    public void removeSong_fromPlayList(){
        LoginToPageS loginToPageS = new LoginToPageS(driver);
        loginToPageS.open();
        loginToPageS.logToSpotify(username,password);
        loginToPageS.deleteSong();
    }

    @Test
    public void addFewSongs_toPlaylist_andPlayOneSong(){

    }



    @Test
    public void playsong_stopSong_Openfavorites_playSong_stopSong(){

    }



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
